package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.ElementFinder;

public class LoginPeoplePlanner {

	private By userCodeLocator = By.id("txtUserCode");
	private By passwordLocator = By.id("txtUserPassword");
	private By loginButtonLocator = By.id("btnLogin");

	public void setUserCode(String userCode) {
		WebElement clientTextBoxElement = ElementFinder.elementIsPresent(userCodeLocator);
		clientTextBoxElement.sendKeys(userCode);
	}

	public void setPassword(String password) {
		WebElement clientTextBoxElement = ElementFinder.elementIsPresent(passwordLocator);
		clientTextBoxElement.sendKeys(password);
	}

	public void clickLoginButton() {
		ElementFinder.waitForElementIsClickableAndClick(loginButtonLocator);
	}
}
