package com.Travel.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Travel.Helper.Utility;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	protected By signedInMessage= By.xpath("//div[contains(text(),'Signed in!')]");
	protected By oneWay= By.xpath("//input[@value='oneway']");
	protected By flight_oneway_select=By.xpath("//input[@name='tripType']");
	protected By from_selection=By.xpath("//select[@name='fromPort']");
	protected By to_selection=By.xpath("//select[@name='toPort']");
	protected By flight_selection=By.xpath("//body[1]/div[1]/form[1]/table[2]/tbody[1]/tr");
	protected By departingDate_selection=By.xpath("//select[@id='departDay']");
	protected By departingMonth_selection=By.xpath("//select[@id='departMonth']");
	protected By continue_btn = By.xpath("//body[1]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/th[1]/input[1]");
	
	public boolean isSingedInShowed()
	{
		boolean signInStatus =	Utility.waitForWebElement(driver, signedInMessage).isDisplayed();
		return signInStatus;
	}
	
	public PassengersDetailsPage  onyWayFlight(String flightType)
	{
		Utility.waitForWebElement(driver, By.xpath("//input[@value='"+flightType+"']")).click();
		Utility.selectFromListByindex(driver, from_selection, 1);
		Utility.selectFromListByindex(driver, to_selection, 2);
		//Utility.selectFromListByVisibleText(driver, departingDate_selection, "January 2025");
		Utility.selectFromListByindex(driver, departingDate_selection, 17);
		Utility.selectFromListByindex(driver, departingMonth_selection, 15);
		Utility.waitForWebElement(driver, flight_selection).click();
		Utility.waitForWebElement(driver, continue_btn).click();
		PassengersDetailsPage pass_details=new PassengersDetailsPage(driver);
		return pass_details;
	}
	
	

}
