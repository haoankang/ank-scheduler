package ank.hao.core.controller;

import ank.hao.core.log.ExecutorLog;
import ank.hao.core.model.ExecutorParam;
import ank.hao.core.model.GetArgsParam;
import ank.hao.core.model.ReturnT;
import ank.hao.core.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 调度中心调用执行器服务
 */
@RestController
public class ExecutorController {

    @Autowired
    private ExecutorService executorService;

    @PostMapping("/ank/executor/service")
    public ReturnT executorService(@RequestBody ExecutorParam serviceParam){
        ExecutorLog.infoLog("执行器接收任务参数：{}",serviceParam);
        ReturnT returnT = executorService.executeService(serviceParam);
        return returnT;
    }

    @RequestMapping("/ank/executor/heartbeat")
    public void heartBeat(){
        ExecutorLog.traceLog("接收心跳请求,date={}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @PostMapping("/ank/executor/params")
    public ReturnT executorArgs(@RequestBody GetArgsParam getArgsParam){
        ExecutorLog.traceLog("获取任务参数：{}", getArgsParam);
        Object object = executorService.executorArgs(getArgsParam);
        return new ReturnT(200, "success", object);
    }

    @PostMapping("/ank/executor/stop")
    public void stopTask(@RequestBody Integer taskInsLogId){
        ExecutorLog.traceLog("停止正在运行的任务：{}", taskInsLogId);
        executorService.stopTask(taskInsLogId);
    }
}
