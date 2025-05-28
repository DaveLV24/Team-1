@UserStory-2
Feature: My Account page sub menus
  Background:
    Given I am on Demo Web Shop page
    When I click login header button
    And I enter login details:
      | email     | testuser1511@email.com  |
      | password  | password                |
    And I click login button

  @TC-029 @BUG-009 @BUG-010 @BUG-011
  Scenario: Sub menus under My Account are displayed
    When I click on my email in the header
    And I am redirected to My Account page
    Then I see My Account menu label
    And I see Customer info menu label
    And I see Orders menu label
    And I see Downloadable products menu label
    And I see Reward points menu label
    And I see Change password menu label

  @TC-029 @BUG-010
  Scenario: Access menu items missing in My Account page
    Then I see Wishlist option in the header
    And I see Log out option in the header
    And I see News and Blog options in the footer