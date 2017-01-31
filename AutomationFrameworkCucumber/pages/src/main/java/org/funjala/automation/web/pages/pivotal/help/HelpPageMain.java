package org.funjala.automation.web.pages.pivotal.help;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.funjala.automation.web.model.pivotal.help.HelpMainModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Fernando on 12/19/2016.
 */
public class HelpPageMain {
  private WebDriver driver;

  @FindBy(xpath = HelpMainModel.getStartedBtn)
  WebElement getStartedBtn;

  @FindBy(xpath = HelpMainModel.quickStartTitle)
  WebElement quickStartTitle;

  public HelpPageMain(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickGetStartedBtn() {
    getStartedBtn.click();
  }

  /** Verify QuickStart Page.
   *
   * @return Flag true if Quick Start Title is found.
   */
  public boolean verifyQuickStart() {
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

        clickGetStartedBtn();
        flag = quickStartTitle.getText().equals(driver.getTitle());
        driver.close();
      }
    } catch (Exception exception) {
    }
    return flag;
  }

}
