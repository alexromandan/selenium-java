package pageobjects;

import org.openqa.selenium.By;

import utils.ElementFinder;

/**
 * Note: Page is located in frame and switch to the frame is done at login.
 */

public class EventsTab {
	private By eventsTabLocator = By.id("RadTabStrip1StyleSheetHolder");
	
	public boolean isEventsTabDisplayed() {
		return ElementFinder.isPresent(eventsTabLocator);
	}
}