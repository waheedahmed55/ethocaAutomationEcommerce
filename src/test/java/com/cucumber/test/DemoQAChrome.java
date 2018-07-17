package com.cucumber.test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.datadriven.Constant;
import com.datadriven.ExcelUtils;
import com.extentreport.ExtentReportsClass;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.Utility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoQAChrome {
	boolean IsclickableElement;
	WebDriver driver;
	String destination;
	int i = 0;
	ExtentReportsClass ExtentReportsClass = new ExtentReportsClass();

	@Test(priority = 0)
	@Given("^chrome only validation$")
	public void chrome_only_validation() throws Throwable {
		try {
			System.out.println("Chrome Browser Environmnet Created");
			System.out.println("________________________________________");
			Path currentRelativePath = Paths.get("");
			String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "DriverEXE"
					+ File.separator;
			System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");

			Map<String, Object> pref = new HashMap<String, Object>();
			pref.put("credentials_enable_service", false);
			pref.put("profile.password_manager_enabled", false);
			pref.put("profile.default_content_setting_values.notifications", 2);
			options.setExperimentalOption("prefs", pref);

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			ExtentReportsClass.startReport("ChromeTestCase");
			ExtentReportsClass.test = ExtentReportsClass.extent
					.startTest("Verify the checkout process for DemoQA website");
			ExtentReportsClass.test.log(LogStatus.PASS, "Verify the checkout process for DemoQA website");
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			destination = Utility.screenshot(driver, "Chrome Step 1");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 1)
	@Given("^Go to http://store\\.demoqa\\.com/$")
	public void go_to_http_store_demoqa_com() throws Throwable {
		try {
			driver.get(Constant.URL);
			System.out.println("Url is valid : " + driver.getTitle());
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			ExtentReportsClass.test = ExtentReportsClass.extent
					.startTest("It is sucessfully launch http://store.demoqa.com/.");
			ExtentReportsClass.test.log(LogStatus.PASS, "The title of the website is : " + driver.getCurrentUrl());
		} catch (Exception e) {
			destination = Utility.screenshot(driver, "Chrome Step 2");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 2)
	@When("^Go to Product category and select Accessories$")
	public void go_to_Product_category_and_select_Accessories() throws Throwable {

		try {
			WebElement element = driver.findElement(By.linkText("Product Category"));
			IsclickableElement = Utility.isClickable(By.linkText("Product Category"), driver);
			System.out.println("Product Category Link is clickale : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Product Category Link is clickable : " + IsclickableElement);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			driver.findElement(By.linkText("Accessories")).click();
			System.out.println("Accessories Link is clickale : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Accessories is clickable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.PASS, "Sucessfully clicked on Accessories link");

		} catch (Exception e) {
			destination = Utility.screenshot(driver, "Chrome Step 3");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 3)
	@Then("^Click on Add to Cart for just Magic Mouse$")
	public void click_on_Add_to_Cart_for_just_Magic_Mouse() throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.name("Buy")));
			driver.findElement(By.name("Buy")).click();
			IsclickableElement = Utility.isClickable(By.name("Buy"), driver);
			System.out.println("Add to cart Button is clickale : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Add to cart button is clickable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.PASS, "Sucessfully clicked on Add To Cart button");
		} catch (Exception e) {
			destination = Utility.screenshot(driver, "Chrome Step 4");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}

	}

	@Test(priority = 4)
	@Parameters("arg1")
	@Then("^Click on Checkout and confirm you have (\\d+) Magic Mouse in your Check-Out Page$")
	public void click_on_Checkout_and_confirm_you_have_Magic_Mouse_in_your_Check_Out_Page(int arg1) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='header_cart']/a")));
			driver.findElement(By.xpath(".//*[@id='header_cart']/a")).click();
			IsclickableElement = Utility.isClickable(By.xpath(".//*[@id='header_cart']/a"), driver);
			System.out.println("Checkout Link is clickale : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Checkout link is clickable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.PASS, "Sucessfully clicked on Checkout link");
		} catch (Exception e) {
			destination = Utility.screenshot(driver, "Chrome Step 5");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 5)
	@Then("^After confirming, click on Continue$")
	public void after_confirming_click_on_Continue() throws Throwable {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(".//*[@id='checkout_page_container']/div[1]/a/span")));
			driver.findElement(By.xpath(".//*[@id='checkout_page_container']/div[1]/a/span")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			IsclickableElement = Utility.isClickable(By.xpath(".//*[@id='checkout_page_container']/div[1]/a/span"), driver);
			System.out.println("Continue button is clickale : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Continue button button is clickable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.PASS, "Sucessfully clicked on Continue button");
		} catch (Exception e) {
			destination = Utility.screenshot(driver, "Chrome Step 6");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 6)
	@Then("^Enter test data needed for email, billing or contact details and click Purchase$")
	public void enter_test_data_needed_for_email_billing_or_contact_details_and_click_Purchase() throws Throwable {
		try {
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
			String Firstname = ExcelUtils.getCellData(1, 1);
			String Lastname = ExcelUtils.getCellData(1, 2);
			String Address = ExcelUtils.getCellData(1, 3);
			String City = ExcelUtils.getCellData(1, 4);
			String Country = ExcelUtils.getCellData(1, 5);
			String Phone = ExcelUtils.getCellData(1, 6);
			String Email = ExcelUtils.getCellData(1, 7);

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("wpsc_checkout_form_2")));
			IsclickableElement = Utility.IsEditable(By.id("wpsc_checkout_form_2"), driver);
			System.out.println("First Name is editable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "First Name is editable : " + IsclickableElement);
			driver.findElement(By.id("wpsc_checkout_form_2")).clear();
			driver.findElement(By.id("wpsc_checkout_form_2")).sendKeys(Firstname);
			
			IsclickableElement = Utility.IsEditable(By.id("wpsc_checkout_form_3"), driver);
			System.out.println("Last Name is editable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Last Name is editable : " + IsclickableElement);
			
			driver.findElement(By.id("wpsc_checkout_form_3")).clear();
			driver.findElement(By.id("wpsc_checkout_form_3")).sendKeys(Lastname);
			
			IsclickableElement = Utility.IsEditable(By.id("wpsc_checkout_form_4"), driver);
			System.out.println("Address is editable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Address is editable : " + IsclickableElement);
			
			driver.findElement(By.id("wpsc_checkout_form_4")).clear();
			driver.findElement(By.id("wpsc_checkout_form_4")).sendKeys(Address);
			
			IsclickableElement = Utility.IsEditable(By.id("wpsc_checkout_form_5"), driver);
			System.out.println("City is editable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "City is editable : " + IsclickableElement);
			
			driver.findElement(By.id("wpsc_checkout_form_5")).clear();
			driver.findElement(By.id("wpsc_checkout_form_5")).sendKeys(City);
			
			IsclickableElement = Utility.IsEditable(By.id("wpsc_checkout_form_6"), driver);
			System.out.println("Country is editable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Country is editable : " + IsclickableElement);
			
			driver.findElement(By.id("wpsc_checkout_form_6")).clear();
			driver.findElement(By.id("wpsc_checkout_form_6")).sendKeys(Country);
			
			new Select(driver.findElement(By.id("wpsc_checkout_form_7"))).selectByVisibleText(Country);
			
			IsclickableElement = Utility.IsEditable(By.id("wpsc_checkout_form_18"), driver);
			System.out.println("Phone is editable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Phone is editable : " + IsclickableElement);
			
			
			driver.findElement(By.id("wpsc_checkout_form_18")).clear();
			driver.findElement(By.id("wpsc_checkout_form_18")).sendKeys(Phone);
			
			IsclickableElement = Utility.IsEditable(By.id("wpsc_checkout_form_9"), driver);
			System.out.println("Email is editable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Email is editable : " + IsclickableElement);
			
			
			driver.findElement(By.id("wpsc_checkout_form_9")).clear();
			driver.findElement(By.id("wpsc_checkout_form_9")).sendKeys(Email);
			
			driver.findElement(By.cssSelector("tr.same_as_shipping_row > td > label")).click();

			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span > input[name=\"submit\"]")));

			IsclickableElement = Utility.isClickable(By.cssSelector("span > input[name=\"submit\"]"), driver);
			System.out.println("Purchase Button is Clickable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Purchase Button is Clickable : " + IsclickableElement);
			
			
			driver.findElement(By.cssSelector("span > input[name=\"submit\"]")).click();

			ExtentReportsClass.test.log(LogStatus.PASS, "Test data added successfully.");
		} catch (Exception e) {
			destination = Utility.screenshot(driver, "Chrome Step 7");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 7)
	@Then("^Confirm that you have placed the Order in Transaction Results page$")
	public void confirm_that_you_have_placed_the_Order_in_Transaction_Results_page() throws Throwable {
		try {
			// assertEquals("Total Shipping: $10.00\n Total: $160.00",
			// driver.findElement(By.xpath("//article[@id='post-30']/div/div[2]/p[3]")).getText());
			ExtentReportsClass.endreport();
			driver.quit();
		} catch (Exception e) {
			Utility.screenshot(driver, "Chrome Step 8");
			throw e;
		}
	}

}
