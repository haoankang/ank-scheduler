package ank.hao.scheduler.controller.model;

import java.util.Objects;
import ank.hao.scheduler.controller.model.JobVersionVO;
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
 * JobVersionVOList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class JobVersionVOList   {
  @JsonProperty("data")
  @Valid
  private List<JobVersionVO> data = null;

  @JsonProperty("names")
  @Valid
  private List<String> names = null;

  @JsonProperty("displayNames")
  @Valid
  private List<String> displayNames = null;

  public JobVersionVOList data(List<JobVersionVO> data) {
    this.data = data;
    return this;
  }

  public JobVersionVOList addDataItem(JobVersionVO dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<JobVersionVO> getData() {
    return data;
  }

  public void setData(List<JobVersionVO> data) {
    this.data = data;
  }

  public JobVersionVOList names(List<String> names) {
    this.names = names;
    return this;
  }

  public JobVersionVOList addNamesItem(String namesItem) {
    if (this.names == null) {
      this.names = new ArrayList<>();
    }
    this.names.add(namesItem);
    return this;
  }

  /**
   * Get names
   * @return names
  **/
  @ApiModelProperty(value = "")


  public List<String> getNames() {
    return names;
  }

  public void setNames(List<String> names) {
    this.names = names;
  }

  public JobVersionVOList displayNames(List<String> displayNames) {
    this.displayNames = displayNames;
    return this;
  }

  public JobVersionVOList addDisplayNamesItem(String displayNamesItem) {
    if (this.displayNames == null) {
      this.displayNames = new ArrayList<>();
    }
    this.displayNames.add(displayNamesItem);
    return this;
  }

  /**
   * Get displayNames
   * @return displayNames
  **/
  @ApiModelProperty(value = "")


  public List<String> getDisplayNames() {
    return displayNames;
  }

  public void setDisplayNames(List<String> displayNames) {
    this.displayNames = displayNames;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobVersionVOList jobVersionVOList = (JobVersionVOList) o;
    return Objects.equals(this.data, jobVersionVOList.data) &&
        Objects.equals(this.names, jobVersionVOList.names) &&
        Objects.equals(this.displayNames, jobVersionVOList.displayNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, names, displayNames);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobVersionVOList {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    names: ").append(toIndentedString(names)).append("\n");
    sb.append("    displayNames: ").append(toIndentedString(displayNames)).append("\n");
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

