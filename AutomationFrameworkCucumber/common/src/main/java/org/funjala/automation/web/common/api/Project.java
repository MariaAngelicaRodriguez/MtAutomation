package org.funjala.automation.web.common.api;
/**
 * Created by Administrator on 12/23/2016.
 */
public class Project {
  private Integer id;
  private String kind;
  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
