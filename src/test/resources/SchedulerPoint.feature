Feature: Register an user
    Scenario: Find the ADMIN
      Given I have some users registered
      When I request for the ADMIN one
      Then The response should be an ADMIN user