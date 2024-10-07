package com.Travel.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import com.Travel.DataProvider.ConfigReader;

public class BrowserFactory 
{
	public static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static WebDriver getBrowser(String browserName, String AppUrl)
	{
		if(browserName.equalsIgnoreCase("Chrome")||ConfigReader.getProperty("browser").equalsIgnoreCase("GoogleChrome"))
		{
			ChromeOptions options=new ChromeOptions();
			if(ConfigReader.getProperty("HeadlessMode").equalsIgnoreCase("True"))
			{
				options.addArguments("--headless=new");
				Reporter.log("Chrome is running in Headless Mode!!, you can change the setting in Config file", true);
			}
			
			driver=new ChromeDriver();
		}
			else if(browserName.equalsIgnoreCase("FireFox")||ConfigReader.getProperty("browser").equalsIgnoreCase("MozillaFirefox"))
		{
			if(ConfigReader.getProperty("HeadlessMode").equalsIgnoreCase("True"))
			{
				FirefoxOptions options1=new FirefoxOptions();
				options1.addArguments("--headless=new");
				Reporter.log("FireFox is running in headless mode!! please change the setting on Config file", true);
				
			}
				
			driver=new FirefoxDriver();
		}

			else if(browserName.equalsIgnoreCase("Safari")||ConfigReader.getProperty("browser").equalsIgnoreCase("AppleSafari"))
		{
			driver=new SafariDriver() ;
		}
			else if(browserName.equalsIgnoreCase("Edge")||ConfigReader.getProperty("browser").equalsIgnoreCase("MicrosoftEdge"))
		{
			driver=new EdgeDriver();
		}
			else
		{
			Reporter.log("Log INFO: We Only support Chrome, Firefox, Edge and Safari Browsers!!",true);
		}
		
		driver.get(AppUrl);
		driver.manage().window().maximize();
			return driver;
	}
	
	public static void closingBrowser()
	{
		driver.quit();
	}
	

}
