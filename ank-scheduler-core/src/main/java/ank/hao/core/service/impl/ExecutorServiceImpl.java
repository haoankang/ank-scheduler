package ank.hao.core.service.impl;

import ank.hao.core.log.ExecutorLog;
import ank.hao.core.model.ExecutorParam;
import ank.hao.core.model.GetArgsParam;
import ank.hao.core.model.ReturnT;
import ank.hao.core.service.ExecutorService;
import ank.hao.core.startup.TaskRegistry;
import ank.hao.core.task.IAnkTask;
import ank.hao.core.thread.AnkThreadPool;
import ank.hao.core.thread.TaskThread;
import org.springframework.stereotype.Component;

@Component
public class ExecutorServiceImpl implements ExecutorService {
    @Override
    public ReturnT<String> executeService(ExecutorParam param) {
        String taskName = param.getTaskName();

        IAnkTask ankTask = TaskRegistry.serviceMap.get(taskName);
        if(ankTask==null){
            ExecutorLog.errorLog("查询不到服务，执行任务信息：{}", param.toString());
        }
        //运行任务
        AnkThreadPool.taskRunThreadPool.execute(new TaskThread(param));
        return new ReturnT<>(200);
    }

    @Override
    public Object executorArgs(GetArgsParam getArgsParam) {
        String taskName = getArgsParam.getTaskName();
        String queryArgs = getArgsParam.getQueryArgs();

        IAnkTask ankTask = TaskRegistry.serviceMap.get(taskName);
        return ankTask.getAvaliableParams(queryArgs);
    }

    @Override
    public void stopTask(Integer taskInsLogId) {
        IAnkTask ankTask = TaskRegistry.serviceStopMap.get(taskInsLogId);
        ankTask.stop();
    }
}
