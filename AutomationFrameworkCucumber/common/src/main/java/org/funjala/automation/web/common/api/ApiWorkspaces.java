package org.funjala.automation.web.common.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RoyRodriguez on 12/23/2016.
 */
public class ApiWorkspaces {
  public ArrayList<Workspace> getAllWorkSpaces() throws IOException {
    ArrayList<Workspace> listOfWorkspace = new ArrayList<Workspace>();

    RestAssured restAssured = new RestAssured();

    List<String> listNames = restAssured.get("my/workspaces").jsonPath().getList("name");
    List<Integer> listId = restAssured.get("my/workspaces").jsonPath().getList("id");
    List<String> listKind = restAssured.get("my/workspaces").jsonPath().getList("kind");

    for (int index = 0; index < listNames.size(); index++) {
      Workspace workspace = new Workspace();
      workspace.setName(listNames.get(index));
      workspace.setId(listId.get(index));
      workspace.setKind(listKind.get(index));

      listOfWorkspace.add(workspace);
    }
    return listOfWorkspace;
  }

  public Workspace getWorkspaceByName(String nameOfWorkspace) throws IOException {
    for (Workspace workspace : getAllWorkSpaces()) {
      if (workspace.getName().equalsIgnoreCase(nameOfWorkspace)) {
        return workspace;
      }
    }
    return null;
  }

  public boolean deleteWorkspaceByName(String nameOfWorkspace) throws IOException {
    IllegalArgumentException exception = new IllegalArgumentException(
            nameOfWorkspace + "doesn't exist.");
    RestAssured restAssured = new RestAssured();
    Integer id = getWorkspaceByName(nameOfWorkspace).getId();
    String endPoint = "my/workspaces" + "/" + id;

    if (restAssured.delete(endPoint).statusCode() == 204) {
      return true;
    } else {
      throw exception;
    }
  }

  public boolean deleteAllWorkspaces() throws IOException {
    boolean res = false;
    for (Workspace workspace : getAllWorkSpaces()) {
      res = deleteWorkspaceByName(workspace.getName());
    }
    return res;
  }
}
