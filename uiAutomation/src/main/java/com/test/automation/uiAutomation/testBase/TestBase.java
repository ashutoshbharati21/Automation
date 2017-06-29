package com.test.automation.uiAutomation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.test.automation.uiAutomation.excelReader.ExcelReader;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;

	ExcelReader excel;

	Properties OR = new Properties();

	public void init() throws IOException, InterruptedException

	{
		LoadData();
		Thread.sleep(5000);
		selectBrowser(OR.getProperty("browser"));
		log.info("selectBrowser method called to select the browser type");
		getUrl(OR.getProperty("URL"));
		log.info("getURL methoed called to navigate to the url");
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		log.info("Log 4j object ia created" + log4jConfPath);

	}

	public void LoadData() throws IOException

	{

		File file = new File(
				System.getProperty("user.dir")
						+ "/src/main/java/com/test/automation/uiAutomation/config/config.properties");

		log.info("Reading the data from config file to load the configuration");

		FileInputStream f = new FileInputStream(file);

		OR.load(f);

		log.info("Data loaded successfully from the confi file" + f);

	}

	public void selectBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "/drivers/chromedriver.exe");

			log.info("Creaeting the object for Browser" + browser);

			driver = new ChromeDriver();

			log.info("Creaeting the object for Browser" + driver);
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			log.info("Creaeting the object for Browser" +browser); 
			
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/drivers/geckodriver.exe");

			log.info("Creaeting the object for Browser" + driver);
			driver = new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("ie")) {

			log.info("Creaeting the object for Browser" +browser); 
			
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "/drivers/IEDriverServer.exe");

			
			driver = new InternetExplorerDriver();

		}
	}

	public void getUrl(String url) throws InterruptedException

	{

		Thread.sleep(5000);
		driver.get(url);
		log.info("Navigating to the url"+url);
		driver.manage().window().maximize();
		log.info("Browser window is getting maximaized");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	public String[][] getData(String ExcelName, String SheetName)
			throws IOException

	{

		String path = System.getProperty("user.dir")
				+ "/src/main/java/com/test/automation/uiAutomation/data/"
				+ ExcelName;

		excel = new ExcelReader(path);

		log.info("Trying to get the excel path to read the data  from excel file");
		String[][] data = excel.getDataFromSheet(ExcelName, SheetName);

		log.info("Successfully read the excel file" + data);

		return data;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}