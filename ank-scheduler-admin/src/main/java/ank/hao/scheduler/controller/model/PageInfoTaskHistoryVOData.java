package ank.hao.scheduler.controller.model;

import java.util.Objects;
import ank.hao.scheduler.controller.model.JobHistoryVO;
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
 * PageInfoTaskHistoryVOData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class PageInfoTaskHistoryVOData   {
  @JsonProperty("voList")
  @Valid
  private List<JobHistoryVO> voList = null;

  @JsonProperty("names")
  @Valid
  private List<String> names = null;

  @JsonProperty("displayNames")
  @Valid
  private List<String> displayNames = null;

  public PageInfoTaskHistoryVOData voList(List<JobHistoryVO> voList) {
    this.voList = voList;
    return this;
  }

  public PageInfoTaskHistoryVOData addVoListItem(JobHistoryVO voListItem) {
    if (this.voList == null) {
      this.voList = new ArrayList<>();
    }
    this.voList.add(voListItem);
    return this;
  }

  /**
   * Get voList
   * @return voList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<JobHistoryVO> getVoList() {
    return voList;
  }

  public void setVoList(List<JobHistoryVO> voList) {
    this.voList = voList;
  }

  public PageInfoTaskHistoryVOData names(List<String> names) {
    this.names = names;
    return this;
  }

  public PageInfoTaskHistoryVOData addNamesItem(String namesItem) {
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

  public PageInfoTaskHistoryVOData displayNames(List<String> displayNames) {
    this.displayNames = displayNames;
    return this;
  }

  public PageInfoTaskHistoryVOData addDisplayNamesItem(String displayNamesItem) {
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
    PageInfoTaskHistoryVOData pageInfoTaskHistoryVOData = (PageInfoTaskHistoryVOData) o;
    return Objects.equals(this.voList, pageInfoTaskHistoryVOData.voList) &&
        Objects.equals(this.names, pageInfoTaskHistoryVOData.names) &&
        Objects.equals(this.displayNames, pageInfoTaskHistoryVOData.displayNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(voList, names, displayNames);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageInfoTaskHistoryVOData {\n");
    
    sb.append("    voList: ").append(toIndentedString(voList)).append("\n");
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

