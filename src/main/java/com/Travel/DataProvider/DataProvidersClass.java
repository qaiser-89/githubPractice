package com.Travel.DataProvider;

import org.testng.annotations.DataProvider;

public class DataProvidersClass 
{
	@DataProvider(name= "TestData")
	public static Object[][] getData()
	{
		Object[][] arr=	ExcelReader.getDataFromExcel("LoginData");
		return arr;
	}
	
	@DataProvider(name="TestDataForOneWay")
	public static Object[][] getDataForOnewayBooking()
	{
		Object [][] arr1=ExcelReader.getDataFromExcel("OneWayBooking");
		return arr1;
	}
	

}
