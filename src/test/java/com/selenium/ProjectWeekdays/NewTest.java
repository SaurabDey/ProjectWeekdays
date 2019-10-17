package com.selenium.ProjectWeekdays;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test(dependsOnMethods="c")
  public void a() {
	  System.out.println("a");
  }
  
  @Test()
  public void b() {
	  System.out.println("b");
  }
  
  @Test()
  public void c() {
	  System.out.println(100/0);
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Bt");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("At");
  }

}
