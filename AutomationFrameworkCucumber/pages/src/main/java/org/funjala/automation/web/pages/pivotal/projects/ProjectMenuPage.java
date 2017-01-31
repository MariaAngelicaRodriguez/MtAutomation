package org.funjala.automation.web.pages.pivotal.projects;


import org.funjala.automation.web.model.pivotal.projects.ProjectMenuModel;
import org.funjala.automation.web.pages.pivotal.stories.SideBarStoriesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Topo on 10/12/2016.
 */
public class ProjectMenuPage {

  WebDriver driver;
  WebDriverWait wait;

  @FindBy(xpath = ProjectMenuModel.projectName)
  WebElement projectNameElement;

  @FindBy(css = ProjectMenuModel.settingButton)
  WebElement settingsBtn;

  @FindBy(css = "li.item.epics > a > span")
  WebElement epicsButton;

  @FindBy(xpath = "//div/header/ul/li[3]/div")
  WebElement projectProfileName;

  public ProjectMenuPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  public boolean verifyProjectName(String projectName) {
    return projectNameElement.getText().equalsIgnoreCase(projectName) ? true : false;
  }

  public void clickProfileName() {
    wait.until(ExpectedConditions.elementToBeClickable(projectProfileName));
    projectProfileName.click();
  }

  public SettingsPage clickSettings() {
    try {
      Thread.sleep(1000);
      wait.until(ExpectedConditions.elementToBeClickable(projectNameElement));
      wait.until(ExpectedConditions.elementToBeClickable(epicsButton));
      settingsBtn.click();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return new SettingsPage(driver);
  }

  public ProjectsWorkSpacesPage clickProjectsAndWorkSpaces() {
    projectNameElement.click();
    return new ProjectsWorkSpacesPage(driver);
  }

  public SideBarStoriesPage sideBarStories() {
    wait.until(ExpectedConditions.titleIs(driver.getTitle()));
    return new SideBarStoriesPage(driver);
  }
}
