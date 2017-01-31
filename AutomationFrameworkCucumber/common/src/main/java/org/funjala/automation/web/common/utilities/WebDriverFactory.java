package org.funjala.automation.web.common.utilities;

import org.openqa.selenium.WebDriver;

/**
 * Created by RoyRodriguez on 12/19/2016.
 */
public class WebDriverFactory {
  private GoogleChrome chrome;
  private Firefox firefox;
  private InternetExplorer internetExplorer;
  private String browserName;
  private WebDriver driver;

  /**
   * Web driver Factory.
   * @param browserName browser name.
   */
  public WebDriverFactory(String browserName) {
    this.browserName = browserName.toUpperCase();
    IllegalArgumentException exception = new IllegalArgumentException(browserName
            + " browser doesn't exist");

    switch (this.browserName) {
      case "CHROME":
        chrome = new GoogleChrome();
        driver = chrome.getDriver();
        break;
      case "FIREFOX":
        firefox = new Firefox();
        driver = firefox.getDriver();
        break;
      case "IEXPLORER":
        internetExplorer = new InternetExplorer();
        driver = internetExplorer.getDriver();
        break;
      default:
        throw exception;
    }
  }

  public WebDriver getDriver() {
    return driver;
  }
}
