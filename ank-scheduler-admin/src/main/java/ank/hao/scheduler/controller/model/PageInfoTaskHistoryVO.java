package ank.hao.scheduler.controller.model;

import java.util.Objects;
import ank.hao.scheduler.controller.model.PageInfoTaskHistoryVOData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PageInfoTaskHistoryVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-11T14:07:43.697+08:00")

public class PageInfoTaskHistoryVO   {
  @JsonProperty("total")
  private Long total = null;

  @JsonProperty("pageNum")
  private Integer pageNum = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("size")
  private Integer size = null;

  @JsonProperty("pages")
  private Integer pages = null;

  @JsonProperty("data")
  private PageInfoTaskHistoryVOData data = null;

  public PageInfoTaskHistoryVO total(Long total) {
    this.total = total;
    return this;
  }

  /**
   * 记录总数
   * @return total
  **/
  @ApiModelProperty(value = "记录总数")


  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public PageInfoTaskHistoryVO pageNum(Integer pageNum) {
    this.pageNum = pageNum;
    return this;
  }

  /**
   * 当前页码
   * @return pageNum
  **/
  @ApiModelProperty(value = "当前页码")


  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  public PageInfoTaskHistoryVO pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * 每页记录
   * @return pageSize
  **/
  @ApiModelProperty(value = "每页记录")


  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public PageInfoTaskHistoryVO size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * 当前页记录
   * @return size
  **/
  @ApiModelProperty(value = "当前页记录")


  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public PageInfoTaskHistoryVO pages(Integer pages) {
    this.pages = pages;
    return this;
  }

  /**
   * 总页数
   * @return pages
  **/
  @ApiModelProperty(value = "总页数")


  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public PageInfoTaskHistoryVO data(PageInfoTaskHistoryVOData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PageInfoTaskHistoryVOData getData() {
    return data;
  }

  public void setData(PageInfoTaskHistoryVOData data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageInfoTaskHistoryVO pageInfoTaskHistoryVO = (PageInfoTaskHistoryVO) o;
    return Objects.equals(this.total, pageInfoTaskHistoryVO.total) &&
        Objects.equals(this.pageNum, pageInfoTaskHistoryVO.pageNum) &&
        Objects.equals(this.pageSize, pageInfoTaskHistoryVO.pageSize) &&
        Objects.equals(this.size, pageInfoTaskHistoryVO.size) &&
        Objects.equals(this.pages, pageInfoTaskHistoryVO.pages) &&
        Objects.equals(this.data, pageInfoTaskHistoryVO.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, pageNum, pageSize, size, pages, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageInfoTaskHistoryVO {\n");
    
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    pageNum: ").append(toIndentedString(pageNum)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    pages: ").append(toIndentedString(pages)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

