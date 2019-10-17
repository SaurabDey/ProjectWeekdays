package com.selenium.ProjectWeekdays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement loctorUsername;

	@FindBy(xpath = "//input[@type='password']")
	WebElement loctorPassword;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement loctorloginButn;

	WebDriver driver;

	public LoginClass(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(this.driver, this);
	}

	public void login() {

		// WebElement username=
		// driver.findElement(By.xpath("//span[text()='Enter Email/Mobile
		// number']//preceding::input[1]"));

		loctorUsername.sendKeys("saurab@gmail.com");

		loctorPassword.sendKeys("1234pass");

		loctorloginButn.click();
	}
}
