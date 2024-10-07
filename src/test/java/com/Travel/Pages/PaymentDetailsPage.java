package com.Travel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}
