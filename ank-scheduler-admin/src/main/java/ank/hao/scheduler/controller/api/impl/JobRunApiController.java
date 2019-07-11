package ank.hao.scheduler.controller.api.impl;

import ank.hao.scheduler.controller.api.JobRunApi;
import ank.hao.scheduler.controller.model.PageInfoTaskHistoryVO;
import ank.hao.scheduler.controller.model.VoidResponse;
import ank.hao.scheduler.service.JobRunService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class JobRunApiController implements JobRunApi {

    @Autowired
    private JobRunService jobRunService;

    @Override
    public ResponseEntity<PageInfoTaskHistoryVO> jobRunList(@ApiParam(value = "",required=true) @PathVariable("jobId") Integer jobId, @ApiParam(value = "", defaultValue = "1") @Valid @RequestParam(value = "pageNo", required = false, defaultValue="1") Integer pageNo, @ApiParam(value = "", defaultValue = "10") @Valid @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize) {
        return new ResponseEntity<PageInfoTaskHistoryVO>(jobRunService.jobRunHistoryList(jobId,pageNo,pageSize), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VoidResponse> jobRunStop(@ApiParam(value = "",required=true) @PathVariable("jobId") Integer jobId) {
        jobRunService.jobRunStop(jobId);
        return new ResponseEntity<VoidResponse>(new VoidResponse(),HttpStatus.OK);
    }
}
