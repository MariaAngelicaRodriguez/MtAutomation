package org.funjala.automation.web.pages.mach2.dashboard;

import org.funjala.automation.web.model.mach2.board.MyDashboardModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JorgeForero on 1/19/2017.
 */
public class MyDashboard {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(xpath = MyDashboardModel.optionDropdownButton)
  private WebElement optionDropdownButton;

  @FindBy(xpath = MyDashboardModel.deleteBoard)
  private WebElement deleteBoard;

  @FindBy(xpath = MyDashboardModel.confirmDelete)
  private WebElement confirmDelete;

  public MyDashboard(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }

  public void deleteBoard() {
    wait.until(ExpectedConditions.elementToBeClickable(optionDropdownButton));
    optionDropdownButton.click();
    wait.until(ExpectedConditions.elementToBeClickable(deleteBoard));
    deleteBoard.click();
    wait.until(ExpectedConditions.elementToBeClickable(confirmDelete));
    confirmDelete.click();
  }
}
