Feature: User should able to generate new token


  Scenario: User should input the valid credential
    Given input valid credentials
    Then verify token statusCode
