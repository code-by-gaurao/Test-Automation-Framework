package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestDetails {

	public static void main(String[] args) {
		
		WebDriver wd=new ChromeDriver(); 
		wd.get("http://www.automationpractice.pl/index.php?");
		wd.manage().window().maximize();
		
		By signInLinkLocator=By.xpath("//a[@title=\"Log in to your customer account\"]");
		WebElement signInLinkWebElement=wd.findElement(signInLinkLocator); //Find the element
		signInLinkWebElement.click();
		
		By emailTextBoxLocator =By.id("email");
		WebElement emailTextBoxWebElement=wd.findElement(emailTextBoxLocator);
		emailTextBoxWebElement.sendKeys("mevafib129@jonespal.com");

		By passwordTextBoxLocator =By.id("passwd");
		WebElement passwordextBoxWebElement=wd.findElement(passwordTextBoxLocator);
		passwordextBoxWebElement.sendKeys("Password");
		
		By submitLoginButtonLocator=By.xpath("//button[@id=\"SubmitLogin\"]");
		WebElement submitLoginButtoWebElement=wd.findElement(submitLoginButtonLocator); //Find the element
		submitLoginButtoWebElement.click();
		
		
	}

}

/*Bad Practices In this Code
 * 
 * 1. Hard Coding
 * 2.Duplicasy
 * 3.TestData is attached to Script
 * 4.Naming conventions
 * 5.Exception Handling is not there 
 * 6.Synchronization is not there
 * 7. Assertions
 * 8. Abstractions
 * 9. You are not suppose to used any Selenium methods directly in the Script
 * 
 * */
