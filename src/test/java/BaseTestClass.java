// import org.apache.commons.lang3.StringUtils; for string matches
import org.junit.AfterClass;
import org.junit.BeforeClass;

import browser.Browser;

public class BaseTestClass {

	@BeforeClass
	public static void setupClass() {
		Browser.SetUpDriver();
	}

	@AfterClass
	public static void teardown() {
		Browser.quit();
	}
}
