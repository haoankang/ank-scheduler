package ank.hao.scheduler.service;

public interface TaskService {
    Object taskParams(String appName, String taskName, String queryArgs);
}
