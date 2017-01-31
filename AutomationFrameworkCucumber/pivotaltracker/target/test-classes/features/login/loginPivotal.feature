Feature: Sign-In to Pivotal Tracker as a newly created user

  Scenario: Sign-in to Pivotal Tracker with valid username and password.
    Given I navigate to Pivotal Tracker Website
    When I set a valid username/email as at-02@outlook.com
    And I press NEXT button a new password field should appear
    And I set a valid password as Automation123
    And I press the SIGN IN button
    Then I should be redirected to the Pivotal Dashboard