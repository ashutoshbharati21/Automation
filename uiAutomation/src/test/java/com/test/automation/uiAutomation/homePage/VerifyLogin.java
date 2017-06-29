package com.test.automation.uiAutomation.homePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class VerifyLogin extends TestBase {

	public static final Logger log = Logger.getLogger(VerifyLogin.class
			.getName());

	// String testRecords;

	HomePage home;

	@DataProvider(name = "Search")
	public String[][] getTestData() throws IOException

	{

		String[][] testRecords = getData("TestData.xlsx", "Search");

		return testRecords;
	}

	@BeforeTest
	public void setUp() throws IOException, InterruptedException

	{

		init();
	}

	@Test(dataProvider = "Search")
	public void verifyLogin(String testRecords) throws InterruptedException {

		log.info("================verifyLogin method started to verify the test===============");

		home = new HomePage(driver);

		home.SearchProduct(testRecords);

		log.info("================verifyLogin method End to verify the test===============");

	}

	@AfterClass
	public void endTest() {

		driver.quit();
		log.info("Browser closed successfully");
	}

}
