package api.utilities;

//import org.apache.commons.mail.DefaultAuthenticator;
//import org.apache.commons.mail.ImageHtmlEmail;
//import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	    public ExtentSparkReporter sparkReporter;
	    public ExtentReports extent;
	    public ExtentTest test;
	    
		String repName;
		public void onStart(ITestContext testContext)
		{
			String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        repName ="Test-Report-"+timeStamp+".html";
	        
	        sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
	        
	        sparkReporter.config().setDocumentTitle("opencart Automation Report");//title of the report
	        sparkReporter.config().setReportName("Pet store API Testing");//name of the report
	        sparkReporter.config().setTheme(Theme.DARK);
		
	        extent=new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Application", "Pet store API");
	        extent.setSystemInfo("Operating System",System.getProperty("os.name"));
	        extent.setSystemInfo("Sub Module", "Customers");
	        extent.setSystemInfo("User Name", System.getProperty("user.name"));
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("User", "Tina");
		}
	        public void onTestSuccess(ITestResult result)
	        {
	        	test=extent.createTest(result.getName());
	        	test.assignCategory(result.getMethod().getGroups());
	        	test.createNode(result.getName());
	        	test.log(Status.PASS,"Test Passed");
	        	
	        }
	        
	        public void onTestFailure(ITestResult result)
	        {
	        	test=extent.createTest(result.getName());
	        	test.createNode(result.getName());
	        	test.assignCategory(result.getMethod().getGroups());
	        	test.log(Status.FAIL,"Test failed");
	        	test.log(Status.INFO,"Error Message: "+result.getThrowable().getMessage());
	        	
	        }
	        
		    public void onTestSkipped(ITestResult result) {
		    	test=extent.createTest(result.getName());
	        	test.createNode(result.getName());
		    	test.assignCategory(result.getMethod().getGroups());
	        	test.log(Status.SKIP, "Test Case: " +result.getName()+"was skipped");
	        	test.log(Status.INFO,"Error Message: "+result.getThrowable().getMessage());
		    }
		    
		    public void onFinish(ITestContext testContext) {
		    	extent.flush();
		    }
	            //send the report email
	           /* try {
	            	URL url=new URL("file///"+System.getProperty("user.dir")+"\\reports\\+repName");
	            	//create the email massgge
	            	ImageHtmlEmail email=new ImageHtmlEmail();
	            	email.setDataSourceResolver(new DataSourceUrlResolver(url));
	            	email.setHostName("smtp.goolemail.com");//支持gmail
	            	email.setSmtpPort(465);
	            	email.setAuthenticator(new DefaultAuthenticator("liut44194@gmail.com","password"));
	            	email.setSSLOnConnect(true);
	            	email.setFrom("liut44194@gamil.com");//sender
	            	email.setSubject("Test Results");
	            	email.setMsg("Please find Attached Report.....");
	            	email.addTo("test.qagroup@gmail.com");//receiver can add the qa group
	            	email.attach(url, "extent report", "please check report");
	            	email.send();//send the email
	            }
	            catch(Exception e)
	            {
	            	e.printStackTrace();
	            }*/
	        
		    }


