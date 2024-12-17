package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTestold {

	public static void main(String[] args) {
		
		WebDriver wd=new ChromeDriver(); 
		
		//HomePage homePage=new HomePage(wd);
		//homePage.goToLoginPage();--->goToLoginPage() return reference of LoginPage so 
		
		//LoginPage loginPage=homePage.goToLoginPage();
		//loginPage.doLoginWith("mevafib129@jonespal.com", "Password");

	}

}
