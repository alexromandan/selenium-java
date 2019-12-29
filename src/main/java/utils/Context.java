package utils;

import org.openqa.selenium.By;

import browser.Browser;

public class Context {
	
	public static void switchToFrame(By frameLocator) {
		ElementFinder.waitForPage();
		Browser.getDriver().switchTo().frame(Browser.getDriver().findElement(frameLocator));
	}

	public static void switchToDefaultContentAndFocusOnElement(By locator) {
		Browser.getDriver().switchTo().defaultContent();
		ElementFinder.waitForElementIsClickableAndClick(locator);
	}
}
