package org.funjala.automation.web.pages.pivotal.home;

import org.funjala.automation.web.model.pivotal.home.HomeModel;
import org.funjala.automation.web.pages.pivotal.help.ContactSupportPage;
import org.funjala.automation.web.pages.pivotal.help.FeedBackPage;
import org.funjala.automation.web.pages.pivotal.help.HelpPageMain;
import org.funjala.automation.web.pages.pivotal.help.LearnMorePage;
import org.funjala.automation.web.pages.pivotal.projects.CreateProjectPage;
import org.funjala.automation.web.pages.pivotal.projects.ProjectsWorkSpacesPage;
import org.funjala.automation.web.pages.pivotal.workspaces.CreateWorkspacePage;
import org.funjala.automation.web.pages.pivotal.workspaces.WorkspaceListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Topo on 9/12/2016.
 */
public class HomePage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(xpath = HomeModel.createProjectBtn)
  WebElement createProjectBtn;

  @FindBy(xpath = HomeModel.pivotalBtn)
  private WebElement pivotalBtn;

  @FindBy(css = HomeModel.workspaceTab)
  WebElement workspaceTab;

  @FindBy(css = HomeModel.createWorkspaceButton)
  WebElement createWorkspace;

  @FindBy(xpath = HomeModel.logOutBtn)
  WebElement logOutBtn;

  @FindBy(xpath = HomeModel.signOutBtn)
  WebElement signOutBtn;

  @FindBy(xpath = HomeModel.helpLink)
  WebElement helpLink;


  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  public CreateProjectPage clickCreateProject() {
    wait.until(ExpectedConditions.titleIs(driver.getTitle()));
    wait.until(ExpectedConditions.elementToBeClickable(createProjectBtn));
    wait.until(ExpectedConditions.visibilityOf(createProjectBtn));
    createProjectBtn.click();
    return new CreateProjectPage(this.driver);
  }

  public void logOut() {
    logOutBtn.click();
    signOutBtn.click();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public ProjectsWorkSpacesPage clickProjectsAndWorkSpaces() {
    pivotalBtn.click();
    return new ProjectsWorkSpacesPage(driver);
  }

  public WorkspaceListPage clickWorkspaceTab() {
    workspaceTab.click();
    return new WorkspaceListPage(driver);
  }

  public HelpPageMain clickHelpPageButton() {
    helpLink.click();
    return new HelpPageMain(driver);
  }

  public CreateWorkspacePage clickCreateWorkspaceLink() {
    createWorkspace.click();
    return new CreateWorkspacePage(driver);
  }

  public LearnMorePage clickLearnMoreButton() {
    helpLink.click();
    return new LearnMorePage(driver);
  }

  public FeedBackPage clickGiveUsFeedBackLink() {
    helpLink.click();
    return new FeedBackPage(driver);
  }

  public ContactSupportPage clickContactSupportLink() {
    helpLink.click();
    return new ContactSupportPage(driver);
  }
}
