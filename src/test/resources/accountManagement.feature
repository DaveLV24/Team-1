Feature: Account Management
  Scenario: Update account details
    Given I am logged in
    When I navigate to the Edit Account page
    And I update first name to "Al", last name to "Anderson", and email to "ndryev@gmail.com"
    And I click Save
    Then I should see a success message
    And the changes should be reflected on the account page