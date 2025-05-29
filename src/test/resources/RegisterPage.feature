


  Feature: User registration

  Scenario: Elements are on the register page
    When open register page
    Then ensure that first name, last name, email and password are displayed on page
    # There is a bug for this scenario ( no phone number section)

  Scenario: Message fot blank input fields
    When open register page
    And press register button
    Then ensure error messages

 Scenario Outline: Error message for email
   When open register page
   And enter wrong "<email>" format
   And press register button
   Then error message is displayed

   Examples:
     |  email    |
     | @@@@@@    |
     | @inbox.lv |
     | aaaa.lv   |
     | 1223344   |

