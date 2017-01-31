package org.funjala.automation.web.pages.erp.navheader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 1/24/2017.
 */
public class NavHeader {
  private WebDriver driver;
  private WebDriverWait wait;

  public NavHeader(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }
  

}
