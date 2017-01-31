package org.funjala.automation.web.pages.pivotal.help;


import org.funjala.automation.web.model.pivotal.help.QuickStartModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Fernando on 12/19/2016.
 */

public class QuickStartHelp {
  WebDriver driver;

  public QuickStartHelp(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = QuickStartModel.quickStartTitle)
  WebElement quickStartTitle;

  public boolean verifyTitle() {
    return quickStartTitle.getText().equals(driver.getTitle());
  }
}
