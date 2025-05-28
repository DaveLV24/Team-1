


  Feature: User registration

  Scenario: Elements are on the register page
    When open register page
    Then ensure that first name, last name, email and password are displayed on page

  Scenario: Message fot blank input fields
    When open register page
    And press register button
    #And wait if needed
    Then ensure error messages


