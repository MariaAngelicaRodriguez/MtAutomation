package org.funjala.automation.web.common.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by SergioLanda on 12/20/2016.
 */
public class WebDriverTools {
  private WebDriver webDriver;
  private WebDriverWait webDriverWait;
  private Logger log = Logger.getLogger(getClass());

  public WebDriverTools(WebDriver webDriver, WebDriverWait webDriverWait) {
    this.webDriver = webDriver;
    this.webDriverWait = webDriverWait;
  }

  /**
   * Visible element.
   * @param webElement element needed.
   */
  public void waitUntilElementVisible(WebElement webElement) {
    try {
      this.webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    } catch (WebDriverException exception) {
      log.error(String.format("Element is not visible: %s", exception.getMessage()));
    }
  }

  /**
   * Visible element for send keys.
   * @param webElement element needed.
   */
  public void clearAndSendKeys(WebElement webElement, String text) {
    try {
      webElement.clear();
      webElement.sendKeys(text);
    } catch (WebDriverException exception) {
      log.error(String.format("Error when trying to clear and send key: %s, error message: %s",
              webElement, exception.getCause()));
    }
  }

  /**
   * Visible element for click.
   * @param webElement element needed.
   */
  public void clickOnElement(WebElement webElement) {
    try {
      webElement.click();
      log.info(String.format("The click action was performed on web element: %s", webElement));
    } catch (WebDriverException exception) {
      log.error(String.format("Error when trying to click on web element: %s, error message: %s",
              webElement, exception.getCause()));
    }
  }
}