package PageObjectiveModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	public static WebDriver driver;
	
	public LoginPageObjects(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="username")WebElement username;
	
	@FindBy(id="password")WebElement password;
	
	@FindBy(xpath="//input[@type='Submit']") WebElement login;
	
	
	public void username(String user) {
		username.sendKeys(user);
	}
	
	public void password(String psd) {
		password.sendKeys(psd);
	}
	
	public void login() {
		login.click();
	}
	
	
}
