package com.fitpeorevenuecalculator.in.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.fitpeorevenuecalculator.in.config.Constants;



public class RevenueCalculatorPage {


	WebDriver driver;
	Constants constants;


	private JavascriptExecutor jsexecutor;
	public RevenueCalculatorPage(WebDriver driver)
	{


		this.driver=driver;
		this.jsexecutor = (JavascriptExecutor) driver;
		PageFactory.initElements(driver,this);
	}
	


	@FindBy(xpath = "//div[normalize-space(text())='Revenue Calculator'] ")
	WebElement revenueCalculator;



	@FindBy(xpath = "//span[contains(@class,'MuiSlider-thumb MuiSlider-thumbSizeMedium')]  ")
	WebElement slider;

	@FindBy(xpath = " //input[@type='number'] ")
	WebElement inputField;

	@FindBy(xpath = "(//input[@type='checkbox'])[1] ")
	WebElement checkbox1;

	@FindBy(xpath = "(//input[@type='checkbox'])[2] ")
	WebElement checkbox2;

	@FindBy(xpath = "(//input[@type='checkbox'])[3] ")
	WebElement checkbox3;

	@FindBy(xpath = " (//label[contains(.,'11.51')]/following::input)[1] ")
	WebElement checkbox4;

	@FindBy(xpath = " //p[contains(text(),'Total Recurring Reimbursement for all Patients Per')] ")
	WebElement validate;


	public void clickRevenueCalculator() throws Exception
	{

		revenueCalculator.click();

         Thread.sleep(3000);
		

	}

	public void navigateToSlider()
	{

		jsexecutor.executeScript("window.scrollTo(0,500)");
		
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		int currentValue = Constants.CURRENT_VALUE;
		int targetValue = Constants.SLIDER_VALUE;
		int steps = (targetValue - currentValue)/10;

		for (int i = 0; i < steps; i++) {

			slider.sendKeys(Keys.chord(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT));


		}}

	public void enterInputField()
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(inputField));

		inputField.sendKeys(Keys.CONTROL+"A");
		inputField.sendKeys(Keys.DELETE);
		inputField.sendKeys(Constants.INPUT_FIELD_VALUE);

		jsexecutor.executeScript("window.scrollBy(0,500)");


	}
	public void checkBoxes()
	{

		checkbox1.click();
		checkbox2.click();
		checkbox3.click();

		jsexecutor.executeScript("window.scrollBy(0,500)");

		checkbox4.click();
	}
	public void validating_Trr()
	{

		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement reimbursementText = wait.until(ExpectedConditions.visibilityOf(validate));
		Assert.assertTrue(reimbursementText.getText().contains("$75600"));
	}


}