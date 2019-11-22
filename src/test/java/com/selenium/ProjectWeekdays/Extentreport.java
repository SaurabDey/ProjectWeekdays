package com.selenium.ProjectWeekdays;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreport {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void a() {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Saurabextent.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.setAppendExisting(true);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		 test = extent.createTest("MyFirst Extent report test");
		test.pass("Saurab started report");

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();
		test.info("Opened the browser");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test.info("Max the browser");

		driver.get("https://court.mah.nic.in/courtweb/index.php");
		test.info("Opened the  required site");
	}

	@AfterTest
	public void b() throws InterruptedException {

		driver.quit();
		extent.flush();
	}

	@Test()
	public void alerthandle() throws InterruptedException, IOException {
		try {
			WebElement English = driver.findElement(By.xpath("//a[text()='English']"));
			English.click();

			test.pass("Clicked on english");
	
		} catch (Exception e) {
			test.fail("not able to Click on english");
			
			MediaEntityModelProvider mediaModel = 
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("first")).build();
			test.fail("Changed the language to English", mediaModel);
		}

		Thread.sleep(2000);

		try {
			WebElement first = driver.findElement(By.xpath("//a[text()='Case Status']"));
			WebElement second = driver.findElement(By.xpath("//a[text()='Filing Number']"));
			
			Actions act = new Actions(driver);
			act.moveToElement(first).pause(Duration.ofSeconds(2)).moveToElement(second).click().build().perform();
			test.pass("Moved to Filing Number");
			
		
		} catch (Exception e) {
			test.fail("not able to move to Filing Number");

			MediaEntityModelProvider mediaModel = 
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("second")).build();
			test.fail("Changed the Filing Number", mediaModel);	
		}
		
		Thread.sleep(3000);
		Alert alt = driver.switchTo().alert();
		alt.accept();

		WebElement selectDis = driver.findElement(By.id("sess_dist_code"));
		Select sel = new Select(selectDis);
		sel.selectByVisibleText("Amravati-अमरावती ");

	}
	
	public String takeScreenshot(String name)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String dest = "Resource/SeleniumScreenshot"+name+".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dest;
	}
}
