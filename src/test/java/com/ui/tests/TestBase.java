package com.ui.tests;

import com.constants.Browser;


import java.io.FileNotFoundException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	

	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Load the HomePage website")
	public void setup( @Optional("chrome") String browser, 
			           @Optional("false")  boolean isLambdaTest, 
			           @Optional("false")   boolean isHeadless, ITestResult result) throws FileNotFoundException {
		
		this.isLambdaTest=isLambdaTest;
		
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			logger.info("Load HomePage of the Website on LambdaTest");
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);

		} else {

			// Running test on Local Machine
			logger.info("Load HomePage of the Website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}

	}

	// we can create ref of homePage Parents i.e BrowserUtility
	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {

		if (isLambdaTest) {
			logger.info("Closing LambdaTest Session");
			LambdaTestUtility.quitSession();  //quit lambdatest session
		} else {
			logger.info("Closing local Machine Session");
			homePage.quitSession(); //quit local machine session
		}
	}

}
