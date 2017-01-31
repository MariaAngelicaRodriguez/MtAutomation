package org.funjala.automation.web.pages.pivotal.stories;


import org.funjala.automation.web.model.pivotal.story.StoryModel;
import org.funjala.automation.web.pages.pivotal.task.TaskPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by JorgeForero on 12/15/2016.
 */
public class StoryPage {
  WebDriver driver;

  @FindBy(name = StoryModel.storyTitleTextArea)
  private WebElement storyTitleTextArea;

  @FindBy(xpath = StoryModel.saveStoryButton)
  WebElement saveStoryButton;

  @FindBy(xpath = StoryModel.cancelCreateStoryButton)
  WebElement cancelCreateStoryButton;

  @FindBy(xpath = StoryModel.editDescriptionButton)
  WebElement editDescriptionButton;

  @FindBy(css = StoryModel.descriptionText)
  WebElement descriptionText;

  @FindBy(name = StoryModel.storyDescriptionTextField)
  WebElement storyDescriptionTextField;

  @FindBy(xpath = StoryModel.storyEstimate)
  WebElement storyEstimate;

  @FindBy(xpath = StoryModel.storyEstimateIn2)
  WebElement storyEstimateIn2;

  @FindBy(xpath = StoryModel.doneDescriptionButton)
  WebElement doneDescriptionButton;

  @FindBy(css = StoryModel.storyExpander)
  WebElement storyExpander;

  @FindBy(xpath = StoryModel.comment)
  private WebElement comment;

  @FindBy(css = StoryModel.addCommentButton)
  private WebElement addCommentButton;

  @FindBy(xpath = StoryModel.deleteStoryButton)
  WebElement deleteStoryButton;

  @FindBy(xpath = StoryModel.confirmDeleteButton)
  WebElement confirmDeleteButton;

  @FindBy(xpath = StoryModel.storyDeletedMessage)
  WebElement storyDeletedMessage;

  @FindBy(xpath = StoryModel.cancelDeleteButton)
  WebElement cancelDeleteButton;

  @FindBy(xpath = StoryModel.stories)
  List<WebElement> stories;

  @FindBy(xpath = StoryModel.comments)
  List<WebElement> comments;

  public StoryPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void setTitleStory(String name) {

    storyTitleTextArea.sendKeys(name);
  }

  public void clickOnCreateStory() {
    saveStoryButton.click();
  }

  public void clickOnExpandStory() {
    storyExpander.click();
  }

  public String getStoryName() {
    return storyTitleTextArea.getText();
  }

  public String getStoryDescription() {
    return descriptionText.getText();
  }

  public String getStoryEstimate() {
    return storyEstimate.getText();
  }


  public void setDescriptionTextarea(String storyDescription) {
    editDescriptionButton.click();
    storyDescriptionTextField.clear();
    storyDescriptionTextField.sendKeys(storyDescription);
    doneDescriptionButton.click();
  }

  public void setComment(String storyComment) {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].scrollIntoView();", addCommentButton);
    comment.clear();
    comment.sendKeys(storyComment);
    addCommentButton.click();
  }

  public void setStoryEstimateIn2() {
    storyEstimate.click();
    storyEstimateIn2.click();
  }

  public void clickDeleteStory() {
    deleteStoryButton.click();
    confirmDeleteButton.click();

  }

  public Boolean verifyDeleteStory(String projectName) {
    return existElement(stories, projectName);
  }

  public Boolean verifyExistCommentStory(String comment) {
    return existElement(comments, comment);
  }

  private Boolean existElement(List<WebElement> listElements, String name) {
    Boolean flag = false;
    for (WebElement element : listElements) {
      if (element.getText().contains(name))
        flag = true;
    }
    return flag;
  }

  public TaskPage clickCreateTask(WebDriver driver) {
    return new TaskPage(driver);
  }
}
