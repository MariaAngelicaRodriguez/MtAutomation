@EmployeePI
Feature: Validate Employee Personal Information
  This scenario should validate  Employee Personal Information displayed on
  the widget retrieved from Open ERP

  Scenario: Verify the employee personal imformation in the info widget
    Given I am at Mach2 Webpage
    And I set Username as "angelica.rodriguez@fundacion-jala.org"
    And I set Password as "At24062406" and press Submit button
    And I add new Board to the Group
    And I click on Widget Button at the top menubar
    And I click on "Info" Icon inside the Widget options
    And I select "Open ERP" service Icon.

    And I select "Employees Personal Information" on Open ERP
    When I click on Divisions Combobox and select "Outsourcing"
    And I click save button
    And I should see the first Employee Personal Information by "Division": "Outsourcing"
    Then I should have the same result using Open ERP web page to search Employee Personal Information for "Jose Andres Fleitas Casas" as Employee
