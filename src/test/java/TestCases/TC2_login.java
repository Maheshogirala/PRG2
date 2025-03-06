package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import PageObjectiveModule.Loginpage;

public class TC2_login extends Baseclass {
	@Test
	public void login2() {
		Loginpage lg= new Loginpage(driver);
		
		lg.username("Venkat1997");
		lg.password("1ZL16F");
		lg.login();
	}
	

}
