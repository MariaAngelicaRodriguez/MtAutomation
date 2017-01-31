package org.funjala.automation.web.pivotal.steps.task;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

import org.funjala.automation.web.common.api.ApiProjects;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.common.utilities.CucumberScreenshot;
import org.funjala.automation.web.common.utilities.Log;
import org.funjala.automation.web.pages.pivotal.home.HomePage;
import org.funjala.automation.web.pages.pivotal.login.LoginPage;
import org.funjala.automation.web.pages.pivotal.projects.CreateProjectPage;
import org.funjala.automation.web.pages.pivotal.projects.ProjectMenuPage;
import org.funjala.automation.web.pages.pivotal.stories.SideBarStoriesPage;
import org.funjala.automation.web.pages.pivotal.stories.StoryPage;
import org.funjala.automation.web.pages.pivotal.task.TaskPage;

import org.openqa.selenium.WebDriver;


public class TaskSteps {
  WebDriver driver;
  LoginPage login;
  HomePage home;
  CreateProjectPage project;
  ProjectMenuPage projectMenuPage;
  SideBarStoriesPage sideBarStories;
  StoryPage storyPage;
  TaskPage taskPage;
  Log log = Log.getInstance();

  @Given("^I am on Pivotal Tracker page$")
  public void onPivotalTrackerPage() throws IOException {
    log.info("Step", "I am on Pivotal Tracker page", "Going to pivotal tracker page");
    driver = Driver.getDriver().openBrowser(Driver.Url);
    login = new LoginPage(driver);
  }

  @And("^I put a ([^\"]*) and press Next button$")
  public void putNameAndPressNextButton(String userName) {
    log.info("Step", "I put a " + userName + " and press Next button", "Inserting username");
    login.setUserName(userName);
    login.clickContinue();
  }

  @And("^I put a ([^\"]*) and press Submit button$")
  public void putPasswordAndPressSubmitButton(String password) {
    log.info("Step", "I put a " + password + " and press Submit button", "Inserting password and pressing submit button");
    login.setPassword(password);
    home = login.clickSubmit();
  }

  @And("^I create a project as a ([^\"]*)$")
  public void createProject(String projectName) {
    log.info("Step", "I create a project as a " + projectName, "Pressing create project button and setting the project name");
    project = home.clickCreateProject();
    project.setProjectName(projectName);
  }

  @And("^I select an account as a ([^\"]*)$")
  public void selectAccount(String account) {
    log.info("Step", "I select an account as a " + account, "Selecting an account");
    project.clickSelectAccount(account);
    projectMenuPage = project.clickCreate();
  }

  /**
   * Create a Story to add Task.
   *
   * @param storyName name of the story for the test.
   */
  @When("^I create a story as a (.*)$")
  public void createAStoryWithXName(String storyName) {
    log.info("Step", "I create a story as a " + storyName, "Creating an user story");
    sideBarStories = projectMenuPage.sideBarStories();
    storyPage = sideBarStories.clickOnAddStoryButton();
    storyPage.setTitleStory(storyName);
    taskPage = storyPage.clickCreateTask(driver);
  }

  @And("^I add a task as a (.*)$")
  public void addATaskWithXName(String taskName) {
    log.info("Step", "I add a task as a " + taskName, "Creating an user story");
    taskPage.addTask(taskName);
    storyPage.clickOnCreateStory();
  }

  @Then("^A task named (.*) should be created$")
  public void taskCalledXShouldBeCreated(String expectedTaskName) {
    log.info("Step", "A task named " + expectedTaskName + " should be created", "Verifying the creation of task");
    storyPage.clickOnExpandStory();
    assertEquals(1, taskPage.sizeContentNameTask(expectedTaskName));
  }

  /**
   * Add multiple task with the same name.
   *
   * @param taskName for the test.
   */
  @And("^I add multiple tasks with the same name as ([^\"]*)$")
  public void addMultipleTasksWithSameName(String taskName) {
    log.info("Step", "I add multiple tasks with the same name as " + taskName, "Creating multiple tasks");
    taskPage.addTask(taskName);
    taskPage.addTask(taskName);
    taskPage.addTask(taskName);
    taskPage.addTask(taskName);
    taskPage.addTask(taskName);
  }

  @And("^I click on save story with tasks$")
  public void clickOnSaveStoryWithTasks() {
    log.info("Step", "I click on save story with tasks", "Saving tasks");
    storyPage.clickOnCreateStory();
    storyPage.clickOnExpandStory();
  }

  @Then("^I should have created (\\d+) tasks with the same name as ([^\"]*)$")
  public void verifyTasksWasCreate(int tasks, String nameTask) {
    log.info("Step", "I should have created " + tasks + "tasks with the same name as " + nameTask, "Verifying tasks created");

    assertEquals(tasks, taskPage.sizeContentNameTask(nameTask));
  }
  //*******************************************************

  @And("^I have a task (.*?) and (.*?) created$")
  public void createTasks(String taskNameOne, String taskNameTwo) throws Throwable {
    log.info("Step", "I have a task " + taskNameOne + " and " + taskNameTwo + " created", "Creating two tasks.");
    taskPage = storyPage.clickCreateTask(driver);
    taskPage.addTask(taskNameOne);
    taskPage.addTask(taskNameTwo);
  }

  @When("^I delete (.*?)$")
  public void deleteTask(String taskName) throws Throwable {
    log.info("Step", "I delete " + taskName, "Deleting a task");
    taskPage.deleteTask(taskName);

  }


  @Then("^(.*?) should be deleted$")
  public void taskDeletedVerification(String taskName) throws Throwable {
    log.info("Step", taskName + " should be deleted", "Verifying deleted task");
    storyPage.clickOnCreateStory();
    storyPage.clickOnExpandStory();
    assertEquals(0, taskPage.sizeContentNameTask(taskName));
  }

  @When("^I change the name of (.*?) for (.*?)$")
  public void editTask(String taskName, String taskNameUpdate) throws Throwable {
    log.info("Step", "I change the name of " + taskName + " for " + taskNameUpdate, "Changing the name of a task");
    taskPage.editTask(taskName);
    taskPage.inputNewName(taskNameUpdate);
    storyPage.clickOnCreateStory();
  }


  @Then("^The task should be change to (.*?)$")
  public void taskEditVerification(String taskName) throws Throwable {
    log.info("Step", "The task should be change to " + taskName, "Verifying the changed name of a task");
    storyPage.clickOnExpandStory();
    assertEquals(1, taskPage.sizeContentNameTask(taskName));
  }

  @When("^I press add new task without name$")
  public void iPressAddNewTaskWithoutName() {
    log.info("Step", "I press add new task without name", "Pressing add new task button");
    taskPage.addTask("");
  }

  @Then("^I expect an alert message$")
  public void iExpectAnAlertMessage() {
    log.info("Step", "I expect an alert message", "Verifying alert message");
    assertTrue(taskPage.alertDialog().contains("Cannot Save Task"));
    taskPage.clickButtonOk();
    storyPage.clickOnCreateStory();
  }

  @When("^I check in done the (.*?) created$")
  public void doneTask(String taskName) throws Throwable {
    log.info("Step", "I check in done the " + taskName + "created", "Checking a task");
    taskPage.setCheckInput(taskName);
    storyPage.clickOnCreateStory();
  }

  @Then("^A task status should be show (.*?)$")
  public void verifyTheTaskIsDone(String result) {
    log.info("Step", "A task status should be show" + result, "Verifying task is done");
    storyPage.clickOnExpandStory();
    assertEquals(result, taskPage.getTaskDone());
  }

  /**
   * Method to clean up scenario.
   */
  @After("@task")
  public void logout(Scenario scenario) throws IOException {
    log.info("Step", "Deleting project by API", "Deleting the project");
    ApiProjects apiProjects = new ApiProjects();
    CucumberScreenshot screenshot = new CucumberScreenshot();
    screenshot.takeScreenshot(scenario, "pivotaltracker");
    apiProjects.deleteAllProjects();
    log.info("Step", "Logout of the account", "Quiting of the account");
    home.logOut();
    log.info("Step", "Go to the login page", "Going to the login page");
    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
  }
}
