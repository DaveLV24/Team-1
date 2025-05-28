@UserStory-1
Feature: Registration features

  @TC-010
  Scenario: Email RegEx
    Given I am on Web shop page
    When I click register header button
    And I enter all credentials:
      | firstname | Test |
      | lastname  | OfTest |
      | email | test1212.com |
      | telephone | 12345678  |
      | password | test123 |
    And I click Privacy Policy check
    And I click registration button
    Then My register shouldnt be performed
