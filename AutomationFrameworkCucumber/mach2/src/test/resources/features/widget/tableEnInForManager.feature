Feature: Widget using Open ERP service to show Engineer Information

  Scenario: Add a Table Widget using Open ERP service to show Engineer Information for a Manager
    Given I am login on Mach2 with credentials
      | user | password      |
      | at02 | Automation123 |
    And I have a board and widget created
    When I select "Table" icon on Widget options
    And I select "Open ERP" service
    And I select "Engineer Information" of Open ERP

    And I choose "David Angeles Cambom" as value for Manager field
    And I click on save button
    And I obtain a table with the Engineer Information for "David Angeles Cambom" as manager
    Then I should have the same result using Open ERP web page to search Engineer Information for "David Angeles Cambom" as manager