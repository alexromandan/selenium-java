package browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ElementFinder;

public class Browser {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void SetUpDriver() {
		WebDriverManager.chromedriver().version(Config.chromeDriverVersion).setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().setScriptTimeout(Config.scriptTimeoutMs, TimeUnit.MILLISECONDS);
		
		new ElementFinder();
	}

	public static void  quit() {
		if (driver != null) {
			driver.quit();
		}
	}
}
