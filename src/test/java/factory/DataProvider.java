package factory;

import dataprovider.ConfigurationData;
import dataprovider.ExcelData;

public class DataProvider {
	
	public static ConfigurationData getconfig() {
		
		ConfigurationData config = new ConfigurationData();
		return config;
	}
	
public static ExcelData getExl() {
		
	ExcelData excel = new ExcelData();
		return excel;
	}

}
