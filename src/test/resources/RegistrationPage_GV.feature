@UserStory-1
Feature: Registration features

  Background:
    Given I am on Web shop page
    When I click register header button


  @TC-006
  Scenario: Information confirmation after successful registration
    When I enter all information:
      | gender | male |
      | firstname | Test |
      | lastname  | OfTest |
      | email | test1212122221121222556@test.com |
      | password | test123 |
    And I click registration button
    And I click my Account button
    Then I check that information is correct:
      | gender | male |
      | firstname | Test |
      | lastname  | OfTest |
      | email | test1212122221121222556@test.com |
      | password | test123 |


  @TC-010
  Scenario: Email RegEx check
    When I enter all information:
      | gender | male|
      | firstname | Test |
      | lastname  | OfTest |
      | email | test1212.com |
      | password | test123 |
    And I click registration button
    And I see email warning message
    Then My register shouldnt be performed




  @TC-022
  Scenario: Same email logging
    When I enter all information:
      | gender | male |
      | firstname | Test |
      | lastname  | OfTest |
      | email | test133333313145516@test.com |
      | password | test123 |
    And I click registration button
    And I click Logout button
    And I click register header button
    And I enter all information:
      | gender | male |
      | firstname | Test |
      | lastname  | OfTest |
      | email | test13333331314551@test.com |
      | password | test123 |
    And I click registration button
    And I see warning message
    Then My register shouldnt be performed