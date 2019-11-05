package com.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CommonFunctions extends StaticVaraibles {

	// Launch chrome browser
	public void chromeBrowserLaunch() {
		System.setProperty("webdriver.chrome.driver", "./browserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// IE browser launch
	public void ieBrowserLaunch() {
		System.setProperty("webdriver.ie.driver", "./browserDrivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}

	// Type URL into openedBrowser
	public void typeURL(String url) {
		driver.navigate().to(url);
		// wait for few sec to load the page
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/******* Sendkey by any locater *************/
	public void sendKeysByAnyLocater(final By locaterName, String inputData) {
		try {
			WebElement ele = driver.findElement(locaterName);
			if (ele.isDisplayed() && ele.isEnabled()) {
				ele.clear();
				ele.sendKeys(inputData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*********** Click by any locater************* */
	public void clickByAnyLocater(final By locaterName) {
		try {
			WebElement ele = driver.findElement(locaterName);
			if (ele.isDisplayed() && ele.isEnabled()) {
				ele.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/******************** Frame handle *******/
	public void iFrameByIndex(int i) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(i);
	}

	public int IframeCount() {
		driver.switchTo().defaultContent();
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are: " + numberOfFrames);

		return numberOfFrames;
	}

	public int iFrameLoop(final By locator) {
		// WebElement found = fluentWait(By.xpath(xPathElement));
		int ElementpresenceCount = 0;
		int Loop = 0;
		int maxFramaecount = IframeCount();//3

		while (ElementpresenceCount < 1) {
			try {
				Thread.sleep(250);
				iFrameByIndex(Loop);
				ElementpresenceCount = driver.findElements(locator).size();//1
				System.out.println("Try LoopAllframesAndReturnWebEL: " + Loop + "; ElementpresenceCount: "	+ ElementpresenceCount);
				Loop++;//1
				if (ElementpresenceCount > 0 || Loop > maxFramaecount) {
					break;
				}
			} catch (Exception ex) {
				System.out.println("Catch LoopAllframesAndReturnWebEL : " + Loop + "; " + ex);
			}
		}
		return ElementpresenceCount;
	}
}
