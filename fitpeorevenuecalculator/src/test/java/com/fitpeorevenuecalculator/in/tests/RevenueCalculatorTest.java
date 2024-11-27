package com.fitpeorevenuecalculator.in.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fitpeorevenuecalculator.in.Pages.RevenueCalculatorPage;
import com.fitpeorevenuecalculator.in.base.BaseTest;

public class RevenueCalculatorTest extends BaseTest {


	private RevenueCalculatorPage revenueCalculatorPage;


	@BeforeMethod
	public void setup()
	{
		revenueCalculatorPage = new RevenueCalculatorPage(driver);
	}

	@Test(priority = 1)
	public void RevenueCalculator() throws Exception
	{
		
		revenueCalculatorPage .clickRevenueCalculator();	

	}


	@Test(priority = 2)
	public void ToSlider() throws InterruptedException
	{

		revenueCalculatorPage.navigateToSlider();
		Test.log(Status.INFO, "Navigated to slider");


	}


	@Test(priority = 3)
	public void inputFieldEnter() throws Exception
	{

		revenueCalculatorPage.enterInputField();
		Test.log(Status.INFO, "Input field value entered");


	}


	@Test(priority = 4)
	public void CheckBoxesEntry()
	{

		revenueCalculatorPage.checkBoxes();
		Test.log(Status.INFO, "Checkboxes selected");

	}

	@Test(priority = 5)
	public void validating()

	{

		revenueCalculatorPage.validating_Trr();

	}


}
