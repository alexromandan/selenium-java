package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.Browser;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

public class ElementFinder {

	private static WebDriverWait _wait;
	private int defaultTimeoutInSeconds = 20;

	public ElementFinder() {
		_wait = new WebDriverWait(Browser.getDriver(), defaultTimeoutInSeconds);
	}

	public static void waitForPage() {
		ExpectedCondition<Boolean> expectation = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};

		int attempts = 0;

		while(attempts < 2) {

			try {
				_wait.until(expectation);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		attempts++;
	}


	public static void goToAndWaitForPage(String url) {
		Browser.getDriver().get(url);
		waitForPage();
	}

	public static WebElement elementIsPresent(By locator) {
		WebElement element = null; 

		try {
			_wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			element = (WebElement) Browser.getDriver().findElement(locator);
		} catch (Exception e) {
			System.out.println("Element" + locator.toString() + " is not visible");
			System.out.println(e.getMessage());
		}

		return element;
	}

	public static boolean isPresent(By locator) {
		try {
			_wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Browser.getDriver().findElement(locator);
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public static void waitForElementIsClickableAndClick(By locator) {

		try {
			_wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			System.out.println("Element" + locator.toString() + " is not clickable");
			System.out.println(e.getMessage());
		}

		if (!retryingFindClick(locator))
			System.out.println("Failed to click "+ locator.toString() +" element after retry");
	}

	private static boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;

		while(attempts < 3) {
			try {
				Browser.getDriver().findElement(by).click();
				result = true;
				break;
			} catch(StaleElementReferenceException e) {
			}
			attempts++;
		}

		return result;
	}

	public static WebElement findFrame(By by) {
		WebElement result = null;
		int attempts = 0;

		while(attempts < 3) {
			try {
				_wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
				result = Browser.getDriver().findElement(by);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			attempts++;
		}

		return result;
	}

	public static WebElement elementAtributreIsNotEmpty(By locator, String attribute) {
		WebElement element = null; 

		try {
			element = Browser.getDriver().findElement(locator);
			_wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
		} catch (Exception e) {
			System.out.println("Element attribut for " + locator.toString() + " is not visible");
			System.out.println(e.getMessage());
		}

		return element;
	}
}
