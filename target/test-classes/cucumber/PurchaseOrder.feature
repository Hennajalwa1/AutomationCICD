

@tag
Feature: Purchase the order from Ecommerce
  I want to use this template for my feature file

  Background:
  Given : I landed on ecommerce page 
  @Regression
  Scenario Outline: Positive test of submitting order
    Given Login with username <name> and <password>
    When I add product <productName> to Cart
    And Check out the <productName> and submit the order
		Then "Thankyou for the order." message is didplayed on confirmationPage
    Examples: 
      | name                      | password   | productName |
      |harrypotteruk958@gmail.com | Abcde@123  | ZARA COAT 3 |
