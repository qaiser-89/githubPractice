package com.Travel.Helper;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.Travel.DataProvider.ConfigReader;

public class Utility 
{ 	
	public static String  captureScreenshotAsByte(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String ScreenshotAsBase64=ts.getScreenshotAs(OutputType.BASE64);
		return ScreenshotAsBase64;
	}
	
	public static WebElement highLightWebElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor jsexe=(JavascriptExecutor)driver;
		jsexe.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 2px red')",element);
		sleep(1);
		jsexe.executeScript("arguments[0].setAttribute('style','border: solid 2px black')",element);
		return element;
	}
	
	public static void sleep(int timeInSeconds)
	{
		try {
			Thread.sleep(timeInSeconds*1000);
		} catch (InterruptedException e) 
		{
			Reporter.log("Log INFO: something went wrong in sleep Thread: "+e.getMessage(), true);
		}
		}
		
		public static String currentDate()
		{
			SimpleDateFormat myformat=new SimpleDateFormat("HH_mm_ss_MM_yyyy");
			String newFormat=myformat.format(new Date());
			return newFormat;
		}
	
	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement destination)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(source, destination).build();
	}
	
	public static void scrollTillElementPresent(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element);
	}
	
	public static void scrollTillElementPresent(WebDriver driver, By locator)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(driver.findElement(locator)).perform();
	}
	
	
	public static WebElement waitForWebElement(WebDriver driver, By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element=	wait.until(ExpectedConditions.elementToBeClickable(locator));
		String highLightcondition=ConfigReader.getProperty("HighLighter");
		if(highLightcondition.equalsIgnoreCase("True"))
		{
		highLightWebElement(driver, element);
		}
		return element;
	}	
	public static void clickOnElement(WebDriver driver, WebElement element)
	{
		try {
			element.click();
		} 
		catch (Exception e) 
		{
			Reporter.log("Log INFO: WebElement click didn't work trying Action class click"+e.getMessage() ,true);
			Actions act=new Actions(driver);
			try {
				act.click(element).perform();
				
			} catch (Exception e2) {
				Reporter.log("Actions class click also failed, trying JS click now!!"+e2.getMessage(), true);
			JavascriptExecutor JSE= (JavascriptExecutor)driver;
			JSE.executeScript("arguments[0].click()", element);}
			}
		}
		public static void mouseHover(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
	act.moveToElement(element).perform();
		}
		
		public static void doubleClick(WebDriver driver, WebElement element)
		{
			Actions act=new Actions(driver);
			act.doubleClick(element).perform();
		}
		public static void selectFromListByValue(WebDriver driver, By locator, String valueToSelect)
		{
			Select sel=new Select(Utility.waitForWebElement(driver, locator));
			sel.selectByValue(valueToSelect);
		}
		public static void selectFromListByindex(WebDriver driver, By locator, int indextoselect)
		{
			Select sel=new Select(Utility.waitForWebElement(driver, locator));
			sel.selectByIndex(indextoselect);
		}
		public static void selectFromListByVisibleText(WebDriver driver, By locator, String optionToSelect)
		{
			Select sel=new Select(Utility.waitForWebElement(driver, locator));
			sel.selectByVisibleText(optionToSelect);
		}
		
}
