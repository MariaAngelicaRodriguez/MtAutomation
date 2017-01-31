Feature: Employees personal information by Department

  Scenario: Add Table Widget with Employees Personal Information
    Given I am login on Mach2 with credentials
      | user | password      |
      | at02 | Automation123 |
    And I have a board and widget created
    When I select "Table" icon on Widget options
    And I select "Open ERP" service
    And I select "Employees Personal Information" of Open ERP

    And I set department name with "Security test"
    And I save that option with the department "Security test" selected
    Then I have a table with employees filtered for a "Security test"