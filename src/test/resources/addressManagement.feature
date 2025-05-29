Feature: Address Management

  Scenario: User adds new address
    Given I am logged in
    When I navigate to Addresses page
    And I click Add New button
    And I fill in all required address fields
    And I click Save button
    Then I should see a success message