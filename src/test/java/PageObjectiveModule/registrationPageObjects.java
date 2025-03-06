package PageObjectiveModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import Base.BaseclassPageobjects;

public class registrationPageObjects extends BaseclassPageobjects {
  public static WebDriver driver;
  
  public registrationPageObjects(WebDriver driver) {
	  super(driver);


  }
	@FindBy(xpath="//a[@href='Register.php']") WebElement reg;
	
  
	
}
