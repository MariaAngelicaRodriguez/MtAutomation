package org.funjala.automation.web.common.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by RoyRodriguez on 12/19/2016.
 */
public class GoogleChrome {
  WebDriver driver;

  /**
   * Chrome web driver.
   * @return driver
   */
  public WebDriver getDriver() {
    String relativePath = "../tools/";
    System.setProperty("webdriver.chrome.driver", relativePath + "chromedriver.exe");
    driver = new ChromeDriver();
    return driver;
  }
}
