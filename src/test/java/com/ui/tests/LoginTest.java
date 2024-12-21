package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.*;

import java.io.FileNotFoundException;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;


@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase{

	Logger logger = LoggerUtility.getLogger(this.getClass());

	

	@Test(description = "Varifies with the valid user is able to login into the application", groups = { "e2e,Sanity" })
	public void loginTest() {

		// String userName =
		// homePage.goToLoginPage().doLoginWith("mevafib129@jonespal.com",
		// "Password").getUserName();
		// Assert.assertEquals(userName, "Gaurao Kharate");

		Assert.assertEquals(homePage.goToLoginPage().doLoginWith("mevafib129@jonespal.com", "Password").getUserName(),
				"Gaurao Kharate");
	}
	
	/*	
//FOR JSON DATA
	@Test(description = "Varifies with the valid user is able to login into the application", groups = {
			"e2e,Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestJSONDataProvider")
	public void loginJSONTest(User user) {

		Assert.assertEquals(
				homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Gaurao Kharate");
	}
	
//FOR JSON DATA

	@Test(description = "Varifies with the valid user is able to login into the application", groups = {
			"e2e,Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {

		Assert.assertEquals(
				homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Gaurao Kharate");
	}

	//FOR Excel DATA  //Rerunning failed TCs

		@Test(description = "Varifies with the valid user is able to login into the application", groups = {
				"e2e,Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider",
						retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
		public void loginExcelTest(User user) {

			Assert.assertEquals(
					homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
					"Gaurao Kharate");
		}
*/
}
