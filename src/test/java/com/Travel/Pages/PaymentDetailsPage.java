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
	
	protected By select_card_typ = By.xpath("//tbody/tr[1]/td[2]//input");
	protected By card_number =By.xpath("//tbody/tr[1]/td[2]//input");
	protected By expiry_day = By.xpath("//tbody/tr[1]/td[2]//input");
	protected By expiry_year = By.xpath("//select[@name='expiry_year']");
	protected By paynow_btn = By.xpath("//input[@value='Pay now']");
	
	
	public void enterPaymentDetails(String cardnum, String day, String year)
	{
		
		Utility.waitForWebElement(driver, select_card_typ).click();
		Utility.waitForWebElement(driver, card_number).sendKeys(cardnum);
		Utility.selectFromListByVisibleText(driver, expiry_day, day);
		Utility.selectFromListByVisibleText(driver, expiry_year, year);
		Utility.clickOnElement(driver, driver.findElement(card_number));
		
	}

}
