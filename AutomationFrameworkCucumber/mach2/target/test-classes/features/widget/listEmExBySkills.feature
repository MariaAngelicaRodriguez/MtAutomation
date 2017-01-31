Feature: Validate list of Employees
  This scenario should validate Employee Experience by a Skill search containing Cloud.


  Scenario: Verify list of Employees experience by specific Skill > Cloud.
    Given I am login on Mach2 with credentials
      | user | password      |
      | at02 | Automation123 |
    And I have a board and widget created
    When I select "List" icon on Widget options
    And I select "Open ERP" service
    And I select "Employees Experience" of Open ERP

    When I click on Skills combobox and select Cloud.
    And I click on save button
    Then I should see the list of Employees by Skill: "Cloud" on E.E. category
