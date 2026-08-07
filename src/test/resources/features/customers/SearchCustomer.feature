Feature: Search Customer
  Background:
    Given the user is on List member page

  Scenario Outline: Search for an existing customer
  Given the user has created a customer
  When the user searches for the customer by "<searchType>"
  Then the customer should appear in the search results

    Examples:
      | searchType   |
      | ID           |
      | Name         |


Scenario: Search a non-existing customer
  When the user searches for a non-existing customer
  Then the user should see any customers in the search results

