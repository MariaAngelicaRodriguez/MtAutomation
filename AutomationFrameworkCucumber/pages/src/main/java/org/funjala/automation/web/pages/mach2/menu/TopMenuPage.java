package org.funjala.automation.web.pages.mach2.menu;

import org.funjala.automation.web.model.mach2.menu.AccountModel;
import org.funjala.automation.web.model.mach2.menu.TopMenuModel;
import org.funjala.automation.web.pages.mach2.board.BoardPage;
import org.funjala.automation.web.pages.mach2.sidebar.SideBarPage;
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JorgeForero on 1/19/2017.
 */
public class TopMenuPage {
  private WebDriver driver;
  private WebDriverWait wait;

  @FindBy(css = TopMenuModel.menuIcon)
  private WebElement menuIcon;

  @FindBy(css = AccountModel.userMenu)
  private WebElement userMenu;

  @FindBy(css = AccountModel.logOutButton)
  private WebElement logOutButton;

  @FindBy(css = TopMenuModel.menuBoard)
  private WebElement menuBoard;

  @FindBy(xpath = TopMenuModel.jalaItem)
  private WebElement jalaItem;

  @FindBy(xpath = TopMenuModel.addBoard)
  private WebElement addBoard;

  @FindBy(css = TopMenuModel.addWidget)
  private WebElement addWidget;

  @FindBy(css = TopMenuModel.newBoard)
  private WebElement newBoard;

  public TopMenuPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }

  public void clickOnLogOut() throws InterruptedException {
    Thread.sleep(1000);
    userMenu.click();
    Thread.sleep(1000);
    logOutButton.click();
  }

  public void clickMenuBoard() {
    wait.until(ExpectedConditions.elementToBeClickable(jalaItem));
    jalaItem.click();
    wait.until(ExpectedConditions.visibilityOf(menuBoard));
    wait.until(ExpectedConditions.elementToBeClickable(menuBoard));
    menuBoard.click();
  }

  public SideBarPage goToSidebar() {
    menuIcon.click();
    return new SideBarPage(driver);
  }

  public WidgetPage addNewWidget() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    wait.until(ExpectedConditions.elementToBeClickable(addWidget));
    addWidget.click();
    return new WidgetPage(driver);
  }

  public void addNewBoard() {
    wait.until(ExpectedConditions.visibilityOf(jalaItem));
    wait.until(ExpectedConditions.elementToBeClickable(jalaItem));
    jalaItem.click();
    newBoard.click();
    wait.until(ExpectedConditions.elementToBeClickable(addBoard));
    addBoard.click();
  }

  public BoardPage clickAddBoard() {
    clickMenuBoard();
    wait.until(ExpectedConditions.elementToBeClickable(addBoard));
    addBoard.click();
    return new BoardPage(driver);
  }

  public void clickJalaItem() {
    wait.until(ExpectedConditions.visibilityOf(jalaItem));
    wait.until(ExpectedConditions.elementToBeClickable(jalaItem));
    jalaItem.click();
  }

  public BoardPage goToBoardPage(){
    return new BoardPage(driver);
  }
}