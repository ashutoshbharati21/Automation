package com.test.automation.uiAutomation.uiActions;

import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RedBusSearch {

	@Test
	public void selectDate() throws InterruptedException

	{

		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "H:\\Selenium_Testing\\Mozila\\geckodriver.exe");
		 * 
		 * // Step 2 - Launch Driver WebDriver driver = new FirefoxDriver();
		 */

		System.setProperty("webdriver.chrome.driver",
				"H:\\Selenium_Testing\\Mozila\\chromedriver.exe");

		// Step 2 - Launch Driver
		WebDriver driver = new ChromeDriver();

		// Step 3 - Launch URL

		driver.get("http://www.redbus.in/");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Pune");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[.='Pune']")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys(
				"Bangalore");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[.='Bangalore']")).click();

		Thread.sleep(1000);

		// =============Select the date===========================

		String selectdate = "06/01/2017";

		Date dt = new Date(selectdate);

		SimpleDateFormat d = new SimpleDateFormat("MMMM/dd/yyyy");

		String date = d.format(dt);

		System.out.println(date);

		String[] sp = date.split("/");

		String m1 = sp[0];

		String d1 = sp[1];

		String m2 = "";

		String d3 = "";

		if (d1.startsWith("0"))

		{
			{

				String[] d2 = d1.split("0");

				d3 = d2[1];
			}
		} else {

			d3 = sp[1];

		}

		if (m1.equalsIgnoreCase("january"))

		{

			m2 = "Jan";

		}

		else if (m1.equalsIgnoreCase("February"))

		{

			m2 = "Fab";

		}

		else if (m1.equalsIgnoreCase("March"))

		{

			m2 = "Mar";

		} else if (m1.equalsIgnoreCase("April"))

		{

			m2 = "Apr";

		} else if (m1.equalsIgnoreCase("May"))

		{

			m2 = "May";

		} else if (m1.equalsIgnoreCase("June"))

		{

			m2 = "Jun";

		} else if (m1.equalsIgnoreCase("July"))

		{

			m2 = "July";

		} else if (m1.equalsIgnoreCase("August"))

		{

			m2 = "Aug";

		} else if (m1.equalsIgnoreCase("September"))

		{

			m2 = "Sept";

		} else if (m1.equalsIgnoreCase("October"))

		{

			m2 = "Oct";

		} else if (m1.equalsIgnoreCase("November"))

		{

			m2 = "Nov";

		} else if (m1.equalsIgnoreCase("December")) {

			m2 = "Dec";

		}

		m2 = m2 + " " + sp[2];

		// System.out.println(m2);
		// =======================End The Date
		// Function=================================

		Thread.sleep(5000);

		while (true)

		{

			try {

				// Thread.sleep(5000);

				driver.findElement(
						By.xpath("//*[@id='rb-calendar_onward_cal']//*[.='"
								+ m2 + "']")).isDisplayed();

				Thread.sleep(1000);

				driver.findElement(
						By.xpath("//*[@id='rb-calendar_onward_cal']//*[.='"
								+ d3 + "']")).click();

				break;
			}

			catch (Exception e)

			{

				driver.findElement(
						By.xpath("//*[@id='rb-calendar_onward_cal']//*[@class='next']"))
						.click();
				Thread.sleep(2000);
			}
		}

		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[.='Search Buses']")).click();

		Thread.sleep(5000);

		// Quit
		driver.quit();
	}
}
