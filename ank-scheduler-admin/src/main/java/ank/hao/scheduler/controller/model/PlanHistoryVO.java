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
 * PlanHistoryVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class PlanHistoryVO   {
  @JsonProperty("versionName")
  private String versionName = null;

  @JsonProperty("historyId")
  private String historyId = null;

  public PlanHistoryVO versionName(String versionName) {
    this.versionName = versionName;
    return this;
  }

  /**
   * 实验版本
   * @return versionName
  **/
  @ApiModelProperty(value = "实验版本")


  public String getVersionName() {
    return versionName;
  }

  public void setVersionName(String versionName) {
    this.versionName = versionName;
  }

  public PlanHistoryVO historyId(String historyId) {
    this.historyId = historyId;
    return this;
  }

  /**
   * 历史版本对应的id
   * @return historyId
  **/
  @ApiModelProperty(value = "历史版本对应的id")


  public String getHistoryId() {
    return historyId;
  }

  public void setHistoryId(String historyId) {
    this.historyId = historyId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanHistoryVO planHistoryVO = (PlanHistoryVO) o;
    return Objects.equals(this.versionName, planHistoryVO.versionName) &&
        Objects.equals(this.historyId, planHistoryVO.historyId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(versionName, historyId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanHistoryVO {\n");
    
    sb.append("    versionName: ").append(toIndentedString(versionName)).append("\n");
    sb.append("    historyId: ").append(toIndentedString(historyId)).append("\n");
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

