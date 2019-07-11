package ank.hao.scheduler.core.hanndler.impl;

import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.enums.HandleStateEnum;
import ank.hao.scheduler.core.exception.InternalServerException;
import ank.hao.scheduler.core.hanndler.TaskHandler;
import ank.hao.scheduler.domain.*;
import com.alibaba.fastjson.JSON;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CronTaskHandler extends QuartzJobBean implements TaskHandler {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        String scheduleTaskString = (String) jobExecutionContext.getMergedJobDataMap().get("job");
        MlSchedulerJob job = JSON.parseObject(scheduleTaskString, MlSchedulerJob.class);

        //校验
        MlSchedulerTaskInstanceExample mlSchedulerTaskInstanceExample = new MlSchedulerTaskInstanceExample();
        mlSchedulerTaskInstanceExample.createCriteria().andJobIdEqualTo(job.getJobId());
        List<MlSchedulerTaskInstance> mlSchedulerTaskMappingJobList = BaseService.getBaseService().getMlSchedulerTaskInstanceMapper().selectByExampleWithBLOBs(mlSchedulerTaskInstanceExample);
        if(CollectionUtils.isEmpty(mlSchedulerTaskMappingJobList)){
            throw new InternalServerException("作业中没有可执行的任务！");
        }

        //新增相应记录，用数据库代替消息队列
        //job-log
        MlSchedulerJobLog mlSchedulerJobLog = new MlSchedulerJobLog();
        mlSchedulerJobLog.setJobId(job.getJobId());
        mlSchedulerJobLog.setJobPid(job.getPid());
        mlSchedulerJobLog.setJobTriggerTime(new Date());
        mlSchedulerJobLog.setJobHandleState(HandleStateEnum.TO_RUN.getCode());
        BaseService.getBaseService().getMlSchedulerJobLogMapper().insertSelective(mlSchedulerJobLog);

        //判断是否存在依赖关系
        Integer dependId = validateTaskRun(job,mlSchedulerJobLog.getJobLogId());
        if(dependId.intValue()==0){
            dependId = mlSchedulerJobLog.getJobLogId();
        }

        //task-log
        for(MlSchedulerTaskInstance mlSchedulerTaskInstance:mlSchedulerTaskMappingJobList){
            MlSchedulerTaskInstanceLog mlSchedulerTaskInstanceLog = new MlSchedulerTaskInstanceLog();
            mlSchedulerTaskInstanceLog.setJobLogId(mlSchedulerJobLog.getJobLogId());
            mlSchedulerTaskInstanceLog.setTaskInstanceId(mlSchedulerTaskInstance.getTaskInstanceId());
            mlSchedulerTaskInstanceLog.setTaskState(HandleStateEnum.TO_RUN.getCode());
            mlSchedulerTaskInstanceLog.setCreateTime(new Date());
            mlSchedulerTaskInstanceLog.setDependId(dependId);
            BaseService.getBaseService().getMlSchedulerTaskInstanceLogMapper().insertSelective(mlSchedulerTaskInstanceLog);
        }
    }

    private Integer validateTaskRun(MlSchedulerJob job,Integer jobLogId) {
        Integer dependId = 0;
        if(job.getDependformer()){
            MlSchedulerJobLogExample mlSchedulerJobLogExample = new MlSchedulerJobLogExample();
            List<Integer> task2runList = new ArrayList<>();
            task2runList.add(HandleStateEnum.TO_RUN.getCode());
            task2runList.add(HandleStateEnum.RUNNING.getCode());
            mlSchedulerJobLogExample.createCriteria().andJobIdEqualTo(job.getJobId()).andJobHandleStateIn(task2runList).andJobLogIdNotEqualTo(jobLogId);
            mlSchedulerJobLogExample.setOrderByClause("JOB_LOG_ID DESC");
            List<MlSchedulerJobLog> mlSchedulerJobLogList = BaseService.getBaseService().getMlSchedulerJobLogMapper().selectByExample(mlSchedulerJobLogExample);
            if(!CollectionUtils.isEmpty(mlSchedulerJobLogList)){
                MlSchedulerJobLog scheduleTaskRun_depend = mlSchedulerJobLogList.get(0);
                MlSchedulerTaskInstanceLogExample mlSchedulerTaskInstanceLogExample = new MlSchedulerTaskInstanceLogExample();
                mlSchedulerTaskInstanceLogExample.createCriteria().andJobLogIdEqualTo(scheduleTaskRun_depend.getJobLogId());
                List<MlSchedulerTaskInstanceLog> scheduleRunDetails = BaseService.getBaseService().getMlSchedulerTaskInstanceLogMapper().selectByExample(mlSchedulerTaskInstanceLogExample);
                if(!CollectionUtils.isEmpty(scheduleRunDetails)){
                    dependId = scheduleRunDetails.get(0).getDependId();
                }
            }
        }

        return dependId;
    }
}
