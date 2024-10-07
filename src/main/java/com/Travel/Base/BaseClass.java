package com.Travel.Base;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Travel.DataProvider.ConfigReader;
import com.Travel.Factory.BrowserFactory;

public class BaseClass 
{
	public WebDriver driver;
	
	@BeforeClass
	public void browserSetup()
	{
		Reporter.log("Setting Up the Browser, running before class!!!!", true);
		String browserToUse= ConfigReader.getProperty("browser");
		String urlToUse=ConfigReader.getProperty("appURL");
		driver=BrowserFactory.getBrowser(browserToUse, urlToUse);
		Reporter.log("Browser is up and running", true);
		
	}
	
	@AfterClass
	public void browserTearDown()
	{
		Reporter.log("Running after class", true);
		BrowserFactory.closingBrowser();
		Reporter.log("Browser Closed!!", true);
		
	}

}
