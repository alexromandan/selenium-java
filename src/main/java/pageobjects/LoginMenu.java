package pageobjects;

import org.openqa.selenium.By;

import utils.ElementFinder;

public class LoginMenu {

	
	private By signInPeoplePlannerLocator = By.id("divPeoplePlanner");
	
	public void clickSignInPeoplePlannerButton() {
		ElementFinder.waitForElementIsClickableAndClick(signInPeoplePlannerLocator);
	}
}