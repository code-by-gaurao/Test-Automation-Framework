package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class InvalidCredentialsLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS="xyz@gmaiL.com";
	private static final String INVALID_PASSWORD="pass123";

	@Test(description = "Verify if the proper error message is shown for the user when they enter invalid credentials", groups = { "e2e,Sanity" })
	public void loginTestInvalidCredentials() {

		Assert.assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD)
				.getLoginErrorMessage(),"Authentication failed.");
	}

}
