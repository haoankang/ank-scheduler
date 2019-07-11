package ank.hao.core.service;

import ank.hao.core.model.ExecutorParam;
import ank.hao.core.model.GetArgsParam;
import ank.hao.core.model.ReturnT;

public interface ExecutorService {

    ReturnT<String> executeService(ExecutorParam param);

    Object executorArgs(GetArgsParam getArgsParam);

    void stopTask(Integer taskInsLogId);
}
