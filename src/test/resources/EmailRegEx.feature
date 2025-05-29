@UserStory-1
Feature: Registration features

  @TC-010
  Scenario: Email RegEx
    Given I am on Web shop page
    When I click register header button
    And I enter all information:
      | gender | male|
      | firstname | Test |
      | lastname  | OfTest |
      | email | test1212.com |
      | password | test123 |
    And I click registration button
    Then My register shouldnt be performed
