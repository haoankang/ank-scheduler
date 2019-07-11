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
 * JobInfoVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class JobInfoVO   {
  @JsonProperty("jobId")
  private Integer jobId = null;

  @JsonProperty("jobName")
  private String jobName = null;

  @JsonProperty("indateRange")
  private String indateRange = null;

  @JsonProperty("runState")
  private Integer runState = null;

  @JsonProperty("updateOper")
  private String updateOper = "0";

  @JsonProperty("updateTime")
  private String updateTime = null;

  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("state")
  private Integer state = null;

  public JobInfoVO jobId(Integer jobId) {
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

  public JobInfoVO jobName(String jobName) {
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

  public JobInfoVO indateRange(String indateRange) {
    this.indateRange = indateRange;
    return this;
  }

  /**
   * 生效时间范围
   * @return indateRange
  **/
  @ApiModelProperty(value = "生效时间范围")


  public String getIndateRange() {
    return indateRange;
  }

  public void setIndateRange(String indateRange) {
    this.indateRange = indateRange;
  }

  public JobInfoVO runState(Integer runState) {
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

  public JobInfoVO updateOper(String updateOper) {
    this.updateOper = updateOper;
    return this;
  }

  /**
   * 更新者
   * @return updateOper
  **/
  @ApiModelProperty(value = "更新者")


  public String getUpdateOper() {
    return updateOper;
  }

  public void setUpdateOper(String updateOper) {
    this.updateOper = updateOper;
  }

  public JobInfoVO updateTime(String updateTime) {
    this.updateTime = updateTime;
    return this;
  }

  /**
   * 更新时间
   * @return updateTime
  **/
  @ApiModelProperty(value = "更新时间")


  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public JobInfoVO comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * 备注
   * @return comment
  **/
  @ApiModelProperty(value = "备注")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public JobInfoVO state(Integer state) {
    this.state = state;
    return this;
  }

  /**
   * 在线状态：下线：0，上线：1
   * @return state
  **/
  @ApiModelProperty(value = "在线状态：下线：0，上线：1")


  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobInfoVO jobInfoVO = (JobInfoVO) o;
    return Objects.equals(this.jobId, jobInfoVO.jobId) &&
        Objects.equals(this.jobName, jobInfoVO.jobName) &&
        Objects.equals(this.indateRange, jobInfoVO.indateRange) &&
        Objects.equals(this.runState, jobInfoVO.runState) &&
        Objects.equals(this.updateOper, jobInfoVO.updateOper) &&
        Objects.equals(this.updateTime, jobInfoVO.updateTime) &&
        Objects.equals(this.comment, jobInfoVO.comment) &&
        Objects.equals(this.state, jobInfoVO.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, jobName, indateRange, runState, updateOper, updateTime, comment, state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobInfoVO {\n");
    
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    jobName: ").append(toIndentedString(jobName)).append("\n");
    sb.append("    indateRange: ").append(toIndentedString(indateRange)).append("\n");
    sb.append("    runState: ").append(toIndentedString(runState)).append("\n");
    sb.append("    updateOper: ").append(toIndentedString(updateOper)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

