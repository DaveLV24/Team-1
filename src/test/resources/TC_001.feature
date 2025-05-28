Feature: Registration
  As a user
  I should be able to register into the system
  So that after registration I am able to login into the system


  Background:
    Given I am on Demo Web Shops Register page

  @TC_001
  Scenario: Password and confirmation password match
    When I enter first name
    And I enter second name
    And I enter email
    And I enter password
    And I enter the same confirmation password
    And I click Register
    Then I am navigated to confirmation page


  @TC_002
  Scenario: Password and confirmation password mismatch
    When I enter first name
    And I enter second name
    And I enter email
    And I enter password
    And I enter a different confirmation password
    And I click Register
    Then I see password mismatch error
    And I am blocked on the register page


  @TC_018
  Scenario: Logging with valid e-mail and password
    When I enter first name
    And I enter second name
    And I enter email
    And I enter password
    And I enter the same confirmation password
    And I click Register
    Then I am navigated to confirmation page
#  Logging steps
    When I click Log out
    Then I get logged out and redirected to home page
    When I click Log in on home page
    Then I am on the login page
#    When I enter valid login credentials
#    And I click Log in button
#    Then I am logged in successfully












