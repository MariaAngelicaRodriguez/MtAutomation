@list
Feature: Add List Widget for Job Title

  All Employees Personal Information with "CFO" kb title are displayed
  when add  “List” widget

  Scenario: Add List Widget with Employees Personal Information for Job Title
    Given I am login on Mach2 with credentials
      | user | password      |
      | at02 | Automation123 |
    And I have a board and widget created
    When I select "List" icon on Widget options
    And I select "Open ERP" service
    And I select "Engineer Information" of Open ERP

    And I fill Job Title with "CFO" option and I click on save
    Then I have a List widget with "Javier Zenon Sena Gutierrez"

