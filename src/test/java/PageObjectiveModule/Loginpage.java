package PageObjectiveModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
 public static WebDriver driver;
 
 public Loginpage(WebDriver driver) {
	 
	 this.driver=driver;
	 
 }
	By username= By.id("username");
	By password = By.id("password");
	By login= By.xpath("//input[@type='Submit']");
	
	public void username(String user) {
		driver.findElement(username).sendKeys(user);
	}
	
	public void password(String psd) {
		driver.findElement(password).sendKeys(psd);
	}
	
	public void login() {
	driver.findElement(login).click();
	}
	
	
}
