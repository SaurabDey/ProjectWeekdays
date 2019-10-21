
Feature: Positive Tests

@Smoke
  Scenario: With correct user n pass
    Given the site is up and running
    When I provide correct credentials Admin and admin123
    Then I validate I an logged in
