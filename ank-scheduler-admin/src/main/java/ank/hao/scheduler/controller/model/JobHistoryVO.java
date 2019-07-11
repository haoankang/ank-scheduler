package ank.hao.scheduler.controller.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JobHistoryVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class JobHistoryVO   {
  @JsonProperty("jobRunId")
  private Integer jobRunId = null;

  @JsonProperty("jobName")
  private String jobName = null;

  @JsonProperty("jobVersion")
  private String jobVersion = null;

  @JsonProperty("executeTime")
  private Long executeTime = null;

  @JsonProperty("runState")
  private Integer runState = null;

  @JsonProperty("runStartTime")
  private Long runStartTime = null;

  @JsonProperty("runEndTime")
  private Long runEndTime = null;

  @JsonProperty("projectId")
  private String projectId = null;

  @JsonProperty("planId")
  private String planId = null;

  @JsonProperty("historyId")
  private String historyId = null;

  @JsonProperty("version")
  private String version = null;

  public JobHistoryVO jobRunId(Integer jobRunId) {
    this.jobRunId = jobRunId;
    return this;
  }

  /**
   * 执行id
   * @return jobRunId
  **/
  @ApiModelProperty(value = "执行id")


  public Integer getJobRunId() {
    return jobRunId;
  }

  public void setJobRunId(Integer jobRunId) {
    this.jobRunId = jobRunId;
  }

  public JobHistoryVO jobName(String jobName) {
    this.jobName = jobName;
    return this;
  }

  /**
   * 作业名称
   * @return jobName
  **/
  @ApiModelProperty(value = "作业名称")


  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public JobHistoryVO jobVersion(String jobVersion) {
    this.jobVersion = jobVersion;
    return this;
  }

  /**
   * 作业版本
   * @return jobVersion
  **/
  @ApiModelProperty(value = "作业版本")


  public String getJobVersion() {
    return jobVersion;
  }

  public void setJobVersion(String jobVersion) {
    this.jobVersion = jobVersion;
  }

  public JobHistoryVO executeTime(Long executeTime) {
    this.executeTime = executeTime;
    return this;
  }

  /**
   * 调度时间
   * @return executeTime
  **/
  @ApiModelProperty(value = "调度时间")


  public Long getExecuteTime() {
    return executeTime;
  }

  public void setExecuteTime(Long executeTime) {
    this.executeTime = executeTime;
  }

  public JobHistoryVO runState(Integer runState) {
    this.runState = runState;
    return this;
  }

  /**
   * 0-运行中，1-成功，2-失败，3-待运行
   * @return runState
  **/
  @ApiModelProperty(value = "0-运行中，1-成功，2-失败，3-待运行")


  public Integer getRunState() {
    return runState;
  }

  public void setRunState(Integer runState) {
    this.runState = runState;
  }

  public JobHistoryVO runStartTime(Long runStartTime) {
    this.runStartTime = runStartTime;
    return this;
  }

  /**
   * 开始时间
   * @return runStartTime
  **/
  @ApiModelProperty(value = "开始时间")


  public Long getRunStartTime() {
    return runStartTime;
  }

  public void setRunStartTime(Long runStartTime) {
    this.runStartTime = runStartTime;
  }

  public JobHistoryVO runEndTime(Long runEndTime) {
    this.runEndTime = runEndTime;
    return this;
  }

  /**
   * 结束时间
   * @return runEndTime
  **/
  @ApiModelProperty(value = "结束时间")


  public Long getRunEndTime() {
    return runEndTime;
  }

  public void setRunEndTime(Long runEndTime) {
    this.runEndTime = runEndTime;
  }

  public JobHistoryVO projectId(String projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * 项目id
   * @return projectId
  **/
  @ApiModelProperty(value = "项目id")


  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public JobHistoryVO planId(String planId) {
    this.planId = planId;
    return this;
  }

  /**
   * 实验id
   * @return planId
  **/
  @ApiModelProperty(value = "实验id")


  public String getPlanId() {
    return planId;
  }

  public void setPlanId(String planId) {
    this.planId = planId;
  }

  public JobHistoryVO historyId(String historyId) {
    this.historyId = historyId;
    return this;
  }

  /**
   * 历史id
   * @return historyId
  **/
  @ApiModelProperty(value = "历史id")


  public String getHistoryId() {
    return historyId;
  }

  public void setHistoryId(String historyId) {
    this.historyId = historyId;
  }

  public JobHistoryVO version(String version) {
    this.version = version;
    return this;
  }

  /**
   * 版本
   * @return version
  **/
  @ApiModelProperty(value = "版本")


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobHistoryVO jobHistoryVO = (JobHistoryVO) o;
    return Objects.equals(this.jobRunId, jobHistoryVO.jobRunId) &&
        Objects.equals(this.jobName, jobHistoryVO.jobName) &&
        Objects.equals(this.jobVersion, jobHistoryVO.jobVersion) &&
        Objects.equals(this.executeTime, jobHistoryVO.executeTime) &&
        Objects.equals(this.runState, jobHistoryVO.runState) &&
        Objects.equals(this.runStartTime, jobHistoryVO.runStartTime) &&
        Objects.equals(this.runEndTime, jobHistoryVO.runEndTime) &&
        Objects.equals(this.projectId, jobHistoryVO.projectId) &&
        Objects.equals(this.planId, jobHistoryVO.planId) &&
        Objects.equals(this.historyId, jobHistoryVO.historyId) &&
        Objects.equals(this.version, jobHistoryVO.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobRunId, jobName, jobVersion, executeTime, runState, runStartTime, runEndTime, projectId, planId, historyId, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobHistoryVO {\n");
    
    sb.append("    jobRunId: ").append(toIndentedString(jobRunId)).append("\n");
    sb.append("    jobName: ").append(toIndentedString(jobName)).append("\n");
    sb.append("    jobVersion: ").append(toIndentedString(jobVersion)).append("\n");
    sb.append("    executeTime: ").append(toIndentedString(executeTime)).append("\n");
    sb.append("    runState: ").append(toIndentedString(runState)).append("\n");
    sb.append("    runStartTime: ").append(toIndentedString(runStartTime)).append("\n");
    sb.append("    runEndTime: ").append(toIndentedString(runEndTime)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    historyId: ").append(toIndentedString(historyId)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

