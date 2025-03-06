package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseclassPageobjects {
   public static WebDriver driver;
   public BaseclassPageobjects(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
	
	
}
