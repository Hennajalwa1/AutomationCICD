
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Positive test of submitting order
    Given I landed on ecommerce page 
    When Login with username <name> and <password>
		Then "Incorrect email or password." message is displayed
    Examples: 
      | name                      | password   | productName |
      |harrypotteruk958@gmail.com | Abcde@123  | ZARA COAT 3 |

