package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;

public class HomePage extends TestBase {

	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
	
	

	String s = "";
	@FindBy(xpath = "//*[@id='main-nav']/form/fieldset/input[1]")
	WebElement box;
	

	@FindBy(xpath = "//*[@id='main-nav']/form/fieldset/input[1]")
	WebElement search;

	// Product Name
	/*
	 * @FindBy(xpath= "//a[.='+"ProductName"+']") WebElement name;
	 */
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		
		log.info("All web elements are intislised successfully");

	}

	public void SearchProduct(String ProductName) throws InterruptedException

	{
		Thread.sleep(1000);

		box.sendKeys(ProductName);

		log.info("Product Name successfully Entered");
		
		box.sendKeys(Keys.ENTER);

		log.info("Product Name successfully searched");
		
		Thread.sleep(2000);
	}

	/*
	 * public void productDetailVerification(String ProductName)
	 * 
	 * {
	 * 
	 * name.getText(); if(name.toString().equals(ProductName))
	 * 
	 * {
	 */

}
