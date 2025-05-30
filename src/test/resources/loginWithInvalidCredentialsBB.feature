@UserStory-1 @TC-020
Feature: Logging in with invalid e-mail and password
  Background:
    Given I am on Demo Web Shop page
    When I click login header button

  @TC-020
  Scenario Outline: invalid email and password inputs in login page
    When I enter login details:
      | email     | <email>     |
      | password  | <password>  |
    And I click login button
    Then I see error login error message: "Login was unsuccessful. Please correct the errors and try again. No customer account found"
    Examples:
      | email                     | password    |
      | sometestuser111@email.com | 1234dfsa    |
      | kalnotright123@mail.com   | ihfwnl111jn |
