package org.funjala.automation.web.pages.pivotal.login;


import org.funjala.automation.web.model.pivotal.login.LoginModel;
import org.funjala.automation.web.pages.pivotal.home.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Henrry on 9/12/2016.
 */
public class LoginPage {

  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(id = LoginModel.userName)
  WebElement userName;

  @FindBy(id = LoginModel.password)
  WebElement password;

  @FindBy(css = LoginModel.continueBtn)
  WebElement continueBtn;

  @FindBy(css = LoginModel.submitBtn)
  WebElement submitBtn;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  public void setUserName(String userNameStr) {
    userName.sendKeys(userNameStr);
  }

  public void setPassword(String pass) {
    password.sendKeys(pass);
  }

  public void clickContinue() {
    continueBtn.sendKeys(Keys.ENTER);
  }

  public HomePage clickSubmit() {
    wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
    submitBtn.sendKeys(Keys.ENTER);
    return new HomePage(driver);
  }

}
