package com.Travel.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.Travel.Helper.Utility;

public class LoginPage 
{
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
protected	By UserName= By.xpath("//input[@id='username']");
protected	By password= By.xpath("//input[@id='password']");
protected	By signBtn= By.xpath("//input[@type='submit']");
protected	By rememberBtn= By.xpath("//input[@id='remember_me']");
protected	By errorMessage=By.xpath("//div[contains(text(),'Invalid email or password')]");
	
	public HomePage validLogin(String Uname, String Pass)
	{
		Utility.waitForWebElement(driver, UserName).clear();
		Utility.waitForWebElement(driver, UserName).sendKeys(Uname);
		Utility.waitForWebElement(driver, password).sendKeys(Pass);
		Utility.waitForWebElement(driver, signBtn).click();
		HomePage hp=new HomePage(driver);
		return hp;
	}
	
	public boolean inValidSignin(String uname)
	{
		Utility.waitForWebElement(driver, UserName).sendKeys(uname);
		Utility.waitForWebElement(driver, signBtn).click();
		boolean status=Utility.waitForWebElement(driver, errorMessage).isDisplayed();
		return status;
	}

}
