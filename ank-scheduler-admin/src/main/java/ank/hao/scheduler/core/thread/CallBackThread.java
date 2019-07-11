package ank.hao.scheduler.core.thread;

import ank.hao.core.model.CallBackParam;
import ank.hao.core.model.ReturnT;
import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.enums.FailOverEnum;
import ank.hao.scheduler.core.enums.HandleStateEnum;
import ank.hao.scheduler.domain.MlSchedulerJobLog;
import ank.hao.scheduler.domain.MlSchedulerTaskInstance;
import ank.hao.scheduler.domain.MlSchedulerTaskInstanceLog;
import ank.hao.scheduler.domain.MlSchedulerTaskInstanceLogExample;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CallBackThread extends BaseService implements Runnable {

    private CallBackParam callBackParam;

    public CallBackThread(CallBackParam callBackParam){
        this.callBackParam = callBackParam;
    }

    @Override
    public void run() {

        Integer taskInstanceLogId = callBackParam.getTaskInstanceLogId();
        ReturnT returnT = callBackParam.getReturnT();

        //更新task_instance_log
        MlSchedulerTaskInstanceLog mlSchedulerTaskInstanceLog = mlSchedulerTaskInstanceLogMapper.selectByPrimaryKey(taskInstanceLogId);
        if(returnT.getCode() == ReturnT.SUCCESS.getCode()){
           handle_success(mlSchedulerTaskInstanceLog);
        } else if(returnT.getCode() == ReturnT.TIMEOUT.getCode()){
            //根据选择的超时处理机制处理
            MlSchedulerTaskInstance mlSchedulerTaskInstance = mlSchedulerTaskInstanceMapper.selectByPrimaryKey(mlSchedulerTaskInstanceLog.getTaskInstanceId());
            Integer failover = mlSchedulerTaskInstance.getFailover();
            if(failover == FailOverEnum.DO_NOTHING.getCode()){
                handle_success(mlSchedulerTaskInstanceLog);
            } else if(failover == FailOverEnum.FAIL_FULL.getCode()){
                handle_fail(mlSchedulerTaskInstanceLog);
            } else if(failover == FailOverEnum.RETRY.getCode()) {
                handle_retry(mlSchedulerTaskInstanceLog);
            } else {
                //do nothing
            }
        } else {
            //失败情况下处理
            handle_fail(mlSchedulerTaskInstanceLog);
        }
    }

    void handle_success(MlSchedulerTaskInstanceLog mlSchedulerTaskInstanceLog){
        mlSchedulerTaskInstanceLog.setTaskFinishTime(new Date());
        mlSchedulerTaskInstanceLog.setTaskState(HandleStateEnum.SUCCESS.getCode());
        mlSchedulerTaskInstanceLogMapper.updateByPrimaryKeySelective(mlSchedulerTaskInstanceLog);
        //如果是最后一个任务，需要更新作业状态
        MlSchedulerTaskInstanceLogExample mlSchedulerTaskInstanceLogExample = new MlSchedulerTaskInstanceLogExample();
        //如果所有task状态都是成功或失败，则说明作业结束
        List<Integer> stateList = Arrays.asList(HandleStateEnum.TO_RUN.getCode(),HandleStateEnum.RUNNING.getCode());
        mlSchedulerTaskInstanceLogExample.createCriteria().andJobLogIdEqualTo(mlSchedulerTaskInstanceLog.getJobLogId())
                .andTaskStateNotIn(stateList);
        if(CollectionUtils.isEmpty(mlSchedulerTaskInstanceLogMapper.selectByExample(mlSchedulerTaskInstanceLogExample))){
            MlSchedulerJobLog mlSchedulerJobLog = new MlSchedulerJobLog();
            mlSchedulerJobLog.setJobLogId(mlSchedulerTaskInstanceLog.getJobLogId());
            mlSchedulerJobLog.setJobHandleState(HandleStateEnum.SUCCESS.getCode());
            mlSchedulerJobLog.setJobHandleFinishTime(new Date());
            mlSchedulerJobLogMapper.updateByPrimaryKeySelective(mlSchedulerJobLog);
        }
    }

    void handle_fail(MlSchedulerTaskInstanceLog mlSchedulerTaskInstanceLog){
        mlSchedulerTaskInstanceLog.setTaskFinishTime(new Date());
        mlSchedulerTaskInstanceLog.setTaskState(HandleStateEnum.FAIL.getCode());
        mlSchedulerTaskInstanceLogMapper.updateByPrimaryKeySelective(mlSchedulerTaskInstanceLog);
        //默认单个任务失败处理规则：作业失败
        MlSchedulerTaskInstanceLogExample mlSchedulerTaskInstanceLogExample = new MlSchedulerTaskInstanceLogExample();
        //如果所有task状态都是成功或失败，则说明作业结束
        List<Integer> stateList = Arrays.asList(HandleStateEnum.TO_RUN.getCode(),HandleStateEnum.RUNNING.getCode());
        mlSchedulerTaskInstanceLogExample.createCriteria().andJobLogIdEqualTo(mlSchedulerTaskInstanceLog.getJobLogId())
                .andTaskStateIn(stateList);
        MlSchedulerTaskInstanceLog mlSchedulerTaskInstanceLog_fail = new MlSchedulerTaskInstanceLog();
        mlSchedulerTaskInstanceLog_fail.setTaskState(HandleStateEnum.FAIL.getCode());
        mlSchedulerTaskInstanceLog_fail.setTaskFinishTime(new Date());
        mlSchedulerTaskInstanceLogMapper.updateByExampleSelective(mlSchedulerTaskInstanceLog_fail,mlSchedulerTaskInstanceLogExample);

        //更新作业状态
        MlSchedulerJobLog mlSchedulerJobLog = new MlSchedulerJobLog();
        mlSchedulerJobLog.setJobLogId(mlSchedulerTaskInstanceLog.getJobLogId());
        mlSchedulerJobLog.setJobHandleState(HandleStateEnum.FAIL.getCode());
        mlSchedulerJobLog.setJobHandleFinishTime(new Date());
        mlSchedulerJobLogMapper.updateByPrimaryKeySelective(mlSchedulerJobLog);
    }

    void handle_retry(MlSchedulerTaskInstanceLog mlSchedulerTaskInstanceLog){
        mlSchedulerTaskInstanceLog.setTaskState(HandleStateEnum.TO_RUN.getCode());
        mlSchedulerTaskInstanceLogMapper.updateByPrimaryKeySelective(mlSchedulerTaskInstanceLog);
    }
}
