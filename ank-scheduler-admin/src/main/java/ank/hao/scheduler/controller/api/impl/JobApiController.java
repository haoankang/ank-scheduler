package ank.hao.scheduler.controller.api.impl;

import ank.hao.scheduler.controller.api.JobApi;
import ank.hao.scheduler.controller.model.*;
import ank.hao.scheduler.core.exception.InvalidRequestParamException;
import ank.hao.scheduler.core.util.ValidateParam;
import ank.hao.scheduler.service.JobService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class JobApiController implements JobApi {

    @Autowired
    private JobService jobService;

    @Override
    public ResponseEntity<VoidResponse> jobAdd(@ApiParam(value = "" ,required=true )  @Valid @RequestBody JobAddVO body) {
        //custom param validate
        String validate_msg = ValidateParam.validate_TaskAddVO(body);
        if(!"ok".equals(validate_msg)){
            throw new InvalidRequestParamException(validate_msg);
        }
        jobService.jobAdd(body);
        return new ResponseEntity<VoidResponse>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VoidResponse> activeJob(@ApiParam(value = "",required=true) @PathVariable("jobId") Integer jobId) {

        jobService.activeJob(jobId);
        return new ResponseEntity<VoidResponse>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VoidResponse> cancelJob(@ApiParam(value = "",required=true) @PathVariable("jobId") Integer jobId) {
        jobService.cancelJob(jobId);

        return new ResponseEntity<VoidResponse>(new VoidResponse(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VoidResponse> jobDelete(@ApiParam(value = ""  )  @Valid @RequestBody Object jobIds) {
        Map<String,List<Integer>> map = (Map<String, List<Integer>>) jobIds;
        List<Integer> jobIdList = new ArrayList<>();
        jobIdList = map.get("jobIds");
        jobService.taskDelete(jobIdList);
        return new ResponseEntity<VoidResponse>(new VoidResponse(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TableData> jobList() {
        TableData tableData = jobService.jobList();
        return new ResponseEntity<TableData>(tableData, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<JobDetailVO> jobQueryById(@ApiParam(value = "",required=true) @PathVariable("jobId") Integer jobId) {
        JobDetailVO jobDetailVO = jobService.jobQuery(jobId);
        return new ResponseEntity<JobDetailVO>(jobDetailVO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VoidResponse> jobRollback(@ApiParam(value = "",required=true) @PathVariable("jobId") Integer jobId) {
        Integer jobId_latest = jobService.jobRollback(jobId);
        return new ResponseEntity<VoidResponse>(new VoidResponse().data(jobId_latest),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VoidResponse> jobUpdate(@ApiParam(value = "" ,required=true )  @Valid @RequestBody JobUpdateVO jobUpdateVO) {
        String validate_msg = ValidateParam.validate_TaskUpdateVO(jobUpdateVO);
        if(!"ok".equals(validate_msg)){
            throw new InvalidRequestParamException(validate_msg);
        }
        Integer jobId_latest = jobService.taskUpdate(jobUpdateVO);
        return new ResponseEntity<VoidResponse>(new VoidResponse().data(jobId_latest),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<JobVersionVOList> queryJobVersionList(@ApiParam(value = "",required=true) @PathVariable("jobId") Integer jobId) {
        return new ResponseEntity<JobVersionVOList>(jobService.queryJobVersionList(jobId), HttpStatus.OK);
    }
}
