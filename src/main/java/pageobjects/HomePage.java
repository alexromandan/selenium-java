package pageobjects;

import org.openqa.selenium.By;

import utils.ElementFinder;

public class HomePage {

	private By popUplocator = By.cssSelector("input[name=\"PopupMessage$btnOK\"]");
	private By frameLocator= By.cssSelector("iframe[src=\"HomeDetail.aspx?Login=True\"]");
	
	
	public By getFrmaeLocator() {
		return frameLocator;
	}
	
	public boolean isPopupShown() {
		return ElementFinder.isPresent(popUplocator);
	}
	
	public void dismmissPopUp() {
		ElementFinder.waitForElementIsClickableAndClick(popUplocator);
	}

}
