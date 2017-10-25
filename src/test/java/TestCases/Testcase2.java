package TestCases;

import org.testng.annotations.Test;
//import org.testng.annotations.Test;
//import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import Pages.Reportpage;
import factory.BrowserFactroy;
import factory.DataProvider;

public class Testcase2 {
	ExtentReports r;
	ExtentTest log;
		
		WebDriver wd;
		
		@BeforeMethod
		public void setup() {
			wd=BrowserFactroy.getB("Chrome");
			wd.get(DataProvider.getconfig().getAppurl());
		}
		@Test
		public void login() {
			Reportpage r = PageFactory.initElements(wd, Reportpage.class);
			r.loginPage(DataProvider.getExl().getData(0,0,0),DataProvider.getExl().getData(0,0,1));
			r.signin();
			r.display();
		}
		
		@AfterMethod
		public void closeB() {
			BrowserFactroy.closeB();
	}
	}


