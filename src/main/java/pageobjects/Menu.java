package pageobjects;

import org.openqa.selenium.By;

import utils.ElementFinder;

public class Menu {

	private By homeMenuItem = By.cssSelector("a[title=\"Home\"]");
	private By crmMenuItem = By.cssSelector("a[title=\"Customer Relationship Management\"]");
		
	public By getHomeMenuItem() {
		return homeMenuItem;
	}
	
	public By getCrmMenuItem() {
		return crmMenuItem;
	}
	
	public void clickOnCrmMenuItem() {
		ElementFinder.waitForElementIsClickableAndClick(crmMenuItem);
	}
}
