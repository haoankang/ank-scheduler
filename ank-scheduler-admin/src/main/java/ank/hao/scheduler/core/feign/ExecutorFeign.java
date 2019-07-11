package ank.hao.scheduler.core.feign;

import ank.hao.core.model.ExecutorParam;
import ank.hao.core.model.GetArgsParam;
import ank.hao.core.model.ReturnT;
import feign.Headers;
import feign.RequestLine;

public interface ExecutorFeign {

    @RequestLine("POST /ank/executor/service")
    @Headers("Content-Type: application/json")
    ReturnT executorService(ExecutorParam serviceParam);

    @RequestLine("GET /ank/executor/heartbeat")
    @Headers("Content-Type: application/json")
    void heartBeat();

    @RequestLine("GET /ank/executor/params")
    @Headers("Content-Type: application/json")
    ReturnT getExecutorParams(GetArgsParam getArgsParam);

    @RequestLine("POST /ank/executor/stop")
    @Headers("Content-Type: application/json")
    void stopService(Integer taskInsLogId);
}