package ank.hao.scheduler.controller.model;

import java.util.Objects;
import ank.hao.scheduler.controller.model.ConditionInfo;
import ank.hao.scheduler.controller.model.TaskListInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JobDetailVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class JobDetailVO   {
  @JsonProperty("jobId")
  private Integer jobId = null;

  @JsonProperty("jobName")
  private String jobName = null;

  @JsonProperty("cronExpression")
  private String cronExpression = null;

  @JsonProperty("cronJson")
  private String cronJson = null;

  @JsonProperty("dependFormer")
  private Boolean dependFormer = false;

  @JsonProperty("timeout")
  private Double timeout = null;

  @JsonProperty("runImmediately")
  private Boolean runImmediately = false;

  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("jobBaseInfo")
  private TaskListInfo jobBaseInfo = null;

  @JsonProperty("conditionInfo")
  private ConditionInfo conditionInfo = null;

  public JobDetailVO jobId(Integer jobId) {
    this.jobId = jobId;
    return this;
  }

  /**
   * Get jobId
   * @return jobId
  **/
  @ApiModelProperty(value = "")


  public Integer getJobId() {
    return jobId;
  }

  public void setJobId(Integer jobId) {
    this.jobId = jobId;
  }

  public JobDetailVO jobName(String jobName) {
    this.jobName = jobName;
    return this;
  }

  /**
   * 作业名
   * @return jobName
  **/
  @ApiModelProperty(value = "作业名")


  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public JobDetailVO cronExpression(String cronExpression) {
    this.cronExpression = cronExpression;
    return this;
  }

  /**
   * cron表达式
   * @return cronExpression
  **/
  @ApiModelProperty(value = "cron表达式")


  public String getCronExpression() {
    return cronExpression;
  }

  public void setCronExpression(String cronExpression) {
    this.cronExpression = cronExpression;
  }

  public JobDetailVO cronJson(String cronJson) {
    this.cronJson = cronJson;
    return this;
  }

  /**
   * cron前端json，展示时使用
   * @return cronJson
  **/
  @ApiModelProperty(value = "cron前端json，展示时使用")


  public String getCronJson() {
    return cronJson;
  }

  public void setCronJson(String cronJson) {
    this.cronJson = cronJson;
  }

  public JobDetailVO dependFormer(Boolean dependFormer) {
    this.dependFormer = dependFormer;
    return this;
  }

  /**
   * 是否依赖上一周期
   * @return dependFormer
  **/
  @ApiModelProperty(value = "是否依赖上一周期")


  public Boolean isDependFormer() {
    return dependFormer;
  }

  public void setDependFormer(Boolean dependFormer) {
    this.dependFormer = dependFormer;
  }

  public JobDetailVO timeout(Double timeout) {
    this.timeout = timeout;
    return this;
  }

  /**
   * 超时范围,单位小时，若为0，则表示没有超时限制
   * @return timeout
  **/
  @ApiModelProperty(value = "超时范围,单位小时，若为0，则表示没有超时限制")


  public Double getTimeout() {
    return timeout;
  }

  public void setTimeout(Double timeout) {
    this.timeout = timeout;
  }

  public JobDetailVO runImmediately(Boolean runImmediately) {
    this.runImmediately = runImmediately;
    return this;
  }

  /**
   * 是否立即运行
   * @return runImmediately
  **/
  @ApiModelProperty(value = "是否立即运行")


  public Boolean isRunImmediately() {
    return runImmediately;
  }

  public void setRunImmediately(Boolean runImmediately) {
    this.runImmediately = runImmediately;
  }

  public JobDetailVO comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * 备注，限制字数255以内
   * @return comment
  **/
  @ApiModelProperty(value = "备注，限制字数255以内")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public JobDetailVO jobBaseInfo(TaskListInfo jobBaseInfo) {
    this.jobBaseInfo = jobBaseInfo;
    return this;
  }

  /**
   * 任务基本信息，内容和taskType有关
   * @return jobBaseInfo
  **/
  @ApiModelProperty(value = "任务基本信息，内容和taskType有关")

  @Valid

  public TaskListInfo getJobBaseInfo() {
    return jobBaseInfo;
  }

  public void setJobBaseInfo(TaskListInfo jobBaseInfo) {
    this.jobBaseInfo = jobBaseInfo;
  }

  public JobDetailVO conditionInfo(ConditionInfo conditionInfo) {
    this.conditionInfo = conditionInfo;
    return this;
  }

  /**
   * 任务条件信息
   * @return conditionInfo
  **/
  @ApiModelProperty(value = "任务条件信息")

  @Valid

  public ConditionInfo getConditionInfo() {
    return conditionInfo;
  }

  public void setConditionInfo(ConditionInfo conditionInfo) {
    this.conditionInfo = conditionInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobDetailVO jobDetailVO = (JobDetailVO) o;
    return Objects.equals(this.jobId, jobDetailVO.jobId) &&
        Objects.equals(this.jobName, jobDetailVO.jobName) &&
        Objects.equals(this.cronExpression, jobDetailVO.cronExpression) &&
        Objects.equals(this.cronJson, jobDetailVO.cronJson) &&
        Objects.equals(this.dependFormer, jobDetailVO.dependFormer) &&
        Objects.equals(this.timeout, jobDetailVO.timeout) &&
        Objects.equals(this.runImmediately, jobDetailVO.runImmediately) &&
        Objects.equals(this.comment, jobDetailVO.comment) &&
        Objects.equals(this.jobBaseInfo, jobDetailVO.jobBaseInfo) &&
        Objects.equals(this.conditionInfo, jobDetailVO.conditionInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, jobName, cronExpression, cronJson, dependFormer, timeout, runImmediately, comment, jobBaseInfo, conditionInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobDetailVO {\n");
    
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    jobName: ").append(toIndentedString(jobName)).append("\n");
    sb.append("    cronExpression: ").append(toIndentedString(cronExpression)).append("\n");
    sb.append("    cronJson: ").append(toIndentedString(cronJson)).append("\n");
    sb.append("    dependFormer: ").append(toIndentedString(dependFormer)).append("\n");
    sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
    sb.append("    runImmediately: ").append(toIndentedString(runImmediately)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    jobBaseInfo: ").append(toIndentedString(jobBaseInfo)).append("\n");
    sb.append("    conditionInfo: ").append(toIndentedString(conditionInfo)).append("\n");
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

