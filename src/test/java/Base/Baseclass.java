package Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Baseclass {
	public static WebDriver driver;
	public ResourceBundle RB;
	public Logger logger;
	@BeforeSuite
	public void openurl() {
		RB=ResourceBundle.getBundle("config");
		logger= LogManager.getLogger(this.getClass());
		
		driver= new ChromeDriver();
		//driver.get("https://adactinhotelapp.com/index.php");
		driver.get(RB.getString("baseurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterSuite
	public void closeurl() {
		driver.close();
	}
	
	public String screenshot(String testname) throws IOException {
		
		String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"\\Screenshots\\"+timestamp+"_"+testname+"_img2.png";
		try {
		FileUtils.copyFile(source, new File(destination));
		}catch(Exception e) {
			e.getMessage();
			e.getStackTrace();
		}
		return destination;
	}
	
	
	
	
	
	
}
