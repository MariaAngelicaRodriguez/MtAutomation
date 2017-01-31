package org.funjala.automation.web.pages.pivotal.help;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


import org.funjala.automation.web.model.pivotal.help.LearnMoreModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Fernando on 12/21/2016.
 */

public class LearnMorePage {
  private WebDriver driver;

  @FindBy(xpath = LearnMoreModel.learnMoreButton)
  WebElement learnMoreBtn;

  @FindBy(xpath = LearnMoreModel.learnMoreTitle)
  WebElement learnMoreTitle;

  public LearnMorePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  /** Verify Learn More page.
   *
   * @return true if Title is found
   */
  public boolean verifyLearnMore() {
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

        learnMoreBtn.click();
        flag =  learnMoreTitle.getText().equals(driver.getTitle());
        driver.close();
      }
    } catch (Exception exception) {
    }
    return flag;
  }
}
