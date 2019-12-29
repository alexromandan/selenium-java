import org.junit.Assert;
import org.junit.Test;

import businessfunctions.LoginFunctions;

public class LoginTests extends BaseTestClass {

	@Test
	public void can_login_in_people_planner() {
		LoginFunctions loginFunctions = new LoginFunctions();
		
		loginFunctions.login(LoginTestData.userCredentias);
		
		Assert.assertTrue("Home Page should be shown!", loginFunctions.isOnHomePage());
	}
}
