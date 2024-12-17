package com.ui.pages;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;

public class HomePage extends BrowserUtility {

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

	
	
	/*
	 * for Browser as String
	 * public HomePage(String browserName) {
		super(browserName);
		goToWebsite("http://www.automationpractice.pl/index.php?");
	}
*/	
	
	//for Browser as ENUM
	public HomePage(Browser browserName,boolean isHeadless) throws FileNotFoundException {
		super(browserName,isHeadless);
		//goToWebsite("http://www.automationpractice.pl/index.php?");
		//goToWebsite(PropertiesUtil.readProperty(Env.QA , "URL"));
		
		goToWebsite(readProperty(QA ,"URL"));
		
		/*After importing static for Env which has only constant--> import static com.constants.Env.*;
         * Also for PropertiesUtil class which has only static method we can import static 
         * import static com.utility.PropertiesUtil.*;  so we can do without className
         */
		//goToWebsite(JSONUtility.readJSON(QA));   
		
	}

	public HomePage(WebDriver driver ) {
		super(driver);
		goToWebsite(readProperty(QA ,"URL"));
	}

	public LoginPage goToLoginPage() {

		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;
	}

	
}
