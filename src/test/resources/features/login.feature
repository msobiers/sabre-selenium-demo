@ui
Feature: Login
  User can sign in with valid credentials

  Scenario: Successful login
    Given the user is on the login page
    When the user enter the valid credentials
    Then the user should see welcome page