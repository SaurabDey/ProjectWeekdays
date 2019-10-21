@Regression
Feature: All Test cases

  Background: 
    Given the site is up and running


  Scenario: With correct user n pass
    When I provide correct credentials Admin and admin123
    Then I validate I an logged in



  Scenario Outline: With incorrect user n pass
    When I provide incorrect credentials <userName> and <password>
    Then I validate I shouldnot get logged in

    Examples: 
      | userName  | password     |
      | Admintest | admin123test |
      | Admintest | admin123     |
      | Admin     | admin123test |
