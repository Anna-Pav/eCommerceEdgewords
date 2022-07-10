
Feature: Making a purchase as a registered user

  Background:
    Given I am on the website's login page
    And I enter username "marianne.pavlidou@gmail.com" and password "Strongpassword123!"
    And I navigate to the product page
    And I add the item to the cart
    And I go to the cart page

  Scenario: User makes a purchase using a discount coupon
    When I apply the coupon discount "edgewords"
    Then the total amount to be paid is updated correctly

  Scenario: User makes a purchase and the order is added in the 'My Orders' section
    When I complete the checkout process
    Then the order is saved in the orders page with "<order Number>"