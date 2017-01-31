package org.funjala.automation.web.pages.pivotal.help;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


import org.funjala.automation.web.model.pivotal.help.FeedBackModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Fernando on 12/21/2016.
 */
public class FeedBackPage {
  private WebDriver driver;

  @FindBy(xpath = FeedBackModel.feedBackButton)
  WebElement feedBackButton;

  @FindBy(xpath = FeedBackModel.feedBackTitle)
  WebElement feedBackTitle;

  public FeedBackPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickFeedBackBtn() {
    feedBackButton.click();
  }

  /** Verify FeedBack Page.
   *
   * @return Flag true if Feed Back Title is found.
   */
  public boolean verifyFeedBack() {
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

        clickFeedBackBtn();
        flag = feedBackTitle.getText().equals(driver.getTitle());
        driver.close();
      }
    } catch (Exception exception) {
    }
    return flag;
  }

}
