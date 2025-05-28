@UserStory-2
Feature: My Account customer info page

  @TC-030 @BUG-009 @BUG-012
  Scenario Outline: Personal information is displayed in input fields
    Given I am on Demo Web Shop page
    When I click login header button
    And I enter login details:
      | email     | <email>     |
      | password  | <password>  |
    And I click login button
    When I click on my email in the header
    And I am redirected to My Account page
    And I click on Customers info menu option
    Then I can see "<first_name>" displayed in first name input field
    And I can see "<last_name>" displayed in last name input field
    And I can see "<email>" displayed in email input field
    Examples:
      | first_name  | last_name | email                   | password    |
      | test        | user      | testuser1511@email.com  | password    |
      | Kale        | Winters   | kalewinters123@mail.com | password123 |