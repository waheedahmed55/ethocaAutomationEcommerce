#Author : Waheed Ahmed
Feature: Check out process for ecommerce website

  Background: 
    Given chrome only validation

  @chrome
  Scenario: Verify the checkout process for ecommerce website
    Given Go to http://store.demoqa.com/ 
    When Go to Product category and select Accessories
    Then Click on Add to Cart for just Magic Mouse
    Then Click on Checkout and confirm you have 1 Magic Mouse in your Check-Out Page
    Then After confirming, click on Continue
    Then Enter test data needed for email, billing or contact details and click Purchase
    Then Confirm that you have placed the Order in Transaction Results page
    
