package org.funjala.automation.web.pages.pivotal.stories;


import org.funjala.automation.web.model.pivotal.story.SideBarStoriesModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JorgeForero on 12/15/2016.
 */
public class SideBarStoriesPage {
  WebDriver driver;
  WebDriverWait wait;

  @FindBy(css = SideBarStoriesModel.addStoryButton)
  WebElement addStoryButton;

  public SideBarStoriesPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }

  public StoryPage clickOnAddStoryButton() {
    wait.until(ExpectedConditions.elementToBeClickable(addStoryButton));
    addStoryButton.click();
    return new StoryPage(driver);
  }
}
