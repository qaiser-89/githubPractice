package com.Travel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Travel.Helper.Utility;

public class PassengersDetailsPage 
{
	WebDriver driver;
	public PassengersDetailsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	protected By first_name = By.xpath("//input[@name='passengerFirstName']");
	protected By last_name = By.xpath("//input[@name='passengerLastName']");
	protected By next_btn = By.xpath("//input[@value='Next']");
	
	public void enterPassengerDetails(String name, String l_name)
	{
		Utility.waitForWebElement(driver, first_name).sendKeys(name);
		Utility.waitForWebElement(driver, last_name).sendKeys(l_name);
		Utility.waitForWebElement(driver, next_btn).click();
		
	}

}
