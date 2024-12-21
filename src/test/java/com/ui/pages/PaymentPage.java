package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility{
	
	private static final By PAYMENT_BY_WIRE_LINK_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");
	private static final By CONFIRM_MY_ORDER_LOCATOR = By.xpath("//button[@class='button btn btn-default button-medium']");
	private static final By ORDER_CONFIRMATION_MESSAGE=By.xpath("//p[contains(@class,'success')]");
	
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String makePaymentByWire() {
		
		clickOn(PAYMENT_BY_WIRE_LINK_LOCATOR);
		clickOn(CONFIRM_MY_ORDER_LOCATOR);
		return getVisibleText(ORDER_CONFIRMATION_MESSAGE);
		
		
	}
	

}
