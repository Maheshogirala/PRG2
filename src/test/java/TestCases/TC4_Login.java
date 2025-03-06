package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.Baseclass;
import PageObjectiveModule.LoginPageObjects;
import Utils.XLUtils;

public class TC4_Login extends Baseclass {

	@Test
	public void Login4() throws IOException {
		LoginPageObjects lg= new LoginPageObjects(driver);
		String file= System.getProperty("user.dir")+"\\TestData\\"+"data.xlsx";
		  int xlrow=XLUtils.getRowCount(file, "Sheet2");
		
		  for(int r=1;r<xlrow;r++) {
		  
		 String user= XLUtils.getCellData(file, "Sheet2", r, 0);
		 String psw  =  XLUtils.getCellData(file, "Sheet2", r, 1);
		lg.username(user);
		lg.password(psw);
		lg.login();
		
		
		// validating 
		
		String actitle=driver.getTitle();
		System.out.println(actitle);
		String exptitle="Adactin.com - Search Hotel";
		
		if(actitle.equals(exptitle)) {
			System.out.println("Test case is Passed");
			
			XLUtils.setCellData(file, "Sheet2", r, 2, "Pass");
			XLUtils.fillGreenColor(file, "Sheet2", r, 2);
		}else {
			System.out.println("Test case is Passed");
			XLUtils.setCellData(file, "Sheet2", r, 2, "Fail");
			XLUtils.fillRedColor(file, "Sheet2", r, 2);
		}
		
	}}
	
	
	
	
}
