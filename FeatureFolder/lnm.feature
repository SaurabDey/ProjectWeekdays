Feature: Negative Test
@Sanity
@Regression
  Scenario Outline: With incorrect user n pass
    Given the site is up and running
    When I provide incorrect credentials <userName> and <password>
    Then I validate I shouldnot get logged in

    Examples: 
      | userName  | password     |
      | Admintest | admin123test |
      | Admintest | admin123     |
      | Admin     | admin123test |
