package ank.hao.scheduler.controller.model;

import java.util.Objects;
import ank.hao.scheduler.controller.model.PlanHistoryVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PlanListVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class PlanListVO   {
  @JsonProperty("planId")
  private String planId = null;

  @JsonProperty("planName")
  private String planName = null;

  @JsonProperty("planVersion")
  private PlanHistoryVO planVersion = null;

  public PlanListVO planId(String planId) {
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

  public PlanListVO planName(String planName) {
    this.planName = planName;
    return this;
  }

  /**
   * 实验名称
   * @return planName
  **/
  @ApiModelProperty(value = "实验名称")


  public String getPlanName() {
    return planName;
  }

  public void setPlanName(String planName) {
    this.planName = planName;
  }

  public PlanListVO planVersion(PlanHistoryVO planVersion) {
    this.planVersion = planVersion;
    return this;
  }

  /**
   * Get planVersion
   * @return planVersion
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PlanHistoryVO getPlanVersion() {
    return planVersion;
  }

  public void setPlanVersion(PlanHistoryVO planVersion) {
    this.planVersion = planVersion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanListVO planListVO = (PlanListVO) o;
    return Objects.equals(this.planId, planListVO.planId) &&
        Objects.equals(this.planName, planListVO.planName) &&
        Objects.equals(this.planVersion, planListVO.planVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planId, planName, planVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanListVO {\n");
    
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    planName: ").append(toIndentedString(planName)).append("\n");
    sb.append("    planVersion: ").append(toIndentedString(planVersion)).append("\n");
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

