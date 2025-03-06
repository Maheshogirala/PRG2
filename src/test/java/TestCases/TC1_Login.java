package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import PageObjectiveModule.LoginPageObjects;

public class TC1_Login extends Baseclass {
	
	@Test
	public void login_tc() {
		logger.debug("**** Application Debuging started ***");
		logger.info("**** Login Application Logs ***");
		logger.info("**** Start the testcase login ***");
		LoginPageObjects login= new LoginPageObjects(driver);
		login.username(RB.getString("username"));
		
		logger.info("* Username Enterd done *");
		
		login.password(RB.getString("password"));
		logger.info("* Password Enterd done *");
		login.login();
		logger.info("* click on the login button *");
		//Assert.assertFalse(true);
		
	}
	
	
}
