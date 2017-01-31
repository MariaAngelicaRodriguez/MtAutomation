Feature: Add widget table with Engineer Information search for division

  Scenario: Add widget table with employee information
    Given I am login on Mach2 with credentials
      | user | password      |
      | at02 | Automation123 |
    And I have a board and widget created
    When I select "Table" icon on Widget options
    And I select "Open ERP" service
    And I select "Engineer Information" of Open ERP

    And In the option Division I click on "Cleaning - Night Shift"
    And I click on save Button
    Then I have a table widget with "Cleaning - Night Shift" Division filled