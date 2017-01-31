package org.funjala.automation.web.common.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by RoyRodriguez on 12/19/2016.
 */
public class InternetExplorer {
  private WebDriver driver;


  /**
   * Internet Explorer Web driver.
   * @return driver.
   */
  public WebDriver getDriver() {
    String relativePath = "../tools/";
    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
    capabilities.setCapability(InternetExplorerDriver
            .INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    System.setProperty("webdriver.ie.driver", relativePath + "IEDriverServer32.exe");
    driver = new InternetExplorerDriver();
    return driver;
  }
}
