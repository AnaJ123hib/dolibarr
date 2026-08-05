Feature: Update Customer
  Background:
    Given the user is logged in
    And the user has created a customer

  Scenario: Update customer information
    When the user starts editing the customer information
    And the user saves the customer information
    Then the updated customer information should be displayed

  Scenario: Cancel customer update
    When the user starts editing the customer information
    And the user cancels the update
    Then the original customer information should remain unchanged

  Scenario Outline: Update customer with a required field missing
    When the user updates the customer leaving the "<field>" empty
    And the user saves the customer information
    Then a validation error message should be displayed

    Examples:
      | field            |
      | Name             |
      | Last name        |

