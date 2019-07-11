package ank.hao.scheduler.controller.api.impl;

import ank.hao.scheduler.controller.api.TaskApi;
import ank.hao.scheduler.service.TaskService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TaskApiController implements TaskApi {

    @Autowired
    private TaskService taskService;

    //@Override
    public ResponseEntity<Object> taskParams(@ApiParam(value = "执行器名",required=true) @PathVariable("appName") String appName,@ApiParam(value = "任务名",required=true) @PathVariable("taskName") String taskName,@ApiParam(value = "查询参数"  )  @Valid @RequestBody String body) {
        Object result = taskService.taskParams(appName, taskName, body);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
