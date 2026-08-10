Feature: Order
  Background:
    Given the user is logged in
    And the user is on commerce page
    And the user is on new order page

  Scenario: Create an order for an existing third party
    When the user starts creating the order information
    And the user saves the order information
    Then the order details page should be displayed

  Scenario: Cancel an order
    When the user starts creating the order information
    And the user cancel the order information
    Then the order should not be created
