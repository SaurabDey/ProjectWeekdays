package com.selenium.ProjectWeekdays;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StartSeleniumClass {
	WebDriver driver;

	@Test(enabled = false)
	public void windowhand() {

		driver.get("https://www.naukri.com/");
		String parentWindow = driver.getWindowHandle();

		Set<String> allwindows = driver.getWindowHandles();

		for (String win : allwindows) {

			driver.switchTo().window(win);
			System.out.println(driver.getTitle());

			if (!win.equals(parentWindow)) {
				driver.close();
			}

		}

		driver.switchTo().window(parentWindow);

		driver.findElement(By.xpath("//button[text()='Search Walk-in Jobs']")).click();

	}

	@Test(enabled = false)
	public void framehandle() throws InterruptedException {
		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");

		WebElement myframe = driver.findElement(By.xpath("//frame[@name='packageListFrame']"));
		driver.switchTo().frame(myframe);
		driver.findElement(By.xpath("//a[text()='com.thoughtworks.selenium']")).click();

		driver.switchTo().defaultContent();

		Thread.sleep(4000);
		WebElement myframesecond = driver.findElement(By.xpath("//frame[@name='packageFrame']"));
		driver.switchTo().frame(myframesecond);
		driver.findElement(By.xpath("//span[text()='CommandProcessor']")).click();

		driver.switchTo().defaultContent();

	}

	@Test(enabled = false)
	public void alerthandle() throws InterruptedException {
		driver.get("https://court.mah.nic.in/courtweb/index.php");

		WebElement English = driver.findElement(By.xpath("//a[text()='English']"));
		English.click();

		Thread.sleep(2000);

		WebElement first = driver.findElement(By.xpath("//a[text()='Case Status']"));
		WebElement second = driver.findElement(By.xpath("//a[text()='Filing Number']"));

		Actions act = new Actions(driver);
		act.moveToElement(first).pause(Duration.ofSeconds(2)).moveToElement(second).click().build().perform();

		Thread.sleep(2000);
		Alert alt = driver.switchTo().alert();
		alt.accept();

		WebElement selectDis = driver.findElement(By.id("sess_dist_code"));
		Select sel = new Select(selectDis);
		sel.selectByVisibleText("Amravati-अमरावती ");

		Thread.sleep(2000);
		sel.selectByValue("11");

		Thread.sleep(2000);
		sel.selectByIndex(6);
	}

	@Test(enabled = false)
	public void ActionTest2() {
		driver.navigate().to("https://jqueryui.com/droppable/");

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);

		WebElement drag = driver.findElement(By.id("draggable"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement drop = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("droppable")));

		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
	}

	@Test(enabled = false)
	public void Act() {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

		System.out.println(rows.size());

		for (int i = 1; i <= rows.size(); i++) {

			WebElement nameElement = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[4]"));
			System.out.println(nameElement.getText());

			if ("Steven Edwards".equals(nameElement.getText())) {

				WebElement radio = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]"));
				radio.click();

			}

		}

		WebElement delet = driver.findElement(By.id("btnDelete"));
		delet.click();

	}

	@Test(enabled = false)
	public void ActusingTagname() {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		// WebElement table = driver.findElement(By.tagName("table"));
		List<WebElement> rows = driver.findElements(By.tagName("tr"));

		for (int i = 1; i < rows.size(); i++) {

			WebElement nameElement = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[4]"));
			System.out.println(nameElement.getText());

			if ("Steven Edwards".equals(nameElement.getText())) {

				WebElement radio = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]"));
				radio.click();

			}

		}

		WebElement delet = driver.findElement(By.id("btnDelete"));
		delet.click();

	}
@Test
	public void testNgAssert() {

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		SoftAssert soft= new SoftAssert();
		soft.assertEquals(url, "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");

		List<WebElement> rows = driver.findElements(By.tagName("tr"));

		System.out.println(rows.size());
		
		//Assert.assertEquals(rows.size(), 12);
		
		soft.assertAll();
	}

	@BeforeTest
	public void a() {

		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void b() throws InterruptedException {

		Thread.sleep(4000);
		driver.quit();
	}

}
