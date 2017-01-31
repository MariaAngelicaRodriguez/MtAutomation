package org.funjala.automation.web.pages.pivotal.workspaces;


import org.funjala.automation.web.model.pivotal.workspaces.CreateWorkspaceModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateWorkspacePage {
  WebDriver driver;
  WebDriverWait wait;

  /**
   * CreteWorkspacePage class constructor.
   * @param driver initialize & instance.
   */
  public CreateWorkspacePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(css = CreateWorkspaceModel.workspaceName)
  WebElement workspaceName;

  @FindBy(css = CreateWorkspaceModel.createWorkspaceButton)
  WebElement createWorkspaceButton;

  @FindBy(css = CreateWorkspaceModel.cancelWorkspaceButton)
  WebElement cancelWorkspaceButton;

  public void setWorkspaceName(String name) {
    workspaceName.sendKeys(name);
  }

  /**
   * In this method it wait for a element that is clickable
   * then make a click to create a new workspace.
   * @return WorkspacePage class with this driver.
   */
  public WorkspacePage clickCreateWorkspace() {
    wait.until(ExpectedConditions.elementToBeClickable(createWorkspaceButton));
    createWorkspaceButton.click();
    return new WorkspacePage(driver);
  }
}
