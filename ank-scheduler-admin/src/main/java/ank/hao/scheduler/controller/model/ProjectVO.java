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
 * ProjectVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class ProjectVO   {
  @JsonProperty("projectId")
  private String projectId = null;

  @JsonProperty("projectName")
  private String projectName = null;

  public ProjectVO projectId(String projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * 项目空间id
   * @return projectId
  **/
  @ApiModelProperty(value = "项目空间id")


  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public ProjectVO projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

  /**
   * 项目空间名称
   * @return projectName
  **/
  @ApiModelProperty(value = "项目空间名称")


  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectVO projectVO = (ProjectVO) o;
    return Objects.equals(this.projectId, projectVO.projectId) &&
        Objects.equals(this.projectName, projectVO.projectName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, projectName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectVO {\n");
    
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
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

