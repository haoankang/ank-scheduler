package ank.hao.scheduler.controller.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TaskMJobInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class TaskMJobInfo   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("preId")
  @Valid
  private List<Integer> preId = null;

  @JsonProperty("taskId")
  private Integer taskId = null;

  @JsonProperty("params")
  private String params = null;

  @JsonProperty("routeStategy")
  private Integer routeStategy = null;

  @JsonProperty("failover")
  private Integer failover = null;

  @JsonProperty("failoverValue")
  private String failoverValue = null;

  @JsonProperty("timeout")
  private Integer timeout = null;

  public TaskMJobInfo id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * 自增序列
   * @return id
  **/
  @ApiModelProperty(value = "自增序列")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TaskMJobInfo preId(List<Integer> preId) {
    this.preId = preId;
    return this;
  }

  public TaskMJobInfo addPreIdItem(Integer preIdItem) {
    if (this.preId == null) {
      this.preId = new ArrayList<>();
    }
    this.preId.add(preIdItem);
    return this;
  }

  /**
   * 前置任务数组
   * @return preId
  **/
  @ApiModelProperty(value = "前置任务数组")


  public List<Integer> getPreId() {
    return preId;
  }

  public void setPreId(List<Integer> preId) {
    this.preId = preId;
  }

  public TaskMJobInfo taskId(Integer taskId) {
    this.taskId = taskId;
    return this;
  }

  /**
   * 任务id
   * @return taskId
  **/
  @ApiModelProperty(value = "任务id")


  public Integer getTaskId() {
    return taskId;
  }

  public void setTaskId(Integer taskId) {
    this.taskId = taskId;
  }

  public TaskMJobInfo params(String params) {
    this.params = params;
    return this;
  }

  /**
   * 任务参数，一般是json串
   * @return params
  **/
  @ApiModelProperty(value = "任务参数，一般是json串")


  public String getParams() {
    return params;
  }

  public void setParams(String params) {
    this.params = params;
  }

  public TaskMJobInfo routeStategy(Integer routeStategy) {
    this.routeStategy = routeStategy;
    return this;
  }

  /**
   * 路由策略:0——第一个，1——随机，2——最后一个
   * @return routeStategy
  **/
  @ApiModelProperty(value = "路由策略:0——第一个，1——随机，2——最后一个")


  public Integer getRouteStategy() {
    return routeStategy;
  }

  public void setRouteStategy(Integer routeStategy) {
    this.routeStategy = routeStategy;
  }

  public TaskMJobInfo failover(Integer failover) {
    this.failover = failover;
    return this;
  }

  /**
   * 失败处理策略：0——忽略继续执行，1——失败重试，2——作业结束
   * @return failover
  **/
  @ApiModelProperty(value = "失败处理策略：0——忽略继续执行，1——失败重试，2——作业结束")


  public Integer getFailover() {
    return failover;
  }

  public void setFailover(Integer failover) {
    this.failover = failover;
  }

  public TaskMJobInfo failoverValue(String failoverValue) {
    this.failoverValue = failoverValue;
    return this;
  }

  /**
   * 失败处理策略附属参数
   * @return failoverValue
  **/
  @ApiModelProperty(value = "失败处理策略附属参数")


  public String getFailoverValue() {
    return failoverValue;
  }

  public void setFailoverValue(String failoverValue) {
    this.failoverValue = failoverValue;
  }

  public TaskMJobInfo timeout(Integer timeout) {
    this.timeout = timeout;
    return this;
  }

  /**
   * 超时时间，单位秒
   * @return timeout
  **/
  @ApiModelProperty(value = "超时时间，单位秒")


  public Integer getTimeout() {
    return timeout;
  }

  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskMJobInfo taskMJobInfo = (TaskMJobInfo) o;
    return Objects.equals(this.id, taskMJobInfo.id) &&
        Objects.equals(this.preId, taskMJobInfo.preId) &&
        Objects.equals(this.taskId, taskMJobInfo.taskId) &&
        Objects.equals(this.params, taskMJobInfo.params) &&
        Objects.equals(this.routeStategy, taskMJobInfo.routeStategy) &&
        Objects.equals(this.failover, taskMJobInfo.failover) &&
        Objects.equals(this.failoverValue, taskMJobInfo.failoverValue) &&
        Objects.equals(this.timeout, taskMJobInfo.timeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, preId, taskId, params, routeStategy, failover, failoverValue, timeout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskMJobInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    preId: ").append(toIndentedString(preId)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    routeStategy: ").append(toIndentedString(routeStategy)).append("\n");
    sb.append("    failover: ").append(toIndentedString(failover)).append("\n");
    sb.append("    failoverValue: ").append(toIndentedString(failoverValue)).append("\n");
    sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
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

