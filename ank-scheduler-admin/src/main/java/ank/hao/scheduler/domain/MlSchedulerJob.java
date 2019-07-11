package ank.hao.scheduler.domain;

import java.util.Date;

public class MlSchedulerJob {
    /** */
    private Integer jobId;

    /** */
    private String jobName;

    /** */
    private Integer version;

    /** */
    private String cronExpression;

    /** */
    private String cronJson;

    /** 是否依赖上一周期:0-false,1-true*/
    private Boolean dependformer;

    /** */
    private Double timeout;

    /** 是否立即运行:0-false,1-true*/
    private Boolean runimmediately;

    /** 0-下线1-上线；页面均展示*/
    private Integer state;

    /** 原型id，最初版本id*/
    private Integer pid;

    /** 任务状态：0-未删除，1-以删除*/
    private Integer deleteFlag;

    /** */
    private Date createTime;

    /** */
    private String createOper;

    /** */
    private Date updateTime;

    /** */
    private String updateOper;

    /** */
    private String updateContent;

    /** 作业的任务列表信息，用于方便展示*/
    private byte[] jobdetailInfo;

    /** */
    private byte[] conditionInfo;

    /** 备注*/
    private byte[] comment;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getCronJson() {
        return cronJson;
    }

    public void setCronJson(String cronJson) {
        this.cronJson = cronJson;
    }

    public Boolean getDependformer() {
        return dependformer;
    }

    public void setDependformer(Boolean dependformer) {
        this.dependformer = dependformer;
    }

    public Double getTimeout() {
        return timeout;
    }

    public void setTimeout(Double timeout) {
        this.timeout = timeout;
    }

    public Boolean getRunimmediately() {
        return runimmediately;
    }

    public void setRunimmediately(Boolean runimmediately) {
        this.runimmediately = runimmediately;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateOper() {
        return createOper;
    }

    public void setCreateOper(String createOper) {
        this.createOper = createOper;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateOper() {
        return updateOper;
    }

    public void setUpdateOper(String updateOper) {
        this.updateOper = updateOper;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public byte[] getJobdetailInfo() {
        return jobdetailInfo;
    }

    public void setJobdetailInfo(byte[] jobdetailInfo) {
        this.jobdetailInfo = jobdetailInfo;
    }

    public byte[] getConditionInfo() {
        return conditionInfo;
    }

    public void setConditionInfo(byte[] conditionInfo) {
        this.conditionInfo = conditionInfo;
    }

    public byte[] getComment() {
        return comment;
    }

    public void setComment(byte[] comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jobId=").append(jobId);
        sb.append(", jobName=").append(jobName);
        sb.append(", version=").append(version);
        sb.append(", cronExpression=").append(cronExpression);
        sb.append(", cronJson=").append(cronJson);
        sb.append(", dependformer=").append(dependformer);
        sb.append(", timeout=").append(timeout);
        sb.append(", runimmediately=").append(runimmediately);
        sb.append(", state=").append(state);
        sb.append(", pid=").append(pid);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", createOper=").append(createOper);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateOper=").append(updateOper);
        sb.append(", updateContent=").append(updateContent);
        sb.append(", jobdetailInfo=").append(jobdetailInfo);
        sb.append(", conditionInfo=").append(conditionInfo);
        sb.append(", comment=").append(comment);
        sb.append("]");
        return sb.toString();
    }
}