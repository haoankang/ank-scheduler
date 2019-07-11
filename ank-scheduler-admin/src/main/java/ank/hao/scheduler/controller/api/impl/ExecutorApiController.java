package ank.hao.scheduler.controller.api.impl;

import ank.hao.core.log.ExecutorLog;
import ank.hao.core.model.CallBackParam;
import ank.hao.scheduler.controller.api.ExecutorApi;
import ank.hao.scheduler.controller.model.DefaultResponse;
import ank.hao.scheduler.service.RegistryService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ExecutorApiController implements ExecutorApi {

    @Autowired
    private RegistryService registryService;

    @Override
    public ResponseEntity<DefaultResponse> registryExecutor(@ApiParam(value = "" ,required=true )  @Valid @RequestBody String body) {
        ExecutorLog.infoLog("调度中心收到注册请求，参数：{}", body);
        String result = registryService.registryExecutor(body);
        DefaultResponse response = new DefaultResponse();
        response.setResult(result);
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DefaultResponse> registryService(@ApiParam(value = "" ,required=true )  @Valid @RequestBody String registryServiceParam) {
        ExecutorLog.infoLog("调度中心收到注册服务请求，参数：{}", registryServiceParam);
        String result = registryService.registryService(registryServiceParam);
        DefaultResponse response = new DefaultResponse();
        response.setResult(result);
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.OK);
    }

    public ResponseEntity<String> executorCallback(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Object returnT) {

        String response = "FAIL";
        CallBackParam callBackParam = (CallBackParam) returnT;
        response = registryService.executorCallback(callBackParam);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Void> schedulerHeartBeat() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
