package com.extentreport;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Driver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsClass {
	public  ExtentReports extent;
	 public  ExtentTest test;

    
    @BeforeTest
    public  void startReport(String Browsername)
    {
    	
    	Path currentRelativePath = Paths.get("");

    	String ExtentReportFolder = currentRelativePath.toAbsolutePath().toString() + File.separator
    			+ "ExtentReport" +"\\" + "test-output" + File.separator;

        extent = new ExtentReports(ExtentReportFolder+Browsername+".html", true);
        extent
        .addSystemInfo("Browser Name", Browsername)
        .addSystemInfo("Host Name", "Waheed's Laptop")
        .addSystemInfo("Environment", "Waheed Ahmed")
        .addSystemInfo("User Name", "Waheed Ahmed");
        
        System.out.println(ExtentReportFolder+Browsername+".html");
        extent.loadConfig(new File(ExtentReportFolder+"\\extent-config.xml"));
    }
    
    @AfterMethod
    public  void getResult(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL, result.getThrowable());
             
        }
        extent.endTest(test);
    }
     
    @AfterTest
    public  void endreport()
    {
        extent.flush();
        
    }
    
}
