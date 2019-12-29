package businessfunctions;

import browser.Browser;
import pageobjects.Menu;
import utils.Context;
import utils.ElementFinder;

public class MenuFunctions {
		
	public void openCRM() {
		Menu menuPage = new Menu();
		
		Context.switchToDefaultContentAndFocusOnElement(menuPage.getCrmMenuItem());
		ElementFinder.waitForPage();
	}
	
	public boolean isOnCrmPage() {
		return Browser.getDriver().getCurrentUrl().contains("CRM");
	}
}
