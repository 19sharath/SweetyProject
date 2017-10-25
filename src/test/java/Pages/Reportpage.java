package Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Reportpage {

WebDriver wd;
	
	public Reportpage(WebDriver d) {
		this.wd=d;
	}
	@FindBy(xpath=".//*[@id='user_email']") WebElement uid;
	@FindBy(xpath=".//*[@id='user_password']") WebElement pwd;
	@FindBy(xpath=".//*[@id='new_user']/div[3]/input") WebElement singup;
	@FindBy(xpath="//a[contains(@href, 'repor')]") WebElement click1;
    @FindBy(xpath="//table/tbody/tr[1]/td[6]") WebElement Avg;
    @FindBy(xpath="//table/tbody[1]/tr[1]/td[1]") WebElement Df;
    
  //table/tbody[1]/tr[1]/td[1]"
    
	public void loginPage(String user, String pass) {
		uid.sendKeys(user);
		pwd.sendKeys(pass);
	}
	public void signin() {
		singup.click();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void display() {
		DateFormat df  = new SimpleDateFormat("yyyy-MM-dd");
		Date x = new Date();
		click1.click();
	    try {
	    	 if(Avg.isDisplayed() || Df.equals(df.format(x)))
	    	 {
	    		 System.out.println("Data has entere for the Day : " +df.format(x));
			  System.out.println("The Average Value for the day is = " +Avg.getText());
			 
			 } else 
			 {
				 System.out.println("no data available for the avarage");
			 }
		} catch (Exception e) {
			
		System.out.println(e.getMessage());
	     
		}	}
	
}
