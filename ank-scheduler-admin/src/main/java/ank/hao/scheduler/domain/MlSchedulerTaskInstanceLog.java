package ank.hao.scheduler.domain;

import java.util.Date;

public class MlSchedulerTaskInstanceLog {
    /** */
    private Integer taskInstanceLogId;

    /** */
    private Integer jobLogId;

    /** */
    private Integer taskInstanceId;

    /** 依赖id，以此作为执行顺序*/
    private Integer dependId;

    /** 状态描述信息,如：异常信息，SUCCESS等*/
    private String taskMsg;

    /** 状态值：0-运行中，1-成功，2-失败, 3-待运行*/
    private Integer taskState;

    /** 开始执行时间*/
    private Date taskHandleTime;

    /** 结束时间*/
    private Date taskFinishTime;

    /** 创建时间*/
    private Date createTime;

    /** 非分布任务停止使用url*/
    private String address;

    public Integer getTaskInstanceLogId() {
        return taskInstanceLogId;
    }

    public void setTaskInstanceLogId(Integer taskInstanceLogId) {
        this.taskInstanceLogId = taskInstanceLogId;
    }

    public Integer getJobLogId() {
        return jobLogId;
    }

    public void setJobLogId(Integer jobLogId) {
        this.jobLogId = jobLogId;
    }

    public Integer getTaskInstanceId() {
        return taskInstanceId;
    }

    public void setTaskInstanceId(Integer taskInstanceId) {
        this.taskInstanceId = taskInstanceId;
    }

    public Integer getDependId() {
        return dependId;
    }

    public void setDependId(Integer dependId) {
        this.dependId = dependId;
    }

    public String getTaskMsg() {
        return taskMsg;
    }

    public void setTaskMsg(String taskMsg) {
        this.taskMsg = taskMsg;
    }

    public Integer getTaskState() {
        return taskState;
    }

    public void setTaskState(Integer taskState) {
        this.taskState = taskState;
    }

    public Date getTaskHandleTime() {
        return taskHandleTime;
    }

    public void setTaskHandleTime(Date taskHandleTime) {
        this.taskHandleTime = taskHandleTime;
    }

    public Date getTaskFinishTime() {
        return taskFinishTime;
    }

    public void setTaskFinishTime(Date taskFinishTime) {
        this.taskFinishTime = taskFinishTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskInstanceLogId=").append(taskInstanceLogId);
        sb.append(", jobLogId=").append(jobLogId);
        sb.append(", taskInstanceId=").append(taskInstanceId);
        sb.append(", dependId=").append(dependId);
        sb.append(", taskMsg=").append(taskMsg);
        sb.append(", taskState=").append(taskState);
        sb.append(", taskHandleTime=").append(taskHandleTime);
        sb.append(", taskFinishTime=").append(taskFinishTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", address=").append(address);
        sb.append("]");
        return sb.toString();
    }
}