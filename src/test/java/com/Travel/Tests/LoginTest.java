package com.Travel.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.Travel.Base.BaseClass;
import com.Travel.DataProvider.DataProvidersClass;
import com.Travel.Pages.HomePage;
import com.Travel.Pages.LoginPage;



public class LoginTest extends BaseClass
{
	@Test(priority = 1)
	public void invalidLoginexpected()
	{
		LoginPage login=new LoginPage(driver);
		login.inValidSignin("Test");
	}
	
	@Test (priority = 2, dataProvider="TestData", dataProviderClass = DataProvidersClass.class)
	public void validLogInToApp(String uname, String Password)
	{
		LoginPage login=new LoginPage(driver);
		login.validLogin(uname, Password);
		HomePage hp=new HomePage(driver);
		Assert.assertTrue(hp.isSingedInShowed());
	}

}