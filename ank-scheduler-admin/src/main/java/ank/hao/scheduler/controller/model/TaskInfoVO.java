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
 * TaskInfoVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class TaskInfoVO   {
  @JsonProperty("taskId")
  private Integer taskId = null;

  @JsonProperty("taskName")
  private String taskName = null;

  @JsonProperty("appName")
  private String appName = null;

  @JsonProperty("taskDesc")
  private String taskDesc = null;

  @JsonProperty("taskSource")
  private Integer taskSource = null;

  @JsonProperty("createTime")
  private String createTime = null;

  @JsonProperty("updateTime")
  private String updateTime = null;

  public TaskInfoVO taskId(Integer taskId) {
    this.taskId = taskId;
    return this;
  }

  /**
   * Get taskId
   * @return taskId
  **/
  @ApiModelProperty(value = "")


  public Integer getTaskId() {
    return taskId;
  }

  public void setTaskId(Integer taskId) {
    this.taskId = taskId;
  }

  public TaskInfoVO taskName(String taskName) {
    this.taskName = taskName;
    return this;
  }

  /**
   * 任务名称
   * @return taskName
  **/
  @ApiModelProperty(value = "任务名称")


  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public TaskInfoVO appName(String appName) {
    this.appName = appName;
    return this;
  }

  /**
   * 所属执行器appname
   * @return appName
  **/
  @ApiModelProperty(value = "所属执行器appname")


  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }

  public TaskInfoVO taskDesc(String taskDesc) {
    this.taskDesc = taskDesc;
    return this;
  }

  /**
   * 任务描述
   * @return taskDesc
  **/
  @ApiModelProperty(value = "任务描述")


  public String getTaskDesc() {
    return taskDesc;
  }

  public void setTaskDesc(String taskDesc) {
    this.taskDesc = taskDesc;
  }

  public TaskInfoVO taskSource(Integer taskSource) {
    this.taskSource = taskSource;
    return this;
  }

  /**
   * 任务来源：0——自动注册，1——手动注册
   * @return taskSource
  **/
  @ApiModelProperty(value = "任务来源：0——自动注册，1——手动注册")


  public Integer getTaskSource() {
    return taskSource;
  }

  public void setTaskSource(Integer taskSource) {
    this.taskSource = taskSource;
  }

  public TaskInfoVO createTime(String createTime) {
    this.createTime = createTime;
    return this;
  }

  /**
   * 创建时间
   * @return createTime
  **/
  @ApiModelProperty(value = "创建时间")


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public TaskInfoVO updateTime(String updateTime) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskInfoVO taskInfoVO = (TaskInfoVO) o;
    return Objects.equals(this.taskId, taskInfoVO.taskId) &&
        Objects.equals(this.taskName, taskInfoVO.taskName) &&
        Objects.equals(this.appName, taskInfoVO.appName) &&
        Objects.equals(this.taskDesc, taskInfoVO.taskDesc) &&
        Objects.equals(this.taskSource, taskInfoVO.taskSource) &&
        Objects.equals(this.createTime, taskInfoVO.createTime) &&
        Objects.equals(this.updateTime, taskInfoVO.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId, taskName, appName, taskDesc, taskSource, createTime, updateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskInfoVO {\n");
    
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    taskName: ").append(toIndentedString(taskName)).append("\n");
    sb.append("    appName: ").append(toIndentedString(appName)).append("\n");
    sb.append("    taskDesc: ").append(toIndentedString(taskDesc)).append("\n");
    sb.append("    taskSource: ").append(toIndentedString(taskSource)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
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

