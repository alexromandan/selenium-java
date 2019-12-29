package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import config.Config;
import utils.ElementFinder;

public class LoginPage {

	
	private By clientTextBox = By.cssSelector("input[name=\"txtAccountID\"]");
	private By loginLocator = By.id("btnLogin");

	public void openLoginPage() {
		  ElementFinder.goToAndWaitForPage(Config.applicationUrl);
	}
	
	public void setClientID(String clientId) {
		WebElement clientTextBoxElement = ElementFinder.elementIsPresent(clientTextBox);
		clientTextBoxElement.sendKeys(clientId);
		clientTextBoxElement.sendKeys(Keys.TAB);
	}
	
	public void clickLoginButton() {
		ElementFinder.waitForElementIsClickableAndClick(loginLocator);
	}
}
