Feature: Task
  In order to work with tasks on Pivotal Tracker
  As an user
  I want to create, edit and delete tasks

  Background: Login
    Given I am on Pivotal Tracker page
    And I put a at-02@outlook.com and press Next button
    And I put a Automation123 and press Submit button
    And I create a project as a TestProject
    And I select an account as a Jala
  @task
  Scenario: Create a Task
    When I create a story as a StoryTest
    And I add a task as a TestTask
    Then A task named TestTask should be created
  @task
  Scenario: Update name a Task
    When I create a story as a StoryTest
    And I have a task taskOne and taskTwo created
    When I change the name of taskTwo for TestTaskUpdated
    Then The task should be change to TestTaskUpdated
  @task
  Scenario: Create multiple Tasks with the same name
    When I create a story as a StoryTest
    And I add multiple tasks with the same name as TaskTest
    And I click on save story with tasks
    Then I should have created 5 tasks with the same name as TaskTest
  @task
  Scenario: Delete a Task
    When I create a story as a StoryTest
    And I have a task taskOne and taskTwo created
    When I delete taskOne
    Then taskOne should be deleted
  @task
  Scenario: Create task without name
    When I create a story as a StoryTest
    When I press add new task without name
    Then I expect an alert message
  @task
  Scenario: Check a task as Done
    Given I create a story as a StoryTest
    And I have a task taskOne and taskTwo created
    When I check in done the taskTwo created
    Then A task status should be show TASKS (1/2)