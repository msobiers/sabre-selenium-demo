@api
Feature: API login
  Client can authenticate through the login API

  Scenario: Successful API login
    Given the API login endpoint is available
    When the client sends valid login credentials
    Then the API should return a token
