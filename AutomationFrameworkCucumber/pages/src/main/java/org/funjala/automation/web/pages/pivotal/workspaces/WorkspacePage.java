package org.funjala.automation.web.pages.pivotal.workspaces;

import java.util.List;


import org.funjala.automation.web.model.pivotal.workspaces.WorkspaceModel;
import org.funjala.automation.web.pages.pivotal.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkspacePage {
  WebDriver driver;
  WebDriverWait wait;

  /**
   * WorkspacePage constructor.
   * @param driver initialize & instance.
   */
  public WorkspacePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(css = WorkspaceModel.workspaceTitle)
  WebElement title;

  @FindBy(css = WorkspaceModel.settingLink)
  WebElement setting;

  @FindBy(id = WorkspaceModel.addRemoveButton)
  WebElement addRemoveButton;

  @FindBy(xpath = WorkspaceModel.addRemoveOption)
  List<WebElement> addRemoveOption;

  @FindBy(css = WorkspaceModel.homeLink)
  WebElement homeLink;

  @FindBy(css = WorkspaceModel.projectsList)
  List<WebElement> projectsList;


  public boolean workspaceTitle(String title) {
    wait.until(ExpectedConditions.elementToBeClickable(setting));
    return this.title.getText().equals(title);
  }

  /**
   * Method to go to settings on a workspace.
   * @return SettingsWorkspacePage class with this driver.
   */
  public SettingsWorkspacePage settingsWorkspace() {
    wait.until(ExpectedConditions.titleIs(driver.getTitle()));
    wait.until(ExpectedConditions.elementToBeClickable(setting));
    setting.click();
    return new SettingsWorkspacePage(driver);
  }

  /**
   * Method to go to add project button.
   * @return ManageWorkspacePage class with this driver.
   */
  public ManageWorkspacePage addProjectOption() {
    wait.until(ExpectedConditions.elementToBeClickable(addRemoveButton));
    addRemoveButton.click();

    for (WebElement element : addRemoveOption) {
      if (element.getAttribute("class").equals("add_projects")) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
      }
    }
    return new ManageWorkspacePage(driver);
  }

  /**
   * Method to return to Home page.
   * @return Homepage class with this driver.
   */
  public HomePage goToHome() {
    wait.until(ExpectedConditions.elementToBeClickable(title));
    homeLink.click();
    return new HomePage(driver);
  }

  /**
   * Method to verify if a project is added on a workspace.
   * @param name of the project to add.
   * @return boolean result.
   */
  public Boolean verifyProjectCreated(String name) {
    Boolean flag = false;
    for (WebElement element : projectsList) {
      if (element.getText().equals(name.toUpperCase())) {
        flag = true;
      }
    }
    return flag;
  }
}