package com.selenium.ProjectWeekdays;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Hello world!
 *
 */
public class AppGrid {
	public static void main(String[] args) throws MalformedURLException {
		AppGrid ref = new AppGrid();
		ref.setup();

		LoginClass log = new LoginClass(ref.driver);
		log.login();

		ref.teardown();

	}

	WebDriver driver;

	public void setup() throws MalformedURLException {
		/*System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();*/
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("internet explorer");
		
		driver  = new RemoteWebDriver(new URL("http://192.168.0.2:4444/wd/hub"), capabilities);
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void teardown() {

		driver.quit();
	}
}
