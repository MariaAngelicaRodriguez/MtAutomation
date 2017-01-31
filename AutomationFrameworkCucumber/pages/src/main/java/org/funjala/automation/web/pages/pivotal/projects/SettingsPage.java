package org.funjala.automation.web.pages.pivotal.projects;


import org.funjala.automation.web.model.pivotal.projects.SettingsModel;
import org.funjala.automation.web.pages.pivotal.home.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 12/13/2016.
 */
public class SettingsPage {

  WebDriver driver;
  WebDriverWait wait;

  @FindBy(id = SettingsModel.deleteButton)
  WebElement deleteButton;

  @FindBy(id = SettingsModel.deleteConfirm)
  WebElement deleteConfirm;

  @FindBy(css = SettingsModel.pivotalTrackerIcon)
  WebElement pivotalTrackerIcon;

  @FindBy(xpath = SettingsModel.publicAccessCheckBox)
  WebElement publicAccessCheckBox;

  @FindBy(id = SettingsModel.projectName)
  WebElement projectName;

  @FindBy(css = SettingsModel.saveBtn)
  WebElement saveBtn;

  @FindBy(xpath = SettingsModel.linkNameProjectAccount)
  WebElement linkNameProjectAccount;


  public SettingsPage(WebDriver driver) {

    this.driver = driver;
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
    wait = new WebDriverWait(driver, 10);
  }


  public boolean verifyPrivateAccess() {
    boolean result = false;
    if (publicAccessCheckBox.getAttribute("checked") == null) {
      result = true;
    }
    return result;
  }

  public HomePage deleteProject() {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].scrollIntoView();", deleteButton);
    deleteButton.click();
    deleteConfirm.click();
    wait.until(ExpectedConditions.elementToBeClickable(pivotalTrackerIcon));
    return new HomePage(driver);
  }

  public void setProjectName(String projectName) {
    this.projectName.clear();
    this.projectName.sendKeys(projectName);
  }

  public void clickSave() {
    saveBtn.click();
  }

  public By getTitleProject(String projectNameChanged) {
    return By.xpath(
            ".//*[@id='shared_header']/div/div/header/ul/li[2]/div/h1/a/div[text() ='"
                    + projectNameChanged + "']");
  }

  public boolean contentNameAccount(String nameAccount) {
    return linkNameProjectAccount.getText().contains(nameAccount);
  }

  public void editProjectName(String projectName) {
    setProjectName(projectName);
    clickSave();

    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(getTitleProject(projectName)));
  }


}
