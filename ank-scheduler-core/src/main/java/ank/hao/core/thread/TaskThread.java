package ank.hao.core.thread;

import ank.hao.core.component.BaseComponent;
import ank.hao.core.log.ExecutorLog;
import ank.hao.core.model.CallBackParam;
import ank.hao.core.model.ExecutorParam;
import ank.hao.core.model.ReturnT;
import ank.hao.core.startup.TaskRegistry;
import ank.hao.core.task.IAnkTask;
import ank.hao.core.task.IAnkTaskNeedStop;
import ank.hao.core.task.IAnkTaskNoNeedStop;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.*;

public class TaskThread implements Runnable {

    private ExecutorParam executorParam;

    public TaskThread(ExecutorParam param){
        this.executorParam = param;
    }

    @Override
    public void run() {
        //执行任务
        ReturnT returnT = null;
        long timeout = executorParam.getTimeout();
        IAnkTask ankTask = TaskRegistry.serviceMap.get(executorParam.getTaskName());
        TaskRegistry.serviceStopMap.put(executorParam.getTaskInstanceLogId(), ankTask);
        //扩展执行前方法
        ankTask.beforeExecute();

        //任务执行，有超时时间和无超时时间
        if(timeout>0){
            try {
                FutureTask<ReturnT> futureTask = new FutureTask<ReturnT>(() -> ankTask.execute(executorParam.getTaskParam()));
                Thread taskRunThread = new Thread(futureTask);
                taskRunThread.start();
                returnT = futureTask.get(timeout, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException ee) {
                returnT = ReturnT.FAIL;
                ExecutorLog.errorLog("任务异常，异常信息：{}", ee.getMessage());
            } catch (TimeoutException e) {
                //超时处理
                returnT = ReturnT.TIMEOUT;
                ExecutorLog.infoLog("任务超时，任务信息：{}", executorParam);
            }
        }else{
            returnT = ankTask.execute(executorParam.getTaskParam());
        }
        //结果回调
        CallBackParam callBackParam = new CallBackParam();
        callBackParam.setReturnT(returnT);
        callBackParam.setTaskInstanceLogId(executorParam.getTaskInstanceLogId());
        //后续可根据返回结果，执行一些细节优化，例如失败重试
        String string = BaseComponent.getBaseComponent().getSchedulerFeign().executorCallback(callBackParam);
        ExecutorLog.infoLog("回调结果：{}",string);

        ankTask.afterExecute();

    }
}
