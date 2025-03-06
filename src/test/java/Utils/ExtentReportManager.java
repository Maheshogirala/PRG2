package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.Baseclass;

public class ExtentReportManager  implements ITestListener{
    public ExtentSparkReporter sparkreporter; // Ui of the Test report 
	public ExtentReports reports;// common information of the reports 
	public ExtentTest test; // Test Execution data enter into the reports 
	
	public void onStart(ITestContext context) {
		// timestamp
		String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        // specify the location of the folder
		
		sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\Extentreports\\"+timestamp+"_Report1.html");
		// set the document title 
		sparkreporter.config().setDocumentTitle("Automation Testing");
		// set the report title
		sparkreporter.config().setReportName("Smoke Test Report");
		// set the Theme of the document 
		sparkreporter.config().setTheme(Theme.STANDARD);
		  // set the common info using the reports
		
		reports= new ExtentReports();
		// Attach the sparkreporter in reports 
		reports.attachReporter(sparkreporter);
		// set the system info
		
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Tester Name", "Mahesh");
		reports.setSystemInfo("OS", "Windows");
		
	  }
	
	public void onTestSuccess(ITestResult result) {

       test=reports.createTest(result.getName());
       test.log(Status.PASS, "Test is passed"+"_"+ result.getName());
		
	  }
	
	public void onTestFailure(ITestResult result) {
	    test= reports.createTest(result.getName());
	    test.log(Status.FAIL, "Test is Faild"+"_"+ result.getName());
	    test.log(Status.FAIL, result.getThrowable());// this will be collecting the exception
	    
	    try {
	    String imagepath= new Baseclass().screenshot(result.getName());
	    test.addScreenCaptureFromPath(imagepath);
	    
	    }catch(Exception e) {
	    	e.getMessage();
	    	e.getStackTrace();
	    }
	    
	  				
	  }
	
	public void onTestSkipped(ITestResult result) {
	    test= reports.createTest(result.getName());
	    test.log(Status.SKIP, "Test is skipped"+"_"+result.getName());
	    test.log(Status.SKIP, result.getThrowable());
						
	  }
	
	public void onFinish(ITestContext context) {
	    reports.flush();
	  }
	
	
}
