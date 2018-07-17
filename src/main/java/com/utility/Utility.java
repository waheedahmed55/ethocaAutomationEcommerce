package com.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	public static String screenshot(WebDriver driver, String Name) {

		try {
			Date dt = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			String dtStr = df.format(dt);
			Name = Name + "_" + dtStr + ".png";
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\FailedScreenShot\\" + Name;
			FileUtils.copyFile(source, new File(destination));
			System.out.println("ScreenShot Taken");
			return destination;
		} catch (Exception e) {
			System.out.println("Exception while taking ScreenShot " + e.getMessage());
			return Name;
		}
	}

	public static boolean isClickable(By el, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 6);
			wait.until(ExpectedConditions.elementToBeClickable(el));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean IsEditable(By el, WebDriver driver) {

		try {
			if (!driver.findElement(el).isEnabled())
				return false;
			else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

	}

}
