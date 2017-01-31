package org.funjala.automation.web.pages.pivotal.help;

import org.funjala.automation.web.model.pivotal.help.ContactSupportModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by fmiquiza on 22/12/2016.
 */
public class ContactSupportPage {
  private WebDriver driver;

  @FindBy(xpath = ContactSupportModel.contactSupportButton)
  WebElement contactSupportButton;

  @FindBy(xpath = ContactSupportModel.contactSupportTitle)
  WebElement contactSupportTitle;

  public ContactSupportPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickContactSupportBtn() {
    contactSupportButton.click();
  }

  /**
   * Verify ContactSupport Page.
   *
   * @return Flag true if Contact Support Title is found.
   */
  public boolean verifyContactSupport() {
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

        clickContactSupportBtn();
        flag = contactSupportTitle.getText().equals(driver.getTitle());
        driver.close();
      }
    } catch (Exception exception) {
    }
    return flag;
  }

}