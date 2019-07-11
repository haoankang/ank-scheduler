package ank.hao.scheduler.domain;

import java.util.Date;

public class MlSchedulerTaskInstance {
    /** */
    private Integer taskInstanceId;

    /** */
    private Integer jobId;

    /** */
    private Integer taskId;

    /** 前置任务*/
    private String preTaskInstanceId;

    /** task入参来源：{from_ui,from_task}*/
    private String inputType;

    /** 路由策略:0——第一个，1——随机，2——最后一个*/
    private Integer routeStategy;

    /** 失败处理策略：0——忽略继续执行，1——失败重试，2——作业结束*/
    private Integer failover;

    /** 失败处理策略附属参数*/
    private String failoverValue;

    /** 更新时间*/
    private Date updateTime;

    /** 创建时间*/
    private Date createTime;

    /** 接口数据返回超时时间，单位秒*/
    private Integer readTimeout;

    /** task入参参数值*/
    private byte[] inputValue;

    public Integer getTaskInstanceId() {
        return taskInstanceId;
    }

    public void setTaskInstanceId(Integer taskInstanceId) {
        this.taskInstanceId = taskInstanceId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getPreTaskInstanceId() {
        return preTaskInstanceId;
    }

    public void setPreTaskInstanceId(String preTaskInstanceId) {
        this.preTaskInstanceId = preTaskInstanceId;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public Integer getRouteStategy() {
        return routeStategy;
    }

    public void setRouteStategy(Integer routeStategy) {
        this.routeStategy = routeStategy;
    }

    public Integer getFailover() {
        return failover;
    }

    public void setFailover(Integer failover) {
        this.failover = failover;
    }

    public String getFailoverValue() {
        return failoverValue;
    }

    public void setFailoverValue(String failoverValue) {
        this.failoverValue = failoverValue;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

    public byte[] getInputValue() {
        return inputValue;
    }

    public void setInputValue(byte[] inputValue) {
        this.inputValue = inputValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskInstanceId=").append(taskInstanceId);
        sb.append(", jobId=").append(jobId);
        sb.append(", taskId=").append(taskId);
        sb.append(", preTaskInstanceId=").append(preTaskInstanceId);
        sb.append(", inputType=").append(inputType);
        sb.append(", routeStategy=").append(routeStategy);
        sb.append(", failover=").append(failover);
        sb.append(", failoverValue=").append(failoverValue);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", readTimeout=").append(readTimeout);
        sb.append(", inputValue=").append(inputValue);
        sb.append("]");
        return sb.toString();
    }
}