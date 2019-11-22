package com.selenium.ProjectWeekdays;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestAllType {
	public static final String USERNAME = "saurabdey3";
	  public static final String AUTOMATE_KEY = "g4pSxhMbR9S85gQptvtB";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	  @Test
	  public void tes() throws MalformedURLException {

		System.out.println("********************Selenium**********************");
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "62.0");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("name", "Bstack-[Java] Sample Test");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    WebElement element1 = driver.findElement(By.id("txtUsername"));
	    element1.sendKeys("Admin");
	    
	    WebElement element2 = driver.findElement(By.id("txtUsername"));
	    element2.sendKeys("admin123 ");    
	    element2.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
	    System.out.println("********************Rest**********************");
	    Response resp=RestAssured.
				given().
					baseUri("http://dummy.restapiexample.com/api/v1/employees").
					contentType("application/json").
				when().
					get();
			
			String myresponse =resp.getBody().asString();
			int status=resp.statusCode();
			long myTime=resp.getTime();
			
			System.out.println(myresponse);
			System.out.println(status);
			System.out.println(myTime);
			
		System.out.println("********************Database Connection**********************");
			Connection con = null;
			try {
				con = DriverManager.getConnection(
						"jdbc:mysql://sql12.freesqldatabase.com:3306/sql12312815", "sql12312815","3kfmt4VAzZ");

				System.out.println("connected");

				Statement stm = con.createStatement();

				ResultSet rs = stm.executeQuery("select * from customers where customerNumber=112");

				while (rs.next()) {
					String name = rs.getString("customerName");
					int code = rs.getInt("postalCode");
					System.out.println("Name is : " + name);
					System.out.println("Postal code is : " + code);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					con.close();
					System.out.println("connection ended");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("********************End of exection**********************");
	  }
}
