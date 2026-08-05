Feature: Create Customer

  Background:
    Given the user is logged in
    And the user is on the create customer page

  Scenario: Create a customer with valid information
    When the user creates a new customer with valid information
    Then the customer details page should be displayed

  Scenario Outline: Create a customer without customer type
    When the user attempts to create a customer without "<field>"
    Then a validation error message should be displayed

    Examples:
      | field            |
      | Name             |
      | Last name        |
      | Member Type      |
      | Nature of member |

  Scenario: Cancel customer creation
    When the user fills the customer form with valid information
    And the user clicks the Cancel button
    Then the customer should not be created