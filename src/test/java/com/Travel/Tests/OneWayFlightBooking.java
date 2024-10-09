package com.Travel.Tests;

import com.Travel.Base.BaseClass;
import com.Travel.Pages.HomePage;
import com.Travel.Pages.LoginPage;

public class OneWayFlightBooking extends BaseClass
{
	
	public void makeOneWayBooking()
	{
		LoginPage login=new LoginPage(driver);
		HomePage homeP=new HomePage(driver);
		homeP.onyWayFlight();
		
		
	}

}
