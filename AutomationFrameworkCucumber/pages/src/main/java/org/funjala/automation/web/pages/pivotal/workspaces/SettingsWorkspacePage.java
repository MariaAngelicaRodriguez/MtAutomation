package org.funjala.automation.web.pages.pivotal.workspaces;


import org.funjala.automation.web.model.pivotal.workspaces.SettingsWorkspaceModel;
import org.funjala.automation.web.pages.pivotal.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsWorkspacePage {

  WebDriver driver;
  WebDriverWait wait;

  /**
   * SettingsWorkspacePage constructor.
   * @param driver initialize & instance.
   */
  public SettingsWorkspacePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(name = SettingsWorkspaceModel.workspaceName)
  WebElement workspaceName;

  @FindBy(id = SettingsWorkspaceModel.deleteLink)
  WebElement deleteLink;

  @FindBy(name = SettingsWorkspaceModel.saveButton)
  WebElement saveButton;

  @FindBy(css = SettingsWorkspaceModel.cancel)
  WebElement cancel;

  @FindBy(id = SettingsWorkspaceModel.deleteButton)
  WebElement deleteButton;

  /**
   * Method to delete a workspace,
   * wait for element delete link & click on it.
   */
  public void deleteWorkspace() {
    wait.until(ExpectedConditions.elementToBeClickable(deleteLink));
    deleteLink.click();

  }

  /**
   * Method to confirm delete a workspace pop up.
   * @return TopMenuPage class with this driver.
   */
  public HomePage confirmDeleteWorkspace() {
    wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
    deleteButton.click();
    return new HomePage(driver);
  }
}
