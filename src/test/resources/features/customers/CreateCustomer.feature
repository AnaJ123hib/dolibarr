Feature: Create Customer

  Background:
    Given the user is logged in
    And the user is on the create customer page

  Scenario: Create a customer with valid information
    When the user creates a new customer with valid information
    Then the customer details page should be displayed

  Scenario: Create a customer without customer name
    When the user attempts to create a customer without name
    Then a validation error message should be displayed

  Scenario: Create a customer without customer type
    When the user attempts to create a customer without customer type
    Then a validation error message should be displayed

  Scenario: Cancel customer creation
    When the user fills the customer form with valid information
    And the user clicks the Cancel button
    Then the customer should not be created