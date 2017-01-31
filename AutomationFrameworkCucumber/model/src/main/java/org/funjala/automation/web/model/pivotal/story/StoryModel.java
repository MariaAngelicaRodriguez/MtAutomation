package org.funjala.automation.web.model.pivotal.story;

/**
 * Created by JorgeForero on 12/15/2016.
 */
public class StoryModel {

  public static final String storyTitleTextArea = "story[name]";

  public static final String saveStoryButton = "//button[contains(.,'Save')]";

  public static final String cancelCreateStoryButton = "//button[contains(.,'Cancel')]";

  public static final String editDescriptionButton = "//button[contains(.,'(edit)')]";

  public static final String stories = "//div/section/div/div/div/header";

  public static final String comment = ".//textarea[starts-with(@id,'comment')]";

  public static final String comments = "//section/section[6]/div/ol/li/header/following-sibling::div[@class='tracker_markup']";

  public static final String addCommentButton = "button[data-aid='comment-submit']";

  public static final String descriptionText = ".rendered_description.tracker_markup";

  public static final String storyDescriptionTextField = "story[pending_description]";

  public static final String doneDescriptionButton = "//button[contains(.,'Done')]";

  public static final String storyExpander = ".expander.undraggable";

  public static final String deleteStoryButton = "//button[@title='Delete this story']";

  public static final String confirmDeleteButton = "//button[@data-aid='DeleteButton']";

  public static final String storyDeletedMessage = "//li[contains(.,'1 story deleted')]";

  public static final String cancelDeleteButton = "//button[@data-aid='CancelButton']";

  public static final String storyEstimate = ".//a[starts-with(@id,'story_estimate_dropdown')]";

  public static final String storyEstimateIn2 = ".//a[starts-with(@id,'2_story_estimate_dropdown')]";

}
