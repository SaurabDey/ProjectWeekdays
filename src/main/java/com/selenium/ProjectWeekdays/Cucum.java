package com.selenium.ProjectWeekdays;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cucum {
	WebDriver driver;
	@Given("^the site is up and running$")
	public void the_site_is_up_and_running() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("^I provide correct credentials (\\w+) and (\\w+)$")
	public void i_provide_correct_credentials(String us, String pas) throws Throwable {
	   
		WebElement user=driver.findElement(By.id("txtUsername"));
		user.sendKeys(us);

		WebElement pass=driver.findElement(By.id("txtPassword"));
		pass.sendKeys(pas);

		WebElement log=driver.findElement(By.id("btnLogin"));
		log.click();
	}

	@Then("^I validate I an logged in$")
	public void i_validate_I_an_logged_in() throws Throwable {
	   
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}

	@When("^I provide incorrect credentials (\\w+) and (\\w+)$")
	public void i_provide_incorrect_credentials(String x, String y) throws Throwable {
		WebElement user=driver.findElement(By.id("txtUsername"));
		user.sendKeys(x);

		WebElement pass=driver.findElement(By.id("txtPassword"));
		pass.sendKeys(y);

		WebElement log=driver.findElement(By.id("btnLogin"));
		log.click();
	}
	
	@Then("^I validate I shouldnot get logged in$")
	public void myval()
	{
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		
	}

	@After
	public void myquit()
	{
		driver.quit();
	}
}
