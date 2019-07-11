package ank.hao.scheduler.controller.model;

import java.util.Objects;
import ank.hao.scheduler.controller.model.JobAddVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JobUpdateVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class JobUpdateVO   {
  @JsonProperty("jobId")
  private Integer jobId = null;

  @JsonProperty("jobAddVO")
  private JobAddVO jobAddVO = null;

  public JobUpdateVO jobId(Integer jobId) {
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

  public JobUpdateVO jobAddVO(JobAddVO jobAddVO) {
    this.jobAddVO = jobAddVO;
    return this;
  }

  /**
   * Get jobAddVO
   * @return jobAddVO
  **/
  @ApiModelProperty(value = "")

  @Valid

  public JobAddVO getJobAddVO() {
    return jobAddVO;
  }

  public void setJobAddVO(JobAddVO jobAddVO) {
    this.jobAddVO = jobAddVO;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobUpdateVO jobUpdateVO = (JobUpdateVO) o;
    return Objects.equals(this.jobId, jobUpdateVO.jobId) &&
        Objects.equals(this.jobAddVO, jobUpdateVO.jobAddVO);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, jobAddVO);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobUpdateVO {\n");
    
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    jobAddVO: ").append(toIndentedString(jobAddVO)).append("\n");
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

