Feature: Commercial Proposals

  Background:
    Given the user is logged in
    And the user is on commerce page
    And the user is on new proposal page

  Scenario: Create a commercial proposal for an existing third party
    When the user starts creating the proposal information
    And the user saves the proposal information
    Then the proposal details page should be displayed

  Scenario: Search for an existing proposal
    Given the user has created a proposal
    When the user searches for the customer by ID
    Then the proposal should appear in the search results

  Scenario: Cancel a commercial proposal
    When the user starts creating the proposal information
    And the user cancel the proposal information
    Then the proposal should not be created

