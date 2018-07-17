package com.cucumber.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.datadriven.Constant;
import com.datadriven.ExcelUtils;
import com.extentreport.ExtentReportsClass;
import com.pom.DemoQaController;
import com.pom.LoginController;
import com.pom.SearchingController;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.Utility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoQAFireFox {
	WebDriver driver;
	String destination;
	boolean IsclickableElement;
	int i = 0;

	ExtentReportsClass ExtentReportsClass = new ExtentReportsClass();

	@Test(priority = 0)
	@Given("^Firefox browser only validation$")
	public void firefox_browser_only_validation() throws Throwable {
		try {
			System.out.println("Firefox Browser Environmnet Created");
			System.out.println("________________________________________");
			Path currentRelativePath = Paths.get("");
			String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "DriverEXE"
					+ File.separator;
			System.setProperty("webdriver.gecko.driver", pathToDriver + "geckodriver.exe");
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability("marionette", false);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			ExtentReportsClass.startReport("FirefoxTestCase");
			ExtentReportsClass.test = ExtentReportsClass.extent
					.startTest("Verify Ebay add to Cart & checkout functionality on Firefox Browser");
			ExtentReportsClass.test.log(LogStatus.PASS,
					"Verify Ebay add to Cart & checkout functionality on Firefox Browser");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			destination = Utility.screenshot(driver, "Firefox Step 1");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 1)
	@Given("^Navigate to http://store\\.demoqa\\.com/$")
	public void navigate_to_http_store_demoqa_com() throws Throwable {

		try {
			driver.get(Constant.URL);
			System.out.println("Url is valid : " + driver.getTitle());
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			ExtentReportsClass.test = ExtentReportsClass.extent
					.startTest("It is sucessfully launch http://store.demoqa.com/.");
			ExtentReportsClass.test.log(LogStatus.PASS, "The title of the website is : " + driver.getCurrentUrl());
		} catch (Exception e) {
			destination = Utility.screenshot(driver, "Firefox Step 2");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 2)
	@When("^Navigate to Product category and select Accessories$")
	public void navigate_to_Product_category_and_select_Accessories() throws Throwable {
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
			destination = Utility.screenshot(driver, "Firefox Step 3");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 3)
	@Then("^Click on Add to Cart button for just Magic Mouse$")
	public void click_on_Add_to_Cart_button_for_just_Magic_Mouse() throws Throwable {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.name("Buy")));
			driver.findElement(By.name("Buy")).click();
			IsclickableElement = Utility.isClickable(By.name("Buy"), driver);
			System.out.println("Add to cart Button is clickale : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Add to cart button is clickable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.PASS, "Sucessfully clicked on Add To Cart button");

			ExtentReportsClass.test.log(LogStatus.PASS, "Sucessfully clicked on Add To Cart button");
		} catch (Exception e) {
			destination = Utility.screenshot(driver, "Firefox Step 4");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 4)
	@Parameters("arg1")
	@Then("^Click on Checkout link and confirm you have (\\d+) Magic Mouse in your Check-Out Page$")
	public void click_on_Checkout_link_and_confirm_you_have_Magic_Mouse_in_your_Check_Out_Page(int arg1)
			throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='header_cart']/a")));
			driver.findElement(By.xpath(".//*[@id='header_cart']/a")).click();
			IsclickableElement = Utility.isClickable(By.xpath(".//*[@id='header_cart']/a"), driver);
			System.out.println("Checkout Link is clickale : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Checkout link is clickable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.PASS, "Sucessfully clicked on Checkout link");

		} catch (Exception e) {
			destination = Utility.screenshot(driver, "Firefox Step 5");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 5)
	@Then("^After confirming, click on Continue button$")
	public void after_confirming_click_on_Continue_button() throws Throwable {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",
					driver.findElement(By.xpath(".//*[@id='checkout_page_container']/div[1]/a/span")));
			IsclickableElement = Utility.isClickable(By.xpath(".//*[@id='checkout_page_container']/div[1]/a/span"),
					driver);
			System.out.println("Continue button is clickale : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.INFO, "Continue button button is clickable : " + IsclickableElement);
			ExtentReportsClass.test.log(LogStatus.PASS, "Sucessfully clicked on Continue button");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			destination = Utility.screenshot(driver, "Firefox Step 6");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 6)
	@Then("^Enter dummy data needed for email, billing or contact details and click Purchase$")
	public void enter_dummy_data_needed_for_email_billing_or_contact_details_and_click_Purchase() throws Throwable {
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
		} catch (Exception e) {
			destination = Utility.screenshot(driver, "Firefox Step 7");
			ExtentReportsClass.test.log(LogStatus.FAIL, e);
			ExtentReportsClass.test.log(LogStatus.FAIL, ExtentReportsClass.test.addScreenCapture(destination));
			throw e;
		}
	}

	@Test(priority = 7)
	@Then("^Confirm that you have placed the Order in Transaction Result page$")
	public void confirm_that_you_have_placed_the_Order_in_Transaction_Result_page() throws Throwable {
		try {
			// assertEquals("Total Shipping: $10.00\n Total: $160.00",
			// driver.findElement(By.xpath("//article[@id='post-30']/div/div[2]/p[3]")).getText());
			ExtentReportsClass.test.log(LogStatus.PASS, "Plac order verification successfully");
			ExtentReportsClass.endreport();
			driver.quit();
		} catch (Exception e) {
			Utility.screenshot(driver, "Firefox Step 8");
			throw e;
		}
	}
}
