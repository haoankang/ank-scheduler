package ank.hao.scheduler.service;

import ank.hao.scheduler.controller.model.*;

import java.util.List;

public interface JobService {
    void activeJob(Integer jobId);

    void jobAdd(JobAddVO body);

    void taskDelete(List<Integer> jobIdList);

    TableData jobList();

    JobDetailVO jobQuery(Integer jobId);

    Integer jobRollback(Integer jobId);

    Integer taskUpdate(JobUpdateVO jobUpdateVO);

    JobVersionVOList queryJobVersionList(Integer jobId);

    void cancelJob(Integer jobId);
}
