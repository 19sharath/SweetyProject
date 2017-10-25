package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigurationData {
	  Properties p;
	public ConfigurationData () {
		File s = new File("./configuration/config.properties");
		try {
			FileInputStream f = new FileInputStream (s);
    p   = new Properties(); // Properites is an inbuild class from java.util
			p.load(f);
		} catch (Exception e) {
			System.out.println("Error is " +e.getMessage());
		}	
	}
		
	public String getAppurl() {
		String url = p.getProperty("url");
		return url;
	}
	public String getchromepath() {
		String ch = p.getProperty("chrome");
		return ch;
	}
}
