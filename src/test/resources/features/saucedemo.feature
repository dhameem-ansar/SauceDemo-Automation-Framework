
Feature: SauceDemo Application Testing

  Background:
    Given the user is on the SauceDemo login page

  Scenario: TC01 - Login with valid credentials
    When the user enters username "standard_user" and password "secret_sauce"
    And the user clicks the login button
    Then the user should be redirected to the products page
  @Smoke
  Scenario: TC02 - Login with invalid credentials
    When the user enters username "Dhamii" and password "Dhamee@123"
    And the user clicks the login button
    Then an error message should be displayed

  Scenario: TC03 - Add product to cart
    When the user enters username "standard_user" and password "secret_sauce"
    And the user clicks the login button
    And the user adds the first product to the cart
    Then the cart count should be "1"

  Scenario: TC04 - Remove product from cart
    When the user enters username "standard_user" and password "secret_sauce"
    And the user clicks the login button
    And the user adds the first product to the cart
    And the user removes the product from the cart
    Then the cart should be empty

  Scenario: TC05 - Logout from application
    When the user enters username "standard_user" and password "secret_sauce"
    And the user clicks the login button
    And the user clicks on the menu button
    And the user clicks on logout
    Then the user should be redirected to the login page