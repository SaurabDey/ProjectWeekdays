package com.selenium.ProjectWeekdays;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScript {

	@BeforeSuite
	public void bf() {
		System.out.println("before Suite");
	}

	@BeforeTest
	public void bt() {
		System.out.println("--before test");
	}

	@BeforeClass
	public void bc() {
		System.out.println("----before class");
	}

	@Test(priority = 2, groups = "ABCD")
	public void f() {
		System.out.println("--------Test one");
	}

	@Test(priority = 1)
	public void of() {
		System.out.println("--------Test two");
	}

	@Test(priority = 3, groups = "ABCD")
	public void tf() {
		System.out.println("--------Test three");
	}

	@AfterSuite
	public void af() {
		System.out.println("After Suite ");
	}

	@AfterTest
	public void at() {
		System.out.println("--After test ");
	}

	@AfterClass
	public void ac() {
		System.out.println("----After Class ");
	}

}
