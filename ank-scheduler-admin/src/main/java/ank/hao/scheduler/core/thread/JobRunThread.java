package ank.hao.scheduler.core.thread;

import ank.hao.core.model.ExecutorParam;
import ank.hao.core.model.ReturnT;
import ank.hao.core.util.FeignUtil;
import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.enums.HandleStateEnum;
import ank.hao.scheduler.core.enums.RouteStategyEnum;
import ank.hao.scheduler.core.exception.InternalServerException;
import ank.hao.scheduler.core.feign.ExecutorFeign;
import ank.hao.scheduler.domain.*;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//任务执行线程
@Slf4j
public class JobRunThread extends BaseService implements Runnable {

    private Integer taskToRunId;

    public JobRunThread(Integer taskToRunId){
        this.taskToRunId = taskToRunId;
    }

    @Override
    public void run() {
        log.info("开始执行任务，任务id是：{}", taskToRunId);
        //获取执行任务所需信息
        //task_instance_log
        MlSchedulerTaskInstanceLog mlSchedulerTaskInstanceLog = mlSchedulerTaskInstanceLogMapper.selectByPrimaryKey(taskToRunId);
        //job_log
        MlSchedulerJobLog mlSchedulerJobLog = mlSchedulerJobLogMapper.selectByPrimaryKey(mlSchedulerTaskInstanceLog.getJobLogId());
        //job
        MlSchedulerJob mlSchedulerJob = mlSchedulerJobMapper.selectByPrimaryKey(mlSchedulerJobLog.getJobId());
        //task_instance
        MlSchedulerTaskInstance mlSchedulerTaskInstance = mlSchedulerTaskInstanceMapper.selectByPrimaryKey(mlSchedulerTaskInstanceLog.getTaskInstanceId());
        //task
        MlSchedulerTask mlSchedulerTask = mlSchedulerTaskMapper.selectByPrimaryKey(mlSchedulerTaskInstance.getTaskId());

        //再检查要执行任务的最新状态，防止多台服务器同时执行引发问题
        if(mlSchedulerTaskInstanceLog.getTaskState()!=HandleStateEnum.TO_RUN.getCode()){
            return;
        }
        //更新任务状态
        mlSchedulerTaskInstanceLog.setTaskState(HandleStateEnum.RUNNING.getCode());
        mlSchedulerTaskInstanceLog.setTaskHandleTime(new Date());
        mlSchedulerTaskInstanceLogMapper.updateByPrimaryKeySelective(mlSchedulerTaskInstanceLog);
        //更新作业状态
        switch (mlSchedulerJobLog.getJobHandleState().intValue()){
            case 3: //未运行时状态改为运行
                mlSchedulerJobLog.setJobHandleState(HandleStateEnum.RUNNING.getCode());break;
            case 0: //运行时do nothing
                break;
            default: //成功或者失败，则说明外部中断，直接返回
                return;
        }
        if(mlSchedulerJobLog.getJobHandleTime()==null){
            mlSchedulerJobLog.setJobHandleTime(new Date());
        }
        mlSchedulerJobLogMapper.updateByPrimaryKeySelective(mlSchedulerJobLog);

        //执行task
        ReturnT returnT = do_execute(mlSchedulerTask,mlSchedulerTaskInstance,mlSchedulerTaskInstanceLog);

        if(returnT.getCode()!=200){
            mlSchedulerTaskInstanceLog.setTaskState(HandleStateEnum.FAIL.getCode());
            mlSchedulerTaskInstanceLog.setTaskFinishTime(new Date());
            mlSchedulerTaskInstanceLogMapper.updateByPrimaryKeySelective(mlSchedulerTaskInstanceLog);
        }

    }

    private ReturnT do_execute(MlSchedulerTask mlSchedulerTask,
                            MlSchedulerTaskInstance mlSchedulerTaskInstance, MlSchedulerTaskInstanceLog mlSchedulerTaskInstanceLog){
        //组装参数
        ExecutorParam executorParam = new ExecutorParam();
        executorParam.setTaskName(mlSchedulerTask.getTaskName());
        executorParam.setTaskParam(JSON.parseObject(mlSchedulerTaskInstance.getInputValue(), String.class));
        executorParam.setTimeout(Long.valueOf(mlSchedulerTaskInstance.getReadTimeout()));
        executorParam.setTaskInstanceLogId(mlSchedulerTaskInstanceLog.getTaskInstanceLogId());
        //选择执行器
        String url = routeUrl(mlSchedulerTask.getAppName(),mlSchedulerTaskInstance.getRouteStategy());
        //更新url到数据库，用于停止任务
        mlSchedulerTaskInstanceLog.setAddress(url);
        mlSchedulerTaskInstanceLogMapper.updateByPrimaryKeySelective(mlSchedulerTaskInstanceLog);
        //执行
        ExecutorFeign executorFeign = (ExecutorFeign) FeignUtil.getFeignClientAddHttp(ExecutorFeign.class, url);
        try {
            return executorFeign.executorService(executorParam);
        } catch (Exception e){
            return ReturnT.FAIL;
        }
    }
}
