package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	// ThreadSafe for SS
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // initialize the instance variable driver!!
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else
			System.err.print("Invalid Browser Name");
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for " + browserName);
		if (browserName == Browser.CHROME) {

			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else
			System.err.print("Invalid Browser Name");
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for " + browserName);

		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}

		else
			System.err.print("Invalid Browser Name");
	}

	public void goToWebsite(String url) {
		driver.get().get(url);
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator); // Find the element
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		logger.info("Element found and now clicking on it " + element);
		element.click();
	}
	
	public void clickOnCheckBox(By locator) {
		logger.info("Finding element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator); // Find the element
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found and now clicking on checkBox " + element);
		element.click();
	}

	public void clickOn(WebElement element) {
		logger.info("WebElement found and now clicking");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator); // Find the element
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found and now enter text " + textToEnter);
		element.sendKeys(textToEnter);
	}

	public void clearText(By locator) {
		logger.info("Finding element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator); // Find the element
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found and now clearing the text from textBox ");
		element.clear();
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding element with the locator " + locator);
		// WebElement element = driver.get().findElement(locator); // Find the element
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found and now enter Special Key" + keyToEnter);
		element.sendKeys(keyToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning the visible " + element.getText());
		return element.getText();
	}

	public String getVisibleText(WebElement element) {

		logger.info("Returning the visible " + element.getText());
		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {

		logger.info("Finding All Elements with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements found and now returning/printing the list of All visible elements ");

		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}

	public List<WebElement> getAllElements(By locator) {

		logger.info("Finding All Elements with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);

		logger.info("Elements found and now returning/printing the list of All visible elements ");

		return elementList;
	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {

		logger.info("Finding Element with the locator " + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		logger.info("Selecting the required option " + optionToSelect);
		select.selectByVisibleText(optionToSelect);
	}

	public void quitSession() {
		driver.get().quit();
	}

	public String takeScreenShot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);

		// File destFile=new
		// File(System.getProperty("user.dir")+"//Screenshots//"+name);
		//String path = System.getProperty("user.dir") + "//Screenshots//" + name + " - " + timeStamp + ".png";
		
		String path = "./Screenshots//" + name + " - " + timeStamp + ".png";

		
		File destFile = new File(path);
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
 * 
 * private WebDriver driver;
 * 
 * public WebDriver getDriver() { return driver; }
 * 
 * 
 * 
 * public BrowserUtility(WebDriver driver) { super(); this.driver = driver;
 * //initialize the instance variable driver!! }
 * 
 * public BrowserUtility(String browserName) { if
 * (browserName.equalsIgnoreCase("chrome")) { driver=new ChromeDriver(); } else
 * if (browserName.equalsIgnoreCase("edge")) { driver=new EdgeDriver(); } else
 * System.err.print("Invalid Browser Name"); }
 * 
 * public BrowserUtility(Browser browserName) { if (browserName ==
 * Browser.CHROME) { driver=new ChromeDriver(); } else if (browserName ==
 * Browser.EDGE) {
 * 
 * driver=new EdgeDriver(); } else System.err.print("Invalid Browser Name"); }
 * 
 * 
 * public void goToWebsite(String url) { driver.get(url); }
 * 
 * public void maximizeWindow() { driver.manage().window().maximize(); }
 * 
 * public void clickOn(By locator) { WebElement
 * element=driver.findElement(locator); //Find the element element.click(); }
 * 
 * public void enterText(By locator, String textToEnter) { WebElement
 * element=driver.findElement(locator); //Find the element
 * element.sendKeys(textToEnter); }
 * 
 * public String getVisibleText(By locator) { WebElement
 * element=driver.findElement(locator); return element.getText(); }
 * 
 * public String takeScreenShot(String name) {
 * 
 * TakesScreenshot screenshot=(TakesScreenshot)driver; File
 * srcFile=screenshot.getScreenshotAs(OutputType.FILE);
 * 
 * //File destFile=new
 * File(System.getProperty("user.dir")+"//Screenshots//"+name); String
 * path=System.getProperty("user.dir")+"//Screenshots//"+name; File destFile=new
 * File(path); try { FileUtils.copyFile(srcFile, destFile); } catch (IOException
 * e) {
 * 
 * e.printStackTrace(); } return path; } }
 * 
 * 
 */
