package com.Travel.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Travel.Base.BaseClass;
import com.Travel.Pages.HomePage;
import com.Travel.Pages.LoginPage;

public class OneWayFlightBooking extends BaseClass
{
	@Test	
	public void makingOneWayRes()
	{
		LoginPage LP=new LoginPage(driver);
		LP.validLogin("agileway", "testwise");
		HomePage HP=new HomePage(driver);
		Assert.assertTrue(HP.isSingedInShowed());
		HP.onyWayFlight();
		
		
	}

}
