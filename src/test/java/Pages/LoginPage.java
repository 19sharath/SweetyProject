package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DataProvider;

public class LoginPage {
	
	WebDriver wd;
	
	public LoginPage(WebDriver lwd) {
		
		this.wd=lwd;
	}
    @FindBy(xpath=".//*[contains(@class , 'alert alert-warning fade in')]") WebElement title;
	@FindBy(xpath=".//*[@id='user_email']") WebElement uname;
	@FindBy(xpath=".//*[@id='user_password']") WebElement pwd;
	@FindBy(xpath=".//*[@id='new_user']/div[3]/input") WebElement signin;
	By logint=By.xpath(".//*[@id='page-content-wrapper']/div/div[2]/div");
	@FindBy(xpath="//*[@id='sidebar-wrapper']/ul/li[2]/a") WebElement click1;
	@FindBy(xpath="//*[@id='page-content-wrapper']/div/div[2]/div[2]/a") WebElement click2;
	@FindBy(xpath=".//*[@id='new_entry']/input[3]") WebElement click3;
	@FindBy(xpath="//*[@id='page-content-wrapper']/div/div[3]/div[2]/a") WebElement click4;
	@FindBy(xpath=".//*[contains(@class, 'alert alert-warning fade in')]") WebElement DataVal;
	@FindBy(xpath=".//*[@id='entry_level']") WebElement enter;
	
	
public String ti() {
	return title.getText();
}

public void loginPage(String username, String passwd) {
	uname.sendKeys(username);
	pwd.sendKeys(passwd);		
}

public void logintitle() {
	WebDriverWait wait = new WebDriverWait(wd, 15);
	WebElement ele =	wait.until(ExpectedConditions.presenceOfElementLocated(logint));
	String text =ele.getText();
	Assert.assertEquals(text,"Hello sharath1122@gmail.com\n" + 
			"Welcome to Sweety", "getting something else");
}

public void signin() {
	signin.click();
}

public void reportclick() throws InterruptedException {
	click1.click();
}

public void DataValidation() throws InterruptedException {
	click2.click();
	click3.click();
	try {
		if (DataVal.isDisplayed()) {
			System.out.println(DataVal.getText());
		}
	} catch (Exception e) {
		
		for(int i = 0; i <= DataProvider.getExl().sheetcount(1);i++) 
		{
		enter.sendKeys(String.valueOf(DataProvider.getExl().getDa(1, i, 0)));
		click3.click();	
		try {
		     if (DataVal.isDisplayed()) {
						 break;
						 }
	} catch (Exception f) {
						}	
click4.click();
        }
      } 
	}
	
}
