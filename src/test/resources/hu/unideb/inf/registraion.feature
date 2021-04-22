Feature: Automationpractice registraion process

  Background:
    Given The home page is opened
    And The Sign in link is clicked

  Scenario: User enter invalid email
    Given Create account is clicked
    Then an Invalid email address error message is show

  Scenario Outline:
    Given The email address field is field a valid email
    When I click Create an account
    And I leave empty this '<field>'
    And I click on the register button
    Then I get '<msg>' error message
    Examples:
      | field              | msg                                                                              |
      | customer_firstname | firstname is required.                                                           |
      | phone_mobile       | You must register at least one phone number.                                     |
      | customer_lastname  | lastname is required.                                                            |
      | passwd             | passwd is required.                                                              |
      | address1           | address1 is required.                                                            |
      | city               | city is required.                                                                |
      | id_state           | This country requires you to choose a State.                                     |

  Scenario: Verify registering with valid data
    Given The email address field is field a valid email
    When I click Create an account
    And User enters valid data
    And I click on the register button
    Then An account is created, user is redirected to My account page