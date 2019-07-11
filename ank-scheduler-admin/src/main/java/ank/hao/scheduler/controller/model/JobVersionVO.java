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
 * JobVersionVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class JobVersionVO   {
  @JsonProperty("jobId")
  private Integer jobId = null;

  @JsonProperty("jobVersion")
  private String jobVersion = null;

  @JsonProperty("updateContent")
  private String updateContent = null;

  @JsonProperty("updateOper")
  private String updateOper = null;

  @JsonProperty("updateTime")
  private String updateTime = null;

  @JsonProperty("comment")
  private String comment = null;

  public JobVersionVO jobId(Integer jobId) {
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

  public JobVersionVO jobVersion(String jobVersion) {
    this.jobVersion = jobVersion;
    return this;
  }

  /**
   * 版本
   * @return jobVersion
  **/
  @ApiModelProperty(value = "版本")


  public String getJobVersion() {
    return jobVersion;
  }

  public void setJobVersion(String jobVersion) {
    this.jobVersion = jobVersion;
  }

  public JobVersionVO updateContent(String updateContent) {
    this.updateContent = updateContent;
    return this;
  }

  /**
   * 更新内容
   * @return updateContent
  **/
  @ApiModelProperty(value = "更新内容")


  public String getUpdateContent() {
    return updateContent;
  }

  public void setUpdateContent(String updateContent) {
    this.updateContent = updateContent;
  }

  public JobVersionVO updateOper(String updateOper) {
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

  public JobVersionVO updateTime(String updateTime) {
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

  public JobVersionVO comment(String comment) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobVersionVO jobVersionVO = (JobVersionVO) o;
    return Objects.equals(this.jobId, jobVersionVO.jobId) &&
        Objects.equals(this.jobVersion, jobVersionVO.jobVersion) &&
        Objects.equals(this.updateContent, jobVersionVO.updateContent) &&
        Objects.equals(this.updateOper, jobVersionVO.updateOper) &&
        Objects.equals(this.updateTime, jobVersionVO.updateTime) &&
        Objects.equals(this.comment, jobVersionVO.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, jobVersion, updateContent, updateOper, updateTime, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobVersionVO {\n");
    
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    jobVersion: ").append(toIndentedString(jobVersion)).append("\n");
    sb.append("    updateContent: ").append(toIndentedString(updateContent)).append("\n");
    sb.append("    updateOper: ").append(toIndentedString(updateOper)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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

