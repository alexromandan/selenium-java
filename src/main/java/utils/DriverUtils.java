package utils;

import browser.Browser;

public class DriverUtils {
	
	public static void switchToLastOpenedWindow() {
	    for(String winHandle : Browser.getDriver().getWindowHandles()){
	    	Browser.getDriver().switchTo().window(winHandle);
        }
	    
	    Browser.getDriver().manage().window().maximize();
	}
}
