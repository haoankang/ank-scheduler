package ank.hao.core.feign;

import ank.hao.core.model.CallBackParam;
import ank.hao.core.model.ReturnT;
import com.alibaba.fastjson.JSONObject;
import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

public interface SchedulerFeign {

    @RequestLine("POST /executor/registry")
    @Headers("Content-Type: application/json")
    JSONObject registryExecutor(String registryExecutorParam);

    @RequestLine("POST /executor/registryService")
    @Headers("Content-Type: application/json")
    JSONObject registryService(String registryServiceParam);

    @RequestLine("POST /executor/callback")
    @Headers("Content-Type: application/json")
    String executorCallback(CallBackParam callBackParam);

    @RequestLine("GET /executor/heartbeat")
    @Headers("Content-Type: application/json")
    void heartbeat();
}