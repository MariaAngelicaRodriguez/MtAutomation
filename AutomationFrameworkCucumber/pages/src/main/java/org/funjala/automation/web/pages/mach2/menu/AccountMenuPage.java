package org.funjala.automation.web.pages.mach2.menu;

import org.funjala.automation.web.model.mach2.menu.AccountModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by DavidVallejos on 1/24/2017.
 */
public class AccountMenuPage {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(css = AccountModel.userMenu)
  private WebElement userMenu;

  @FindBy(css = AccountModel.logOutButton)
  private WebElement logOutButton;

  public AccountMenuPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }

  public void clickOnLogOut() {
    userMenu.click();
    logOutButton.click();
    driver.get("http://10.31.2.215:3666/");
  }
}
