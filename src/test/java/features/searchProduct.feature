Feature: Search and Place the order for products

@OffersPage
Scenario Outline: Search Experience for Product search in both Home and Offers page


Given User is on GreenCart Landing Page 
 
When User searched with short name <Name> and extracted actual name of the product

Then User searched for <Name> short name in offers page to check if product exists with same name

Examples:
|	Name	|
|	Tom		|
|	Beet	|

