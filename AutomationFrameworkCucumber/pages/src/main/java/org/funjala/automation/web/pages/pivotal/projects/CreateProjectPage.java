package org.funjala.automation.web.pages.pivotal.projects;


import org.funjala.automation.web.model.pivotal.projects.CreateProjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Topo on 9/12/2016.
 */
public class CreateProjectPage {

  WebDriver driver;
  @FindBy(css = CreateProjectModel.projectName)
  WebElement projectName;

  @FindBy(css = CreateProjectModel.createBtn)
  WebElement createBtn;

  @FindBy(css = CreateProjectModel.menuButton)
  WebElement menuAccountButton;

  @FindBy(css = CreateProjectModel.selectorAccount)
  WebElement selectorAccount;

  @FindBy(css = CreateProjectModel.accountItem)
  WebElement accountItem;

  @FindBy(xpath = CreateProjectModel.typeProject)
  List<WebElement> typeProject;

  @FindBy(xpath = CreateProjectModel.projectNewAccount)
  WebElement projectNewAccount;

  @FindBy(xpath = CreateProjectModel.projectNameNewAccount)
  WebElement projectNameNewAccount;

  public CreateProjectPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void setProjectName(String name) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    projectName.sendKeys(name);
  }

  public ProjectMenuPage clickCreate() {
    createBtn.click();
    return new ProjectMenuPage(this.driver);
  }

  public void clickSelectAccount(String accountName) {
    menuAccountButton.click();

    accountItem = selectorAccount.findElement(By.xpath("//div[text()= '" + accountName + "']"));
    accountItem.click();
  }

  public void clickNewAccount(String accountName) {
    menuAccountButton.click();
    projectNewAccount.click();
    projectNameNewAccount.sendKeys(accountName);

  }

  public void selectPrivacy(String privacy) {
    for (WebElement element : typeProject) {
      if (privacy.equalsIgnoreCase(element.getAttribute("value"))) {
        element.click();
      }
    }
  }


}
