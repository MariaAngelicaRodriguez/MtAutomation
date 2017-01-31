@table
Feature: Add Table Widget

  All Employees Personal Information are displayed
  when add  “Table” widget by a specific “Manager” name

  Background: Login
    Given I am login on Mach2 with credentials
      | user | password      |
      | at02 | Automation123 |

  Scenario: Add Table Widget with Employees Personal Information
    Given I have a board and widget created
    When I select "Table" icon on Widget options
    And I select "Open ERP" service
    And I select "Employees Personal Information" of Open ERP

    And I fill manager name on textfield as "Patricia Villagomez Montalvo"
    And I click on save button
    Then I have a table widget with "Patricia Villagomez Montalvo" filled

  Scenario: Add Table Widget with information of skills in java.
    Given I have a board and widget created
    When I select "Table" icon on Widget options
    And I select "Open ERP" service
    And I select "Engineer Information" of Open ERP

    And I fill division textfield as "Networking"
    And I click on save button
    Then I have a table widget with division "Networking"