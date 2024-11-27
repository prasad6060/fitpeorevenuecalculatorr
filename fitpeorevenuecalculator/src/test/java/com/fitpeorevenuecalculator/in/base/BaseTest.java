package com.fitpeorevenuecalculator.in.base;

import java.awt.Desktop;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fitpeorevenuecalculator.in.config.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	
    public static ExtentReports extentReports;
	
	public static  ExtentTest Test;
	public static Constants constants;
	
	
     @BeforeClass
	public void initializeDriver() throws Exception
	{
    	    WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(Constants.REVENUE_CALCULATOR_URL); 
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
          	
		
	}
     
     
     @AfterClass
     public void teardown()
     {
    	 driver.quit();
     }
     
     
     

 	@BeforeSuite
 	public void intialiseExtentReports( )
 	
 	{
 		
 		ExtentSparkReporter sparkReporter_all=new ExtentSparkReporter("alltests.html");
 		
 		sparkReporter_all.config().setReportName("all test  report");

 		
 		
 		ExtentSparkReporter sparkReporter_fail=  new ExtentSparkReporter("failedTests.html");
 		
 		sparkReporter_fail.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
 		
 		sparkReporter_fail.config().setReportName("failure report");
 		
 		
 		extentReports=new ExtentReports();

 		extentReports.attachReporter(sparkReporter_all,sparkReporter_fail);
 		
 		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
 		extentReports.setSystemInfo("JAVA VERSION", System.getProperty("java.version"));
 		
 		
 		extentReports.setSystemInfo("Browser", "Chrome");
 		extentReports.setSystemInfo("Environment", "QA");
 		
 		
 	}	

	@AfterSuite
	public void generateExtentReports() throws Exception
	
	{
		extentReports.flush();
		Desktop.getDesktop().browse(new File("alltests.html").toURI());
		Desktop.getDesktop().browse(new File("failedTests.html").toURI());
	}
	
	
 	


}
