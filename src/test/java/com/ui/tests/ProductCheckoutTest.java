package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.constants.Size;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private SearchResultPage searchResultPage;

	private static final String SEARCH_TERM = "Printed Summer Dress";

	@BeforeMethod(description = "Valid user logs into the application and Searches for a product")
	public void setup() {

		searchResultPage = homePage.goToLoginPage().doLoginWith("mevafib129@jonespal.com", "Password")
				.searchForProduct(SEARCH_TERM);

	}

	
	@Test(description = "Verify if the logged in User is able to buy a dress",groups= {"e2e","smoke","sanity"})
	public void checkOutTest() {
		String result=searchResultPage.clickOnTheProductAt(0).chnageSize(Size.L).addProductToCart().proceedToCheckout()
		.goToConfirmAddressPage().goToShippingPage().goToPaymentPage().makePaymentByWire();
		
		assertEquals(result, "Your order on My Shop is complete.");
	}
}
