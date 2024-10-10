package com.Travel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Travel.Helper.Utility;

public class PaymentDetailsPage 
{
	WebDriver driver;
	public PaymentDetailsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	protected By select_card_typ = By.xpath("//tbody/tr[1]/td[2]");
	protected By card_number =By.xpath("//input[@name='card_number']");
	protected By expiry_day = By.xpath("//select[@name='expiry_month']");
	protected By expiry_year = By.xpath("//select[@name='expiry_year']");
	protected By paynow_btn = By.xpath("//input[@value='Pay now']");
	protected By confirmationmsg=By.xpath("//h2[normalize-space()='Confirmation']");
	
	
	
	
	public void enterPaymentDetails(String cardType, String cardnum)
	{
		Utility.waitForWebElement(driver, By.xpath("//input[@value='"+cardType+"']")).click();
		Utility.waitForWebElement(driver, card_number).sendKeys(cardnum);
		Utility.selectFromListByindex(driver, expiry_day, 7);
		Utility.selectFromListByindex(driver, expiry_year,3);
		Utility.waitForWebElement(driver, paynow_btn).click();
		Utility.waitForWebElement(driver, confirmationmsg).isDisplayed();
	
		
	}

}
