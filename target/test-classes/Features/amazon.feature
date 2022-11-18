Feature: validate Basic funactionality in Amazon

@amazon  
Scenario: Search, Add and verify whether product is add in cart

Given user searches "Nike" in Amazon home page
When user adds first product from the search result to cart
And user navigates to Cart page
Then user validates whether above added product is added in Cart
And user exits from the application