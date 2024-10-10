package com.Travel.Tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Travel.Base.BaseClass;
import com.Travel.Pages.HomePage;
import com.Travel.Pages.LoginPage;
import com.Travel.Pages.PassengersDetailsPage;
import com.Travel.Pages.PaymentDetailsPage;

public class OneWayFlightBooking extends BaseClass
{
	@Test	
	public void makingOneWayRes(String Onewayflight, String Fname, String Lname, String cardnum, String cardexpiry, String cardType)
	{
		LoginPage LP=new LoginPage(driver);
		LP.validLogin("agileway", "testwise");
		HomePage HP=new HomePage(driver);
		Assert.assertTrue(HP.isSingedInShowed());
		HP.onyWayFlight(Onewayflight);
		PassengersDetailsPage passDet=new PassengersDetailsPage(driver);
		passDet.enterPassengerDetails(Fname, Lname);
		PaymentDetailsPage paydetail=new PaymentDetailsPage(driver);
		paydetail.enterPaymentDetails(cardType, cardnum, Onewayflight, cardexpiry);
		
		
	}

}
