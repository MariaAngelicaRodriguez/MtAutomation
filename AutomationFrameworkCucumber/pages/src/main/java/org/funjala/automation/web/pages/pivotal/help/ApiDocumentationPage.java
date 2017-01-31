package org.funjala.automation.web.pages.pivotal.help;


import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import org.funjala.automation.web.model.pivotal.help.ApiDocumentationModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Fernando on 12/20/2016.
 */

public class ApiDocumentationPage {
  WebDriver driver;

  public ApiDocumentationPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = ApiDocumentationModel.apiDocumentationBtn)
  WebElement apiDocumentationBtn;

  @FindBy(xpath = ApiDocumentationModel.apiDocumentationTitle)
  WebElement apiDocumentationTitle;

  public void clickApiDocumentationBtn() {
    apiDocumentationBtn.click();
  }

  /**
   * Verify API Documentation page.
   *
   * @return True if Title is verified.
   */
  public boolean verifyApiDocumentation() {
    boolean flag = false;
    try {

      Thread.sleep(5000);
      ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
      System.out.println(tabs2.size());

      for (int i = tabs2.size() - 1; i >= 0; i--) {
        Thread.sleep(2000);
        driver.switchTo().window(tabs2.get(i));
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        clickApiDocumentationBtn();
        flag = driver.getTitle().contains(apiDocumentationTitle.getText());
        driver.close();
      }
    } catch (Exception exception) {
    }
    return flag;
  }

}