package org.funjala.automation.web.pages.pivotal.workspaces;

import java.util.List;


import org.funjala.automation.web.model.pivotal.workspaces.ManageWorkspaceModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageWorkspacePage {
  WebDriver driver;
  WebDriverWait wait;

  /**
   * ManageWorkspacePage class constructor.
   * @param driver initialize & instance.
   */
  public ManageWorkspacePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(css = ManageWorkspaceModel.selectProject)
  WebElement selectProject;

  @FindBy(css = ManageWorkspaceModel.saveProject)
  WebElement saveProject;

  @FindBy(xpath = ManageWorkspaceModel.projectName)
  List<WebElement> projectName;

  @FindBy(xpath = ManageWorkspaceModel.projectRemove)
  List<WebElement> projectRemove;

  /**
   * Method to add a project on the workspace.
   * @param projectName to add on the workspace.
   */
  public void addWorkspaceProject(String projectName) {
    wait.until(ExpectedConditions.elementToBeClickable(selectProject));
    selectProject.click();
    WebElement project = driver.findElement(By.xpath("//span[text()= '" + projectName + "']"));
    project.click();
    saveProject.click();
  }

  /**
   * Method to remove the project of the workspace
   * that was added.
   * @param name of project that need to be delete.
   */
  public void removeProject(String name) {
    for (WebElement element : projectName) {
      if (element.getText().equals(name.toUpperCase())) {
        for (WebElement remove : projectRemove) {
          remove.click();
        }
      }
    }
    saveProject.click();
  }
}

