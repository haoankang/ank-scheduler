package ank.hao.scheduler.service.impl;

import ank.hao.scheduler.controller.model.*;
import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.component.SystemConstant;
import ank.hao.scheduler.core.enums.DeleteFlagEnum;
import ank.hao.scheduler.core.enums.HandleStateEnum;
import ank.hao.scheduler.core.enums.ScheduleModeEnum;
import ank.hao.scheduler.core.enums.StateEnum;
import ank.hao.scheduler.core.exception.InternalServerException;
import ank.hao.scheduler.core.exception.InvalidRequestParamException;
import ank.hao.scheduler.core.schedule.MyScheduler;
import ank.hao.scheduler.domain.*;
import ank.hao.scheduler.service.JobService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Slf4j
public class JobServiceImpl extends BaseService implements JobService {
    @Override
    public void activeJob(Integer jobId) {
        MlSchedulerJob mlSchedulerJob = mlSchedulerJobMapper.selectByPrimaryKey(jobId);
        if(mlSchedulerJob==null){
            throw new InternalServerException("找不到对应的作业！");
        }
        //quartz调用
        ScheduleModeEnum scheduleMode = ScheduleModeEnum.CRON;
        MyScheduler myScheduler = applicationContext.getBean(scheduleMode.getSchduler(), MyScheduler.class);
        myScheduler.run(mlSchedulerJob);

        //更新记录
        mlSchedulerJob.setState(StateEnum.PUBLISH.getCode());
        mlSchedulerJob.setUpdateOper(userClient.getCurrentUserName());
        mlSchedulerJob.setUpdateTime(new Date());
        mlSchedulerJobMapper.updateByPrimaryKeySelective(mlSchedulerJob);
    }

    @Override
    public void jobAdd(JobAddVO jobAddVO) {
        String jobName = jobAddVO.getJobName();
        String cronExpression = jobAddVO.getCronExpression();
        String cronJson = jobAddVO.getCronJson();
        Boolean dependFormer = jobAddVO.isDependFormer();
        Double timeout = jobAddVO.getTimeout();
        Boolean runImmediately = jobAddVO.isRunImmediately();
        TaskListInfo taskListInfo = jobAddVO.getJobBaseInfo();
        ConditionInfo conditionInfo = jobAddVO.getConditionInfo();
        //作业名称不能重复
        MlSchedulerJobExample mlSchedulerJobExample = new MlSchedulerJobExample();
        mlSchedulerJobExample.or().andJobNameEqualTo(jobName).andDeleteFlagEqualTo(DeleteFlagEnum.UNDELETE.getCode());
        List<MlSchedulerJob> mlSchedulerJobs = mlSchedulerJobMapper.selectByExample(mlSchedulerJobExample);
        if(!CollectionUtils.isEmpty(mlSchedulerJobs)){
            throw new InvalidRequestParamException("作业名称:"+jobName+"已使用，不可以重复！");
        }
        //新增job记录
        MlSchedulerJob job = new MlSchedulerJob();
        job.setJobName(jobName);
        job.setVersion(SystemConstant.VERSION_START_INDEX);
        job.setCronExpression(cronExpression);
        job.setCronJson(cronJson);
        job.setDependformer(dependFormer);
        job.setTimeout(timeout);
        job.setRunimmediately(runImmediately);
        job.setJobdetailInfo(JSON.toJSONBytes(jobAddVO.getJobBaseInfo()));
        job.setConditionInfo(JSON.toJSONBytes(conditionInfo));
        job.setState(StateEnum.UNPUBLISH.getCode());
        job.setDeleteFlag(DeleteFlagEnum.UNDELETE.getCode());
        job.setCreateTime(new Date());
        job.setUpdateTime(new Date());
        job.setCreateOper(userClient.getCurrentUserName());
        job.setUpdateOper(userClient.getCurrentUserName());
        job.setComment(JSON.toJSONBytes(jobAddVO.getComment()));
        mlSchedulerJobMapper.insert(job);
        job.setPid(job.getJobId());
        mlSchedulerJobMapper.updateByPrimaryKeySelective(job);
        //新增taskMjob记录
        Map<Integer, Integer> tmp_map = new HashMap<>();
        for(TaskMJobInfo taskMJobInfo:taskListInfo){
            Integer id = taskMJobInfo.getId();
            List<Integer> preIds = taskMJobInfo.getPreId();
            //获取preTaskInstanceId
            StringBuilder preTaskInstanceId = new StringBuilder();
            if(!CollectionUtils.isEmpty(preIds)){
                for(Integer xx: preIds){
                    preTaskInstanceId.append(tmp_map.get(xx));
                    preTaskInstanceId.append(",");
                }
                preTaskInstanceId.deleteCharAt(preTaskInstanceId.length()-1);
            }
            //新增记录
            MlSchedulerTaskInstance mlSchedulerTaskMappingJob = new MlSchedulerTaskInstance();
            mlSchedulerTaskMappingJob.setJobId(job.getJobId());
            mlSchedulerTaskMappingJob.setTaskId(taskMJobInfo.getTaskId());
            mlSchedulerTaskMappingJob.setPreTaskInstanceId(preTaskInstanceId.toString());
            mlSchedulerTaskMappingJob.setInputValue(JSON.toJSONBytes(taskMJobInfo.getParams()));
            mlSchedulerTaskMappingJob.setRouteStategy(taskMJobInfo.getRouteStategy());
            mlSchedulerTaskMappingJob.setFailover(taskMJobInfo.getFailover());
            mlSchedulerTaskMappingJob.setFailoverValue(taskMJobInfo.getFailoverValue());
            mlSchedulerTaskMappingJob.setReadTimeout(taskMJobInfo.getTimeout());
            mlSchedulerTaskMappingJob.setCreateTime(new Date());
            mlSchedulerTaskMappingJob.setUpdateTime(new Date());
            mlSchedulerTaskInstanceMapper.insertSelective(mlSchedulerTaskMappingJob);
            //记录tmp_map
            tmp_map.put(id, mlSchedulerTaskMappingJob.getTaskInstanceId());
        }
    }

    @Override
    public void taskDelete(List<Integer> jobIdList) {
        MlSchedulerJobExample mlSchedulerJobExample = new MlSchedulerJobExample();
        mlSchedulerJobExample.createCriteria().andJobIdIn(jobIdList).andStateEqualTo(StateEnum.PUBLISH.getCode());
        //检查是否有上线的项目作业
        List<MlSchedulerJob> mlSchedulerJobs = mlSchedulerJobMapper.selectByExample(mlSchedulerJobExample);
        if(!CollectionUtils.isEmpty(mlSchedulerJobs)){
            throw new InvalidRequestParamException("不能删除在上线的作业，请先下线再删除");
        }

        MlSchedulerJobExample mlSchedulerJobExample1 = new MlSchedulerJobExample();
        mlSchedulerJobExample1.createCriteria().andJobIdIn(jobIdList);
        MlSchedulerJob job = new MlSchedulerJob();
        job.setDeleteFlag(DeleteFlagEnum.DELETED.getCode());
        job.setUpdateTime(new Date());
        job.setUpdateOper(userClient.getCurrentUserName());
        mlSchedulerJobMapper.updateByExampleSelective(job, mlSchedulerJobExample1);
    }

    @Override
    public TableData jobList() {
        TableData tableData = new TableData();

        List<JobInfoVO> jobInfoVOList = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> displayNames = new ArrayList<>();
        MlSchedulerJobExample mlSchedulerJobExample = new MlSchedulerJobExample();
        mlSchedulerJobExample.or().andDeleteFlagEqualTo(DeleteFlagEnum.UNDELETE.getCode());
        mlSchedulerJobExample.setOrderByClause("UPDATE_TIME DESC");
        List<MlSchedulerJob> mlSchedulerJobList = mlSchedulerJobMapper.selectByExampleWithBLOBs(mlSchedulerJobExample);
        if(!CollectionUtils.isEmpty(mlSchedulerJobList)){
            for(MlSchedulerJob mlSchedulerJob: mlSchedulerJobList){
                JobInfoVO jobInfoVO = convertJob2JobInfoVO(mlSchedulerJob);
                jobInfoVOList.add(jobInfoVO);
            }
        }
        //names for front
        names.add("jobId");
        names.add("jobName");
        names.add("indateRange");
        names.add("runState");
        names.add("updateOper");
        names.add("updateTime");
        names.add("comment");
        //displayNames for front
        displayNames.add("作业id");
        displayNames.add("作业名称");
        displayNames.add("生效时间");
        displayNames.add("运行状态");
        displayNames.add("更新者");
        displayNames.add("更新时间");
        displayNames.add("备注");

        tableData.setData(jobInfoVOList);
        tableData.setNames(names);
        tableData.setDisplayNames(displayNames);
        return tableData;
    }

    @Override
    public JobDetailVO jobQuery(Integer jobId) {
        MlSchedulerJob job = mlSchedulerJobMapper.selectByPrimaryKey(jobId);
        if(job==null){
            throw new InternalServerException("when query job,job can not be null,the jobId is: "+jobId);
        }
        JobDetailVO jobDetailVO = convertJob2JobUpdateVO(job);

        return jobDetailVO;
    }

    @Override
    public Integer jobRollback(Integer jobId) {
        //获取所有历史版本
        List<MlSchedulerJob> mlSchedulerJobList = getJobVersionList(jobId);
        if(CollectionUtils.isEmpty(mlSchedulerJobList)){
            log.error("查询不到作业的版本信息,jobId={}", jobId);
            throw new InvalidRequestParamException("查询不到作业的版本信息");
        }
        //检查是否可以回滚
        MlSchedulerJob scheduleTask_latest = mlSchedulerJobList.get(0);
        if(jobId.equals(scheduleTask_latest.getJobId())){
            throw new InvalidRequestParamException("当前版本已经是最新版本，无法回滚");
        }
        if(scheduleTask_latest.getState()==StateEnum.PUBLISH.getCode()){
            throw new InvalidRequestParamException("当前作业已上线，无法回滚");
        }
        //回滚
        MlSchedulerJob scheduleTask_now = mlSchedulerJobMapper.selectByPrimaryKey(jobId);
        scheduleTask_now.setUpdateContent("V"+scheduleTask_now.getVersion()+"版本回滚");
        scheduleTask_now.setVersion(scheduleTask_latest.getVersion()+1);
        scheduleTask_now.setDeleteFlag(DeleteFlagEnum.UNDELETE.getCode());
        scheduleTask_now.setUpdateOper(userClient.getCurrentUserName());
        scheduleTask_now.setUpdateTime(new Date());
        mlSchedulerJobMapper.insert(scheduleTask_now);

        scheduleTask_latest.setDeleteFlag(DeleteFlagEnum.DELETED.getCode());
        scheduleTask_latest.setUpdateTime(new Date());
        scheduleTask_latest.setUpdateOper(userClient.getCurrentUserName());
        mlSchedulerJobMapper.updateByPrimaryKeySelective(scheduleTask_latest);
        return scheduleTask_now.getJobId();
    }

    @Override
    public Integer taskUpdate(JobUpdateVO jobUpdateVO) {

        MlSchedulerJob job_parent = mlSchedulerJobMapper.selectByPrimaryKey(jobUpdateVO.getJobId());
        if(job_parent == null){
            throw new InternalServerException("job is null,the jobId is: "+jobUpdateVO.getJobId());
        }
        if(job_parent.getState() == StateEnum.PUBLISH.getCode()){
            throw new InvalidRequestParamException("项目已上线，无法更新，请先下线再操作");
        }
        JobAddVO jobAddVO = jobUpdateVO.getJobAddVO();

        String jobName = jobAddVO.getJobName();
        String cronExpression = jobAddVO.getCronExpression();
        String cronJson = jobAddVO.getCronJson();
        Boolean dependFormer = jobAddVO.isDependFormer();
        Double timeout = jobAddVO.getTimeout();
        Boolean runImmediately = jobAddVO.isRunImmediately();
        TaskListInfo taskListInfo = jobAddVO.getJobBaseInfo();
        ConditionInfo conditionInfo = jobAddVO.getConditionInfo();

        //比较变更
        String updateContent = getUpdateContent(jobUpdateVO, job_parent);
        if(StringUtils.isEmpty(updateContent)){
            throw new InvalidRequestParamException("当前操作未对作业进行修改");
        }

        MlSchedulerJob job = new MlSchedulerJob();
        job.setJobName(jobName);
        job.setVersion(job_parent.getVersion()+1);
        job.setCronExpression(cronExpression);
        job.setCronJson(cronJson);
        job.setDependformer(dependFormer);
        job.setTimeout(timeout);
        job.setRunimmediately(runImmediately);
        job.setJobdetailInfo(JSON.toJSONBytes(taskListInfo));
        job.setConditionInfo(JSON.toJSONBytes(conditionInfo));
        job.setState(StateEnum.UNPUBLISH.getCode());
        job.setPid(job_parent.getPid());
        job.setDeleteFlag(DeleteFlagEnum.UNDELETE.getCode());
        job.setCreateTime(new Date());
        job.setUpdateTime(new Date());
        job.setCreateOper(userClient.getCurrentUserName());
        job.setUpdateOper(userClient.getCurrentUserName());
        job.setComment(JSON.toJSONBytes(jobAddVO.getComment()));
        job.setUpdateContent(updateContent);
        mlSchedulerJobMapper.insert(job);

        job_parent.setDeleteFlag(DeleteFlagEnum.DELETED.getCode());
        job_parent.setState(StateEnum.UNPUBLISH.getCode());
        job_parent.setUpdateTime(new Date());
        job_parent.setUpdateOper(userClient.getCurrentUserName());
        mlSchedulerJobMapper.updateByPrimaryKeySelective(job_parent);
        return job.getJobId();
    }

    @Override
    public JobVersionVOList queryJobVersionList(Integer jobId) {
        JobVersionVOList jobVersionVOList = new JobVersionVOList();
        List<JobVersionVO> jobVersionVOS = new ArrayList<>();
        MlSchedulerJob mlSchedulerJob = mlSchedulerJobMapper.selectByPrimaryKey(jobId);
        if(mlSchedulerJob==null){
            log.error("查询不到作业的详细信息, jobId={}", jobId);
            throw new InternalServerException("查询不到作业的详细信息");
        }
        //获取所有历史版本
        List<MlSchedulerJob> mlSchedulerJobList = getJobVersionList(jobId);
        //转换展示
        for(MlSchedulerJob scheduleTask_tmp: mlSchedulerJobList){
            jobVersionVOS.add(convertJob2JobVersionVO(scheduleTask_tmp));
        }
        //names for front
        List<String> names = new ArrayList<>();
        List<String> displayNames = new ArrayList<>();
        names.add("jobId");
        names.add("jobVersion");
        names.add("updateContent");
        names.add("updateOper");
        names.add("updateTime");
        names.add("comment");
        //displayNames for front
        displayNames.add("作业id");
        displayNames.add("版本");
        displayNames.add("更新内容");
        displayNames.add("更新者");
        displayNames.add("更新时间");
        displayNames.add("备注");

        jobVersionVOList.setData(jobVersionVOS);
        jobVersionVOList.setNames(names);
        jobVersionVOList.setDisplayNames(displayNames);
        return jobVersionVOList;
    }

    @Override
    public void cancelJob(Integer jobId) {
        //运行中的任务不允许下线
        Integer runState = getRunState(jobId);
        if(runState==HandleStateEnum.RUNNING.getCode()){
            throw new InvalidRequestParamException("运行中的作业不可以下线");
        }
        MlSchedulerJob job = mlSchedulerJobMapper.selectByPrimaryKey(jobId);
        ScheduleModeEnum scheduleMode = ScheduleModeEnum.CRON;
        MyScheduler myScheduler = applicationContext.getBean(scheduleMode.getSchduler(), MyScheduler.class);
        myScheduler.stop(job);
        //修改数据表
        job.setUpdateTime(new Date());
        job.setUpdateOper(userClient.getCurrentUserName());
        job.setState(StateEnum.UNPUBLISH.getCode());
        mlSchedulerJobMapper.updateByPrimaryKeySelective(job);
    }

    private JobVersionVO convertJob2JobVersionVO(MlSchedulerJob job){
        JobVersionVO jobVersionVO = new JobVersionVO();
        jobVersionVO.setJobId(job.getJobId());
        jobVersionVO.setJobVersion("V"+job.getVersion());
        jobVersionVO.setUpdateContent(job.getUpdateContent());
        jobVersionVO.setUpdateOper(job.getUpdateOper());
        jobVersionVO.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(job.getUpdateTime()));
        jobVersionVO.setComment(JSON.parseObject(job.getComment(), String.class));
        return jobVersionVO;
    }

    private String getUpdateContent(JobUpdateVO jobUpdateVO, MlSchedulerJob job_parent) {
        StringBuilder result = new StringBuilder();

        JobAddVO job_update = jobUpdateVO.getJobAddVO();
        //比较基础信息
        if((!job_parent.getJobName().equals(job_update.getJobName()))||(!JSON.parseObject(job_parent.getJobdetailInfo(), TaskListInfo.class).equals(job_update.getJobBaseInfo()))){
            result.append("修改基础信息");
        }
        //比较调度参数
        if((!(job_parent.getDependformer().booleanValue()==job_update.isDependFormer().booleanValue())) ||
                (!(job_parent.getTimeout().intValue()==job_update.getTimeout().intValue())) ||
                (!(job_parent.getRunimmediately().booleanValue()==job_update.isRunImmediately().booleanValue())) ||
                (!(job_parent.getCronExpression().equals(job_update.getCronExpression()))) ||
                (!(JSON.parseObject(job_parent.getConditionInfo(),ConditionInfo.class).equals(job_update.getConditionInfo())))){
            if(result.length()>0){
                result.append(",");
            }
            result.append("修改调度参数");
        }

        //比较备注
        String comment_parent = JSON.parseObject(job_parent.getComment(), String.class);
        String comment_update = job_update.getComment();
        if(!((StringUtils.isEmpty(comment_parent) && StringUtils.isEmpty(comment_update))||(comment_parent.equals(comment_update)))){
            if(result.length()>0){
                result.append(",");
            }
            result.append("修改备注");
        }

        return result.toString();
    }

    //根据一个作业查询它的所有版本（历史或未来）,并按版本逆序返回列表
    private List<MlSchedulerJob> getJobVersionList(Integer jobId){
        List<MlSchedulerJob> mlSchedulerJobList = new ArrayList<>();
        //查询当前作业信息
        MlSchedulerJob scheduleTask_now = mlSchedulerJobMapper.selectByPrimaryKey(jobId);
        //获取所有版本列表
        MlSchedulerJobExample mlSchedulerJobExample = new MlSchedulerJobExample();
        mlSchedulerJobExample.createCriteria().andPidEqualTo(scheduleTask_now.getPid());
        mlSchedulerJobExample.setOrderByClause("VERSION DESC");
        List<MlSchedulerJob> scheduleTaskList1 = mlSchedulerJobMapper.selectByExampleWithBLOBs(mlSchedulerJobExample);
        mlSchedulerJobList.addAll(scheduleTaskList1);

        return mlSchedulerJobList;
    }

    private JobDetailVO convertJob2JobUpdateVO(MlSchedulerJob job){
        JobDetailVO jobDetailVO = new JobDetailVO();
        jobDetailVO.setJobId(job.getJobId());
        jobDetailVO.setJobName(job.getJobName());
        jobDetailVO.setCronJson(job.getCronJson());
        jobDetailVO.setCronExpression(job.getCronExpression());
        jobDetailVO.setDependFormer(job.getDependformer());
        jobDetailVO.setTimeout(job.getTimeout());
        jobDetailVO.setRunImmediately(job.getRunimmediately());
        jobDetailVO.setComment(JSON.parseObject(job.getComment(), String.class));
        jobDetailVO.setJobBaseInfo(JSON.parseObject(job.getJobdetailInfo(), TaskListInfo.class));
        jobDetailVO.setConditionInfo(JSON.parseObject(job.getConditionInfo(), ConditionInfo.class));
        return jobDetailVO;
    }

    private JobInfoVO convertJob2JobInfoVO(MlSchedulerJob job){
        JobInfoVO jobInfoVO = new JobInfoVO();
        jobInfoVO.setJobId(job.getJobId());
        jobInfoVO.setJobName(job.getJobName());
        //indate
        ConditionInfo conditionInfo = JSON.parseObject(job.getConditionInfo(),ConditionInfo.class);
        StringBuilder indateRange = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        indateRange.append("(").append(simpleDateFormat.format(conditionInfo.getIndateStartTime())).append(",").append(simpleDateFormat.format(conditionInfo.getIndateEndTime())).append(")");
        jobInfoVO.setIndateRange(indateRange.toString());
        jobInfoVO.setRunState(job.getState());
        jobInfoVO.setUpdateOper(job.getUpdateOper());
        jobInfoVO.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(job.getUpdateTime()));
        jobInfoVO.setComment(JSON.parseObject(job.getComment(), String.class));
        jobInfoVO.setState(job.getState());
        return jobInfoVO;
    }
    //获取运行状态
    private Integer getRunState(Integer jobId){
        Integer runState = HandleStateEnum.TO_RUN.getCode();
        MlSchedulerJobLogExample mlSchedulerJobLogExample = new MlSchedulerJobLogExample();
        mlSchedulerJobLogExample.createCriteria().andJobIdEqualTo(jobId);
        mlSchedulerJobLogExample.setOrderByClause("JOB_TRIGGER_TIME DESC");
        List<MlSchedulerJobLog> mlSchedulerJobLogList = mlSchedulerJobLogMapper.selectByExample(mlSchedulerJobLogExample);
        if(!CollectionUtils.isEmpty(mlSchedulerJobLogList)){
            runState = mlSchedulerJobLogList.get(0).getJobHandleState();
            if(runState == HandleStateEnum.TO_RUN.getCode()){
                runState = HandleStateEnum.RUNNING.getCode();
            }
        }
        return runState;
    }
}
