package org.funjala.automation.web.pages.pivotal.projects;


import org.funjala.automation.web.model.pivotal.projects.ProjectsWorkSpacesModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 12/13/2016.
 */
public class ProjectsWorkSpacesPage {
  WebDriver driver;
  WebDriverWait wait;
  String nameOfProject;

  /**
   * Initialize Project and Workspaces page.
   *
   * @param driver return the driver initialized.
   */
  public ProjectsWorkSpacesPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = ProjectsWorkSpacesModel.linkShowProjects)
  private WebElement linkShowProjects;

  @FindBy(xpath = ProjectsWorkSpacesModel.project)
  private WebElement project;

  public boolean existProject() {
    return project.getText().equalsIgnoreCase(nameOfProject);
  }

  public void clickLinkShowProjects(String nameOfProject) {
    this.nameOfProject = nameOfProject;
    linkShowProjects.click();
  }
}
