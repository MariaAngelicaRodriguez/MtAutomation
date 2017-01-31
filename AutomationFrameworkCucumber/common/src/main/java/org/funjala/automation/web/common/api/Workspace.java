package org.funjala.automation.web.common.api;

/**
 * Created by RoyRodriguez on 12/23/2016.
 */
public class Workspace {
  private String kind;
  private int id;
  private String name;

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
