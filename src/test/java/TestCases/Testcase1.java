package TestCases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
/*import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;
import factory.BrowserFactroy;
import factory.DataProvider;

public class Testcase1 {
	
ExtentReports r;
ExtentTest log;
	
	WebDriver wd;
	
	@BeforeMethod
	public void setup() {
		
		r = new ExtentReports("./Reports/loginpage.html",true);
		log = r.startTest("Start the report for the test");
		wd=BrowserFactroy.getB("Chrome");
		wd.get(DataProvider.getconfig().getAppurl());
	log.log(LogStatus.INFO,"Application running");
	}
	
	@Test
	public void testHomePAge() throws InterruptedException {
	
	LoginPage lg= PageFactory.initElements(wd, LoginPage.class);
	String	t1= lg.ti();
	AssertJUnit.assertTrue(t1.contains("You need to sign in or sign up before continuing"));
   
	lg.loginPage(DataProvider.getExl().getData(0,0,0),DataProvider.getExl().getData(0,0,1));
    lg.signin();
    Thread.sleep(2000);
   lg.logintitle();	
   log.log(LogStatus.PASS, "Logedin Sucessfully");
   lg.reportclick();
   lg.DataValidation();
   log.log(LogStatus.PASS, "Data Entered Sucessfully");

   
	}
	@AfterMethod
	public void closeB() {
		BrowserFactroy.closeB();
		r.endTest(log);
		r.flush();

	}

}
