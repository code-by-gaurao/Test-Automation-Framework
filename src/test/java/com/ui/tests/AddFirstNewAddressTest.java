package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddFirstNewAddressTest extends TestBase {

	private MyAccountPage myAccountPage;

	private AddressPOJO address;

	@BeforeMethod(description = "Valid First Time  user logs into the application")
	public void setup() {

		myAccountPage = homePage.goToLoginPage().doLoginWith("mevafib19@jonespal.com", "Password");
		address = FakeAddressUtility.getFakeAddress();
	}

	@Test(description = "User is landing on Address Page")
	public void addNewAddress() {

		String newAddress = myAccountPage.goToAddAddresPage().saveAddress(address);
		assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}
}