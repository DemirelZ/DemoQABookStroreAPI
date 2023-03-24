Feature: Authorized

  Scenario: User should able to be authorized
    Given User should be authorized with valid cedentials
    Then verify authorized statusCode