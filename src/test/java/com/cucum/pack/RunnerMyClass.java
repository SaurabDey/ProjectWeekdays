package com.cucum.pack;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="FeatureFolder",
		glue="com.selenium.ProjectWeekdays",
		plugin  = {"pretty:STDOUT","html:target/HTMLCucumberReport","json:target/Cucumber.json"}
		//,tags = {"@Smoke"}
		
)
public class RunnerMyClass extends AbstractTestNGCucumberTests{

	@Test
	public void f()
	{}
}
