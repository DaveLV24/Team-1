Feature: User Story Two. Address book.
  As a user I should be able to access and manipulate with account.

  Background:
    Given I open demo web shop page
    When I log in with email "asdfgh@asdfgh.com" and password "slaptas456"

  Scenario: TC-035 Add two addresses and verify each one
    When I navigate to my account addresses
    And I click add new address button
    And I add a new address with the following data
      | FirstName | John     |
      | LastName  | Doe      |
      | Email     | john.doe@example.com |
      | Country   | United States |
      | City      | New York |
      | Address1  | 123 Elm Street |
      | ZipCode   | 10001    |
      | Phone     | 1234567890 |
    Then I should see an address matching the entered data
      | FirstName | John     |
      | LastName  | Doe      |
      | Email     | john.doe@example.com |
      | Country   | United States |
      | City      | New York |
      | Address1  | 123 Elm Street |
      | ZipCode   | 10001    |
      | Phone     | 1234567890 |
    When I click add new address button
    And I add a new address with the following data
      | FirstName | Jane     |
      | LastName  | Smith    |
      | Email     | jane.smith@example.com |
      | Country   | Canada   |
      | City      | Toronto  |
      | Address1  | 456 Maple Avenue |
      | ZipCode   | M5H 2N2  |
      | Phone     | 9876543210 |
    Then I should see an address matching the entered data
      | FirstName | Jane     |
      | LastName  | Smith    |
      | Email     | jane.smith@example.com |
      | Country   | Canada   |
      | City      | Toronto  |
      | Address1  | 456 Maple Avenue |
      | ZipCode   | M5H 2N2  |
      | Phone     | 9876543210 |
    And I navigate to my account addresses
    And I should see two distinct addresses listed
    Then I delete all test addresses

  Scenario: TC-034 Verify new address page contains mandatory fields
    When I navigate to my account addresses
    And I click add new address button
    Then I leave empty form fields and click save

  Scenario: Verify user can select from multiple saved addresses during checkout
    When I navigate to my account addresses
    And I click add new address button
    And I add a new address with the following data
      | FirstName | John     |
      | LastName  | Doe      |
      | Email     | john.doe@example.com |
      | Country   | United States |
      | City      | New York |
      | Address1  | 123 Elm Street |
      | ZipCode   | 10001    |
      | Phone     | 1234567890 |
    And I click add new address button
    And I add a new address with the following data
      | FirstName | Jane     |
      | LastName  | Smith    |
      | Email     | jane.smith@example.com |
      | Country   | Canada   |
      | City      | Toronto  |
      | Address1  | 456 Maple Avenue |
      | ZipCode   | M5H 2N2  |
      | Phone     | 9876543210 |
    And I navigate to the books page
    And I add any book to the cart
    And I go to the shopping cart page
    And I agree with the terms of service
    And I proceed to checkout
    Then I should see multiple address options in the billing address dropdown