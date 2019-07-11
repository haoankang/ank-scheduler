package ank.hao.scheduler.service;

import ank.hao.core.model.CallBackParam;

public interface RegistryService {

    String registryExecutor(String body);

    String registryService(String registryServiceParam);

    String executorCallback(CallBackParam callBackParam);
}
