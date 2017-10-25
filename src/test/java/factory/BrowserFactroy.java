package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactroy {

	static WebDriver wd;

	public static WebDriver getB(String browserN) {
		if (browserN.equalsIgnoreCase("firefox")) {
			wd = new FirefoxDriver();

		} else if (browserN.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", DataProvider.getconfig().getchromepath());
			wd = new ChromeDriver();
		} else if (browserN.equalsIgnoreCase("Safari")) {
			wd = new SafariDriver();

		}
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		return wd;
	}

	public static void closeB() {
		wd.quit();
	}

}
