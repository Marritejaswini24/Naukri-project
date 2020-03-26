package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src\\main\\resources\\features\\testcase.feature",
plugin = {"pretty", "html:reports/cucumber-html-report","json:reports/cucumber-html-report/jsonreport","com.cucumber.listener.ExtentCucumberFormatter:reports/Extentreports/Extentreport.html"},	
tags = {"@tc01_login,@tc02_search,@tc03_more,@tc04_filter"},
glue = {"com.stepdefiniton"},
monochrome = true
)
public class runner {
	@AfterClass	 
	public static void extendReport()	{	
		Reporter.loadXMLConfig("src\\test\\resources\\extend-config.xml");	
		Reporter.setSystemInfo("user", System.getProperty("user.name"));	
		Reporter.setSystemInfo("os", "Windows");	
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}
}
