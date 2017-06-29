package com.test.automation.uiAutomation.homePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class SearchProduct extends TestBase {

	public static final Logger log = Logger.getLogger(SearchProduct.class.getName());
	
	HomePage home;

	@DataProvider(name = "Search")
	public String[][] getTestData() throws IOException

	{

		log.info("Reading the data from the exel file");
		
		String[][] testRecords = getData("TestData.xlsx", "Search");

		
		
		return testRecords;
	}

	@BeforeTest
	public void setUp() throws IOException, InterruptedException

	{

		init();
	}

	@Test(dataProvider = "Search")
	public void searchProduct(String ProductName) throws InterruptedException {

		log.info("ashu");
		
		home = new HomePage(driver);

		home.SearchProduct(ProductName);
		
		
		

	}

	@AfterClass
	public void endTest() {
		
		log.info("Webdriver is going quite");
		driver.quit();
	}

}
