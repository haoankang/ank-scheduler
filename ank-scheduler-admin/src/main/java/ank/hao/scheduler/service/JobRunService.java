package ank.hao.scheduler.service;

import ank.hao.scheduler.controller.model.PageInfoTaskHistoryVO;

public interface JobRunService {
    PageInfoTaskHistoryVO jobRunHistoryList(Integer jobId, Integer pageNo, Integer pageSize);

    void jobRunStop(Integer jobId);
}
