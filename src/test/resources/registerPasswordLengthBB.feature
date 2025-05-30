
@UserStory-1
Feature: Password length in registration page
  Background:
    Given I am on Demo Web Shop page
    When I open registration page
    And I enter valid first name, last name, and email:
      | first_name  | Kale  |
      | last_name   | Storm |


  @TC-003 @BUG-001 @BUG-021
  Scenario Outline: Invalid password length
    When I enter a password on length <number>
    And I click register button
    Then I see error message: "<error>"
    Examples:
      | number  | error                                                 |
      | 0       | Password is required.                                 |
      | 5       | The password should have at least 6 characters.       |
      | 1000    | The password should have at least 6 characters.       |

  @TC-003 @BUG-001
  Scenario Outline: Valid password length
    When I enter a password on length <number>
    And I see no error message
    And I click register button
    Then I see register confirmation message
    Examples:
      | number  |
      | 6       |
      | 999     |

