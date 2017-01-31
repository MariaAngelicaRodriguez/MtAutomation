package org.funjala.automation.web.common.drivers;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.funjala.automation.web.common.objectReader.ReadObject;
import org.funjala.automation.web.common.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driver {

  private static Driver instance;
  public static WebDriver driver;
  private WebDriver chrome;
  public static final String OpenERP = "urlOE";
  public static final String Mach2 = "urlMach2";
  public static final String Url = "url";

  private Driver() {
  }

  /**
   * This method is to open a browser.
   * It is possible implement more browsers.
   *
   * @return the driver of that browser was initialize.
   */
  public WebDriver openBrowser(String urlPage) throws IOException {
    ReadObject object = new ReadObject();
    Properties configurationObj = object.getObjectRepository();
    if (chrome == null) {
      driver = new WebDriverFactory(System.getProperty("browser")).getDriver();
      driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      chrome = driver;
    } else if (chrome != null) {
      driver = chrome;
    }

    if (urlPage.equals(OpenERP)) {
      driver.navigate().refresh();
      driver.get(configurationObj.getProperty(OpenERP));
    } else if (urlPage.equals(Mach2)) {
      driver.navigate().refresh();
      driver.get(configurationObj.getProperty(Mach2));
    } else {
      driver.navigate().refresh();
      driver.get(configurationObj.getProperty(Url));
    }
    return driver;
  }

  /**
   * Method to obtain the instance of the
   * singleton driver.
   *
   * @return the instance.
   */
  public static Driver getDriver() {
    if (instance == null) {
      instance = new Driver();
    }
    return instance;
  }

  public WebDriver getWebDriver() {
    return driver;
  }
}
