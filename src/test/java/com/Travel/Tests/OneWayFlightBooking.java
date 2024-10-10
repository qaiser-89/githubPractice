package com.Travel.Tests;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Travel.Base.BaseClass;
import com.Travel.DataProvider.DataProvidersClass;
import com.Travel.Pages.HomePage;
import com.Travel.Pages.LoginPage;
import com.Travel.Pages.PassengersDetailsPage;
import com.Travel.Pages.PaymentDetailsPage;

public class OneWayFlightBooking extends BaseClass
{
	@Test(dataProvider="TestDataForOneWay", dataProviderClass = DataProvidersClass.class)
	public void makingOneWayRes(String uname, String Pass, String Onewayflight, String Fname, String Lname, String cardType, String cardnum)
	{
		LoginPage LP=new LoginPage(driver);
		LP.validLogin(uname, Pass);
		HomePage HP=new HomePage(driver);
		AssertJUnit.assertTrue(HP.isSingedInShowed());
		HP.onyWayFlight(Onewayflight);
		PassengersDetailsPage passDet=new PassengersDetailsPage(driver);
		passDet.enterPassengerDetails(Fname, Lname);
		PaymentDetailsPage paydetail=new PaymentDetailsPage(driver);
		paydetail.enterPaymentDetails(cardType, cardnum);
		HP.signoutOfApp();
		
		
	}

}
