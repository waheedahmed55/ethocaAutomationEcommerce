$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/DemoQAFirefox.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author : Waheed Ahmed"
    }
  ],
  "line": 2,
  "name": "Check out process for ecommerce website",
  "description": "",
  "id": "check-out-process-for-ecommerce-website",
  "keyword": "Feature"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Firefox browser only validation",
  "keyword": "Given "
});
formatter.match({
  "location": "DemoQAFireFox.firefox_browser_only_validation()"
});
formatter.result({
  "duration": 583593750,
  "error_message": "java.lang.NullPointerException\r\n\tat com.cucumber.test.DemoQAFireFox.firefox_browser_only_validation(DemoQAFireFox.java:69)\r\n\tat ✽.Given Firefox browser only validation(src/test/resources/features/DemoQAFirefox.feature:5)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 8,
  "name": "Verify the checkout process for ecommerce website",
  "description": "",
  "id": "check-out-process-for-ecommerce-website;verify-the-checkout-process-for-ecommerce-website",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@firefox"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "Navigate to http://store.demoqa.com/",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Navigate to Product category and select Accessories",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Click on Add to Cart button for just Magic Mouse",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Click on Checkout link and confirm you have 1 Magic Mouse in your Check-Out Page",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "After confirming, click on Continue button",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "Enter dummy data needed for email, billing or contact details and click Purchase",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "Confirm that you have placed the Order in Transaction Result page",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoQAFireFox.navigate_to_http_store_demoqa_com()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DemoQAFireFox.navigate_to_Product_category_and_select_Accessories()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DemoQAFireFox.click_on_Add_to_Cart_button_for_just_Magic_Mouse()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 44
    }
  ],
  "location": "DemoQAFireFox.click_on_Checkout_link_and_confirm_you_have_Magic_Mouse_in_your_Check_Out_Page(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DemoQAFireFox.after_confirming_click_on_Continue_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DemoQAFireFox.enter_dummy_data_needed_for_email_billing_or_contact_details_and_click_Purchase()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "DemoQAFireFox.confirm_that_you_have_placed_the_Order_in_Transaction_Result_page()"
});
formatter.result({
  "status": "skipped"
});
});