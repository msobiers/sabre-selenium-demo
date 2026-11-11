@ui
Feature: Login
  User can sign in with valid credentials

  Scenario: Successful login
    Given the user is on the login page
    When the user enter the valid credentials
    Then the user should see welcome page

  Scenario Outline: Unsuccessful login
    Given the user is on the login page
    When the user enter the invalid credentials - <username> <password>
    Then the user should see error - <error>

  Examples:
  | username | password | error |
  | "asdad"  | "asd" | "Your username is invalid!" |
  | "tomsmith"  | "asd" | "Your password is invalid!" |
  | "asdad"  | "SuperSecretPassword!" | "Your username is invalid!" |