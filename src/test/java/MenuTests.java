import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import businessfunctions.LoginFunctions;
import businessfunctions.MenuFunctions;

public class MenuTests extends BaseTestClass {
	
	@Before
	public void test_setup() {
		LoginFunctions loginFunctions = new LoginFunctions();
		
		loginFunctions.login(LoginTestData.userCredentias);
		
		Assert.assertTrue("Home Page should be shown!", loginFunctions.isOnHomePage());
	}
	
	@Test
	public void can_open_crm() {
		MenuFunctions menuFunctions = new MenuFunctions();
		
		menuFunctions.openCRM();
		
		Assert.assertTrue("CRM page should be opened!", menuFunctions.isOnCrmPage());
	}
}
