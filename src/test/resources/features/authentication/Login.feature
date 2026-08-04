Feature: Login
  Background:
    Given the user is on the Login page

  Scenario: Successfully login
    When the user logins with valid credentials
    Then the dashboard page should be displayed

  Scenario: Login with invalid username
    When the user attempts to login with an invalid username
    Then the user should see an authentication error message

  Scenario: Login with invalid password
    When the user attempts to login with an invalid password
    Then the user should see an authentication error message


