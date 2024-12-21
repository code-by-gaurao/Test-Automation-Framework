package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class LoginPage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By EMAIL_TEXT_BOX_LOCATOR =By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR =By.id("passwd");
	private static final By SUBMITLOGIN_BUTTON_LOCATOR=By.xpath("//button[@id=\"SubmitLogin\"]");
	private static final By ERROR_MESSAGE_LOCATOR=By.xpath("//div[@class='alert alert-danger']//li");

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	
    public MyAccountPage doLoginWith(String emailAddress, String password)
	{
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMITLOGIN_BUTTON_LOCATOR);
		
		MyAccountPage myAccountPage=new MyAccountPage(getDriver());
		return myAccountPage;
	}
    
    public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {
    	enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMITLOGIN_BUTTON_LOCATOR);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;
    }
    
    public String getLoginErrorMessage() {
    	logger.info("Getting Error Message For Invalid Credentials");
    	return getVisibleText(ERROR_MESSAGE_LOCATOR);
    }
    
}
