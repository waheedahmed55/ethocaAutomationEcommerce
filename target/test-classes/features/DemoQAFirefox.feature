#Author : Waheed Ahmed
Feature: Check out process for ecommerce website

  Background: 
    Given Firefox browser only validation

  @firefox
  Scenario: Verify the checkout process for ecommerce website
    Given Navigate to http://store.demoqa.com/ 
    When Navigate to Product category and select Accessories
    Then Click on Add to Cart button for just Magic Mouse
    Then Click on Checkout link and confirm you have 1 Magic Mouse in your Check-Out Page
    Then After confirming, click on Continue button
    Then Enter dummy data needed for email, billing or contact details and click Purchase
    Then Confirm that you have placed the Order in Transaction Result page