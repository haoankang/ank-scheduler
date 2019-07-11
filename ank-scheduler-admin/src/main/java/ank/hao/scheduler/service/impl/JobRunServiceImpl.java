package ank.hao.scheduler.service.impl;

import ank.hao.core.util.FeignUtil;
import ank.hao.scheduler.controller.model.JobHistoryVO;
import ank.hao.scheduler.controller.model.PageInfoTaskHistoryVO;
import ank.hao.scheduler.controller.model.PageInfoTaskHistoryVOData;
import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.enums.HandleStateEnum;
import ank.hao.scheduler.core.feign.ExecutorFeign;
import ank.hao.scheduler.domain.*;
import ank.hao.scheduler.service.JobRunService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Component
public class JobRunServiceImpl extends BaseService implements JobRunService {
    @Override
    public PageInfoTaskHistoryVO jobRunHistoryList(Integer jobId, Integer pageNo, Integer pageSize) {
        PageInfoTaskHistoryVO pageInfoTaskHistoryVO = new PageInfoTaskHistoryVO();
        List<JobHistoryVO> jobHistoryVOList = new ArrayList<>();
        //获取task信息pid
        MlSchedulerJob mlSchedulerJob = mlSchedulerJobMapper.selectByPrimaryKey(jobId);
        Integer pid = mlSchedulerJob.getPid();
        //获取同一pid的所有版本
        Map<Integer,String> map_taskName = new HashMap<>();
        Map<Integer,Integer> map_Version = new HashMap<>();
        MlSchedulerJobExample mlSchedulerJobExample = new MlSchedulerJobExample();
        mlSchedulerJobExample.createCriteria().andPidEqualTo(pid);
        mlSchedulerJobExample.setOrderByClause("VERSION DESC");
        List<MlSchedulerJob> mlSchedulerJobList = mlSchedulerJobMapper.selectByExample(mlSchedulerJobExample);
        for(MlSchedulerJob task_tmp:mlSchedulerJobList){
            map_taskName.put(task_tmp.getJobId(), task_tmp.getJobName());
            map_Version.put(task_tmp.getJobId(), task_tmp.getVersion());
        }
        //获取同一pid的所有运行历史
        Page page = PageHelper.startPage(pageNo, pageSize, true);
        MlSchedulerJobLogExample mlSchedulerJobLogExample = new MlSchedulerJobLogExample();
        mlSchedulerJobLogExample.createCriteria().andJobPidEqualTo(pid);
        mlSchedulerJobLogExample.setOrderByClause("JOB_TRIGGER_TIME DESC");
        List<MlSchedulerJobLog> scheduleTaskHistoryList = mlSchedulerJobLogMapper.selectByExample(mlSchedulerJobLogExample);
        if(!CollectionUtils.isEmpty(scheduleTaskHistoryList)){
            for(MlSchedulerJobLog scheduleTaskHistory: scheduleTaskHistoryList){
                jobHistoryVOList.add(convertHistory2VO(scheduleTaskHistory,map_taskName,map_Version));
            }
        }
        //names
        List<String> names = new ArrayList<>();
        names.add("taskRunId");
        names.add("taskName");
        names.add("taskVersion");
        names.add("executeTime");
        names.add("runState");
        names.add("runStartTime");
        names.add("runEndTime");
        //displayNames
        List<String> displayNames = new ArrayList<>();
        displayNames.add("执行id");
        displayNames.add("作业名称");
        displayNames.add("作业版本");
        displayNames.add("调度时间");
        displayNames.add("运行结果");
        displayNames.add("开始时间");
        displayNames.add("结束时间");
        PageInfoTaskHistoryVOData pageInfoTaskHistoryVOData = new PageInfoTaskHistoryVOData();
        pageInfoTaskHistoryVOData.setVoList(jobHistoryVOList);
        pageInfoTaskHistoryVOData.setNames(names);
        pageInfoTaskHistoryVOData.setDisplayNames(displayNames);
        pageInfoTaskHistoryVO.setData(pageInfoTaskHistoryVOData);
        //统计页面信息
        pageInfoTaskHistoryVO.setTotal(page.getTotal());
        pageInfoTaskHistoryVO.setPageNum(page.getPageNum());
        pageInfoTaskHistoryVO.setPageSize(page.getPageSize());
        pageInfoTaskHistoryVO.setSize(page.size());
        pageInfoTaskHistoryVO.setPages(page.getPages());
        return pageInfoTaskHistoryVO;
    }

    @Override
    public void jobRunStop(Integer jobId) {
        MlSchedulerJobLogExample scheduleTaskRunExample = new MlSchedulerJobLogExample();
        List<Integer> runList = new ArrayList<>();
        runList.add(HandleStateEnum.RUNNING.getCode());
        runList.add(HandleStateEnum.TO_RUN.getCode());
        scheduleTaskRunExample.createCriteria().andJobIdEqualTo(jobId).andJobHandleStateIn(runList);
        List<MlSchedulerJobLog> scheduleTaskRuns = mlSchedulerJobLogMapper.selectByExample(scheduleTaskRunExample);
        if(!CollectionUtils.isEmpty(scheduleTaskRuns)){
            for(MlSchedulerJobLog scheduleTaskRun:scheduleTaskRuns){
                MlSchedulerTaskInstanceLogExample scheduleRunDetailExample = new MlSchedulerTaskInstanceLogExample();
                scheduleRunDetailExample.createCriteria().andJobLogIdEqualTo(scheduleTaskRun.getJobLogId()).andTaskStateIn(runList);
                List<MlSchedulerTaskInstanceLog> scheduleRunDetailList = mlSchedulerTaskInstanceLogMapper.selectByExample(scheduleRunDetailExample);
                MlSchedulerTaskInstanceLog scheduleRunDetail2 = new MlSchedulerTaskInstanceLog();
                scheduleRunDetail2.setTaskState(HandleStateEnum.FAIL.getCode());
                mlSchedulerTaskInstanceLogMapper.updateByExampleSelective(scheduleRunDetail2,scheduleRunDetailExample);
                if(!CollectionUtils.isEmpty(scheduleRunDetailList)){
                    MlSchedulerTaskInstanceLog scheduleRunDetail = scheduleRunDetailList.get(0);
                    String address = scheduleRunDetail.getAddress();
                    if(!StringUtils.isEmpty(address)){
                        ExecutorFeign executorFeign = (ExecutorFeign) FeignUtil.getFeignClientAddHttp(ExecutorFeign.class, address);
                        executorFeign.stopService(scheduleRunDetail.getTaskInstanceLogId());
                    }
                }
            }
        }
        //更新数据库
        MlSchedulerJobLog scheduleTaskRun_stop = new MlSchedulerJobLog();
        scheduleTaskRun_stop.setJobHandleState(HandleStateEnum.FAIL.getCode());
        scheduleTaskRun_stop.setJobHandleFinishTime(new Date());
        mlSchedulerJobLogMapper.updateByExampleSelective(scheduleTaskRun_stop, scheduleTaskRunExample);
    }

    private JobHistoryVO convertHistory2VO(MlSchedulerJobLog scheduleTaskHistory, Map<Integer, String> map_taskName, Map<Integer, Integer> map_Version){
        JobHistoryVO taskHistoryVO = new JobHistoryVO();
        taskHistoryVO.setJobRunId(scheduleTaskHistory.getJobLogId());
        taskHistoryVO.setJobName(map_taskName.get(scheduleTaskHistory.getJobId()));
        taskHistoryVO.setJobVersion("V"+map_Version.get(scheduleTaskHistory.getJobId()));
        taskHistoryVO.setExecuteTime(scheduleTaskHistory.getJobTriggerTime().getTime());
        taskHistoryVO.setRunState(scheduleTaskHistory.getJobHandleState());
        if(scheduleTaskHistory.getJobHandleTime()!=null){
            taskHistoryVO.setRunStartTime(scheduleTaskHistory.getJobHandleTime().getTime());
        }
        if(scheduleTaskHistory.getJobHandleFinishTime()!=null){
            taskHistoryVO.setRunEndTime(scheduleTaskHistory.getJobHandleFinishTime().getTime());
        }
        return taskHistoryVO;
    }
}
