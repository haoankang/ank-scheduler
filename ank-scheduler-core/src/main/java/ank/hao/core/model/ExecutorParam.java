package ank.hao.core.model;

import java.io.Serializable;

public class ExecutorParam implements Serializable {

    //id
    private Integer taskInstanceLogId;

    //任务名称
    private String taskName;

    //任务参数(json序列化)
    private String taskParam;

    //超时时间，单位是秒
    private Long timeout;

    public Integer getTaskInstanceLogId() {
        return taskInstanceLogId;
    }

    public void setTaskInstanceLogId(Integer taskInstanceLogId) {
        this.taskInstanceLogId = taskInstanceLogId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskParam() {
        return taskParam;
    }

    public void setTaskParam(String taskParam) {
        this.taskParam = taskParam;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "InvokeParam{" + "taskName='" + taskName + '\'' + ", taskParam='" + taskParam + '\'' + ", timeout=" + timeout + '}';
    }
}
