package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListener.class)
public class SearchProductTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM="Printed Summer Dress";
	// private static final String SEARCH_TERM="Mens Wallet";
	
	@BeforeMethod(description="Valid user logs into the application")
	public void setup() {
		
		myAccountPage=homePage.goToLoginPage().doLoginWith("mevafib129@jonespal.com", "Password");
		
	}
	
	
	@Test(description="Verify if logged user is able to search for a product and correct products", 
			            groups= {"e2e","smoke","sanity"})
	public void verifyProductSearchTest() {
		
		boolean actualResult=myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		
		assertEquals(actualResult, true);
		
	}

}
