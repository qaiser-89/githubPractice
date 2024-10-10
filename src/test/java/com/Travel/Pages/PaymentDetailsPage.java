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
	
	protected By select_card_typ = By.xpath("//input[@value='visa']");
	protected By card_number =By.xpath("//tbody/tr[1]/td[2]//input");
	protected By expiry_day = By.xpath("//tbody/tr[1]/td[2]//input");
	protected By expiry_year = By.xpath("//select[@name='expiry_year']");
	protected By paynow_btn = By.xpath("//input[@value='Pay now']");
	public void enterPaymentDetails(String cardType, String cardnum, String day, String year)
	{
		Utility.waitForWebElement(driver, By.xpath("//input[@value='"+cardType+"']"));
		Utility.waitForWebElement(driver, card_number).sendKeys(cardnum);
		Utility.selectFromListByVisibleText(driver, expiry_day, day);
		Utility.selectFromListByVisibleText(driver, expiry_year, year);
		Utility.waitForWebElement(driver, paynow_btn).click();
		
	}

}
