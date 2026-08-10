Feature: Billing and Payment
  Background:
    Given the user is logged in
    And the user is on billing page

  Scenario: Create an invoice for an existing third party
    Given the user is on new invoice page
    When the user starts creating the invoice information
    And the user saves the invoice information
    Then the invoice details page should be displayed

  Scenario: Add a line to an invoice
    Given the user has created a invoice
    When the user adds a new line in the invoice
    Then the new line should be included in the invoice

  Scenario: Validate an invoice
    Given the user has created a invoice
    And the user has added a line
    When the user validates the invoice
    Then the invoice status should be changed to not pay
