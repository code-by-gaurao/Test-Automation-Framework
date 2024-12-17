package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	//ThreadSafe for SS
	private ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);     //initialize the instance variable driver!!
	}
	
	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}
		else System.err.print("Invalid Browser Name");
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for " +browserName);
		if (browserName == Browser.CHROME) {
			
			driver.set(new ChromeDriver());
		}
		else if (browserName == Browser.EDGE) {
			
			driver.set(new EdgeDriver());
		}
		else System.err.print("Invalid Browser Name");
	}
	
	public BrowserUtility(Browser browserName,boolean isHeadless) {
		logger.info("Launching Browser for " +browserName);
		
		if (browserName == Browser.CHROME) {
			if(isHeadless) {
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			}
			else {
				driver.set(new ChromeDriver());
			}
		}
		else if (browserName == Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options=new EdgeOptions()
;				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new EdgeDriver(options));
			}
			else {
				driver.set(new EdgeDriver());
			}
		}
			
		
		
		else System.err.print("Invalid Browser Name");
	}
	
	
	public void goToWebsite(String url) {
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		WebElement element=driver.get().findElement(locator); //Find the element
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		WebElement element=driver.get().findElement(locator); //Find the element
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		WebElement element=driver.get().findElement(locator);
		return element.getText();
	}
	
	public void quitSession() {
		driver.get().quit();	
	}

	public String takeScreenShot(String name) {
		
		TakesScreenshot screenshot=(TakesScreenshot)driver.get();
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		
		
		//File destFile=new File(System.getProperty("user.dir")+"//Screenshots//"+name);
		String path=System.getProperty("user.dir")+"//Screenshots//"+name+" - "+timeStamp+".png";
		File destFile=new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
	}


}




























//BEFORE MAKING DRIVER AS ThreadSAFE
/*
 * public abstract class BrowserUtility {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;      //initialize the instance variable driver!!
	}
	
	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else System.err.print("Invalid Browser Name");
	}
	
	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver=new ChromeDriver();
		}
		else if (browserName == Browser.EDGE) {
			
			driver=new EdgeDriver();
		}
		else System.err.print("Invalid Browser Name");
	}
	
	
	public void goToWebsite(String url) {
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		WebElement element=driver.findElement(locator); //Find the element
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		WebElement element=driver.findElement(locator); //Find the element
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		WebElement element=driver.findElement(locator);
		return element.getText();
	}
	
	public String takeScreenShot(String name) {
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		
		//File destFile=new File(System.getProperty("user.dir")+"//Screenshots//"+name);
		String path=System.getProperty("user.dir")+"//Screenshots//"+name;
		File destFile=new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
	}
}

 * 
 * */
 