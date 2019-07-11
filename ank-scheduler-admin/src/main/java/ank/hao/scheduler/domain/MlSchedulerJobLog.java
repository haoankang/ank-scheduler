package ank.hao.scheduler.domain;

import java.util.Date;

public class MlSchedulerJobLog {
    /** 主键ID AUTO_INCREMENT*/
    private Integer jobLogId;

    /** */
    private Integer jobId;

    /** 版本跟踪id*/
    private Integer jobPid;

    /** 调度-时间*/
    private Date jobTriggerTime;

    /** 执行结果-状态：0-运行中，1-成功，2-失败, 3-待运行*/
    private Integer jobHandleState;

    /** 执行结果-日志*/
    private String jobHandleMsg;

    /** 执行-时间*/
    private Date jobHandleTime;

    /** 执行完成时间*/
    private Date jobHandleFinishTime;

    public Integer getJobLogId() {
        return jobLogId;
    }

    public void setJobLogId(Integer jobLogId) {
        this.jobLogId = jobLogId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getJobPid() {
        return jobPid;
    }

    public void setJobPid(Integer jobPid) {
        this.jobPid = jobPid;
    }

    public Date getJobTriggerTime() {
        return jobTriggerTime;
    }

    public void setJobTriggerTime(Date jobTriggerTime) {
        this.jobTriggerTime = jobTriggerTime;
    }

    public Integer getJobHandleState() {
        return jobHandleState;
    }

    public void setJobHandleState(Integer jobHandleState) {
        this.jobHandleState = jobHandleState;
    }

    public String getJobHandleMsg() {
        return jobHandleMsg;
    }

    public void setJobHandleMsg(String jobHandleMsg) {
        this.jobHandleMsg = jobHandleMsg;
    }

    public Date getJobHandleTime() {
        return jobHandleTime;
    }

    public void setJobHandleTime(Date jobHandleTime) {
        this.jobHandleTime = jobHandleTime;
    }

    public Date getJobHandleFinishTime() {
        return jobHandleFinishTime;
    }

    public void setJobHandleFinishTime(Date jobHandleFinishTime) {
        this.jobHandleFinishTime = jobHandleFinishTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jobLogId=").append(jobLogId);
        sb.append(", jobId=").append(jobId);
        sb.append(", jobPid=").append(jobPid);
        sb.append(", jobTriggerTime=").append(jobTriggerTime);
        sb.append(", jobHandleState=").append(jobHandleState);
        sb.append(", jobHandleMsg=").append(jobHandleMsg);
        sb.append(", jobHandleTime=").append(jobHandleTime);
        sb.append(", jobHandleFinishTime=").append(jobHandleFinishTime);
        sb.append("]");
        return sb.toString();
    }
}