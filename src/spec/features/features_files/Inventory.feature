@Inventory
Feature: Inventory features
  As a User, i want to connect to my account and add a product to my cart and verify the existance of the product in the cart so you can buy

  @AddOneToCart
  Scenario Outline: I want to login to my account and add a product to the cart
    Given I connect to the swagLabs application
    When I enter a valid data for the username field "standard_user"
    And I enter a valid data for the password field "secret_sauce"
    And I click on the Login button
    And I head toward the inventory page "Products"
    And I click on the addToCart button "<productbutton>"
    And I click on the cart icon
    And I head toward the cart page "Your Cart"
    Then I check if the product is added correctly "<productname>"

    Examples: 
      | productbutton                   | productname         |
      | add-to-cart-sauce-labs-backpack | Sauce Labs Backpack |

  @AddMultipleToCart
  Scenario Outline: I want to login to my account and add multiple products to the cart
    Given I connect to the swagLabs application
    When I enter a valid data for the username field "standard_user"
    And I enter a valid data for the password field "secret_sauce"
    And I click on the Login button
    And I head toward the inventory page "Products"
    And I add the following products to the cart:
      | add-to-cart-sauce-labs-backpack     |
      | add-to-cart-sauce-labs-bike-light   |
      | add-to-cart-sauce-labs-bolt-t-shirt |
    And I click on the cart icon
    And I head toward the cart page "Your Cart"
    Then I check if the products are added correctly:
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |

  @DeleteProduct
  Scenario Outline: I want to login to my account and add a product to the cart the delete it
    Given I connect to the swagLabs application
    When I enter a valid data for the username field "standard_user"
    And I enter a valid data for the password field "secret_sauce"
    And I click on the Login button
    And I head toward the inventory page "Products"
    And I click on the addToCart button "<productbutton>"
    And I click on the cart icon
    And I head toward the cart page "Your Cart"
    And I check if the product is added correctly "<productname>"
    And I click on delete button "<productdeletebutton>"
    Then I check if the product is not displayed "<productname>"

    Examples: 
      | productbutton                   | productname         | productdeletebutton        |
      | add-to-cart-sauce-labs-backpack | Sauce Labs Backpack | remove-sauce-labs-backpack |
