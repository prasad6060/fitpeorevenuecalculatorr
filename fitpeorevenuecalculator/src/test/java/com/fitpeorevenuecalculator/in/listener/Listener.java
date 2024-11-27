package com.fitpeorevenuecalculator.in.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.fitpeorevenuecalculator.in.base.BaseTest;
import com.fitpeorevenuecalculator.in.utilities.ScreenshotUtility;

public class Listener extends BaseTest implements ITestListener
{
	ScreenshotUtility screenshotutility;

	@Override
	public  void onTestFailure(ITestResult result) {


		try
		{

			String fileName = result.getTestContext().getName() + "--" + result.getMethod().getMethodName() + ".jpg";
			ScreenshotUtility.captureScreenshot( fileName);


			String path=ScreenshotUtility.captureScreenshot(fileName);

			Test = extentReports.createTest("Screenshot Test1", "Screenshot saved here")
					.log(Status.FAIL, "This is failed")
					.assignAuthor("Prasad")
					.assignCategory("smoke")
					.assignDevice("lenovo")
					.addScreenCaptureFromPath(path);



		}
		catch(Exception e)

		{
			System.out.println("Error capturing screenshot: " + e.getMessage());	
		}
	}



	@Override
	public void onTestSuccess(ITestResult result) {


		String fileName = result.getTestContext().getName() + "--" + result.getMethod().getMethodName() + ".jpg";
		ScreenshotUtility.captureScreenshot( fileName);
		String path= ScreenshotUtility.captureScreenshot(fileName);



		Test = extentReports.createTest("Screenshot Test2", "Screenshot saved here")
				.log(Status.PASS, "This is passed")
				.assignAuthor("prasadv")
				.assignCategory("smoke")
				.assignDevice("lenovo")
				.addScreenCaptureFromPath(path);


	}

	@Override
	public void onTestSkipped(ITestResult result) {


		Test=extentReports.createTest("this is for screenshot3","screen shot saved here")
				.log(Status.SKIP,"this is skipped")
				.assignAuthor("dp")
				.assignCategory("regression")
				.assignDevice("dell");



	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started: " + result.getTestContext().getName() + "--" + result.getMethod().getMethodName());
	}





}



