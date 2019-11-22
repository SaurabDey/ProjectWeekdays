package com.selenium.ProjectWeekdays;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Auto {

	WebDriver driver;

	@Test(dataProvider= "types")
	public void z(String x, int y, boolean z) throws IOException, InterruptedException {

		System.out.println("Values "+x +y );
		Thread.sleep(2000);
		System.out.println("********test prited "+z);
		Thread.sleep(2000);
	}
	
	@BeforeTest
	public void a() {
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public void b() throws InterruptedException {
		driver.quit();
	}	
	@DataProvider(name= "types")
	public Object[][] dpmethod()
	{
		return new Object[][]
			{{"manual",10, true},{"automation",20, false},{"secutiry",30, true},{"performance",40, false}};
	}
}
