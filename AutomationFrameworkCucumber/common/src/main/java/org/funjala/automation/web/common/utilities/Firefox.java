package org.funjala.automation.web.common.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by RoyRodriguez on 12/19/2016.
 */
public class Firefox {
  private WebDriver driver;

  /**
   * Firefox web driver.
   * @return driver.
   */
  public WebDriver getDriver() {
    String relativePath = "../tools/";
    System.setProperty("webdriver.gecko.driver", relativePath + "geckodriver.exe");
    driver = new FirefoxDriver();
    return driver;
  }
}
