package org.funjala.automation.web.pages.erp.login;

import org.funjala.automation.web.model.erp.login.LoginModel;
import org.funjala.automation.web.pages.erp.home.OEHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OELoginPage {
  private WebDriver driver;
  private WebDriverWait wait;

  public OELoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(id = LoginModel.password)
  WebElement userName;

  @FindBy(id = LoginModel.userName)
  WebElement password;

  @FindBy(xpath = "//*[@id='fm1']/section[3]/input[4]")
  WebElement btnSubmit;

  public void setUserName(String user) {
    userName.sendKeys(user);
  }

  public void setPassword(String pass) {
    password.sendKeys(pass);
  }

  public OEHomePage clickBtnSubmit() {
    btnSubmit.click();
    return new OEHomePage(driver);
  }
}
