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
 * ConditionInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class ConditionInfo   {
  @JsonProperty("indateStartTime")
  private Long indateStartTime = null;

  @JsonProperty("indateEndTime")
  private Long indateEndTime = null;

  public ConditionInfo indateStartTime(Long indateStartTime) {
    this.indateStartTime = indateStartTime;
    return this;
  }

  /**
   * 有效起始时间
   * @return indateStartTime
  **/
  @ApiModelProperty(value = "有效起始时间")


  public Long getIndateStartTime() {
    return indateStartTime;
  }

  public void setIndateStartTime(Long indateStartTime) {
    this.indateStartTime = indateStartTime;
  }

  public ConditionInfo indateEndTime(Long indateEndTime) {
    this.indateEndTime = indateEndTime;
    return this;
  }

  /**
   * 有效终止时间
   * @return indateEndTime
  **/
  @ApiModelProperty(value = "有效终止时间")


  public Long getIndateEndTime() {
    return indateEndTime;
  }

  public void setIndateEndTime(Long indateEndTime) {
    this.indateEndTime = indateEndTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConditionInfo conditionInfo = (ConditionInfo) o;
    return Objects.equals(this.indateStartTime, conditionInfo.indateStartTime) &&
        Objects.equals(this.indateEndTime, conditionInfo.indateEndTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(indateStartTime, indateEndTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConditionInfo {\n");
    
    sb.append("    indateStartTime: ").append(toIndentedString(indateStartTime)).append("\n");
    sb.append("    indateEndTime: ").append(toIndentedString(indateEndTime)).append("\n");
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

