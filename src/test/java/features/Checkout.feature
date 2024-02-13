Feature: Place the order for products

@PlaceOrder
Scenario Outline: Search Experience for Product search in both Home and Offers page


Given User is on GreenCart Landing Page 
When User searched with short name <Name> and extracted actual name of the product
And Added "3" items of the selected product to the cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promo code and place the order 


Examples:
|	Name	|
|	Tom		|

