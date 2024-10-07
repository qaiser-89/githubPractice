package com.Travel.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class ConfigReader 
{
	
	public static String getProperty(String key) 
	{
		Properties property=new Properties();
		
		try {
			property.load(new FileInputStream(new File("./ConfigFiles/Config.properties")));
		} 
		catch (IOException e) 
		{
			Reporter.log("Log INFO: Unable to load Config file"+e.getMessage());
		}
		
		String value=property.getProperty(key);
		
		return value;
	}
}