package org.funjala.automation.web.pages.mach2.sidebar;

import org.funjala.automation.web.model.mach2.sidebar.SideBarModel;
import org.funjala.automation.web.pages.mach2.board.BoardOptions;
import org.funjala.automation.web.pages.mach2.dashboard.MyDashboard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JorgeForero on 1/19/2017.
 */
public class SideBarPage {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(linkText = SideBarModel.favoritesButton)
  private WebElement favoritesButton;

  @FindBy(linkText = SideBarModel.sharedWithMeButton)
  private WebElement sharedWithMeButton;

  @FindBy(css = SideBarModel.myDashboardButton)
  private WebElement myDashboardButton;

  @FindBy(xpath = "//div[@class='menu ui-sortable']")
  private WebElement boardsList;


  public SideBarPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }


  public MyDashboard clickMyDashboardButton() {
    wait.until(ExpectedConditions.elementToBeClickable(myDashboardButton));
    myDashboardButton.click();
    return new MyDashboard(driver);
  }

  public BoardOptions rightClickBoardCard(final WebElement board) {
    Actions action = new Actions(driver);
    action.contextClick(board).build().perform();
    return new BoardOptions(driver);
  }


  public void deleteAllBoards() {
    wait.until(ExpectedConditions.visibilityOf(boardsList));
    boardsList.findElements(By.tagName("a")).forEach(element -> {
      wait.until(ExpectedConditions.visibilityOf(element));
      wait.until(ExpectedConditions.elementToBeClickable(element));
      BoardOptions boardOption = rightClickBoardCard(element);
      boardOption.deleteBoardMach();
    });
  }
}
