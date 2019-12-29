package businessfunctions;

import models.Credentials;
import pageobjects.EventsTab;
import pageobjects.HomePage;
import pageobjects.LoginMenu;
import pageobjects.LoginPage;
import pageobjects.LoginPeoplePlanner;
import utils.Context;
import utils.DriverUtils;

public class LoginFunctions {
	
	public void login(Credentials credentials) {
    	LoginPage loginPage = new LoginPage();
    	
    	loginPage.openLoginPage();
    	loginPage.setClientID(credentials.getClintId());
    	loginPage.clickLoginButton();
    	
    	DriverUtils.switchToLastOpenedWindow();
    	
    	LoginMenu loginMenuPage = new LoginMenu();
    	loginMenuPage.clickSignInPeoplePlannerButton();
    	
    	LoginPeoplePlanner loginPeoplePlannerPage = new LoginPeoplePlanner();
    	loginPeoplePlannerPage.setUserCode(credentials.getUserName());
    	loginPeoplePlannerPage.setPassword(credentials.getPassword());
    	loginPeoplePlannerPage.clickLoginButton();
    	
    	try {
    	Thread.sleep(1000);
    	} catch (Exception e) {}
    	
    	HomePage homePage = new HomePage();
    	
    	Context.switchToFrame(homePage.getFrmaeLocator());
    	
    	if(homePage.isPopupShown()) homePage.dismmissPopUp(); 
	}
	
	public boolean isOnHomePage() {
		return new EventsTab().isEventsTabDisplayed();
	}
}
