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

