package com.selenium.ProjectWeekdays;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

	static Logger log=Logger.getLogger(NewTest.class);
	
	WebDriver driver;

	@Test
	public void z() {
		log.info("Started login method");
		log.info("End of login method");
	}

	@BeforeTest
	public void a() {
		
		//BasicConfigurator.configure();
		PropertyConfigurator.configure("Resource/log4j.properties");
		log.info("Starting with automation");
		
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();
		log.warn("Opened browser");
		
		driver.get("https://www.flipkart.com/");
		log.error("Opened flipkart");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log.fatal("maximised browser");
	}

	@AfterTest
	public void b() {
		driver.quit();
		log.info("End of execution");
	}
}
