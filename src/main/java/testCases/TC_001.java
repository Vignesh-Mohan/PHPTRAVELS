package testCases;

import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.annotations.BeforeClass;



import pages.UserPhpPage;
import wrappers.PHP_Wrapper;


public class TC_001 extends PHP_Wrapper {


	@BeforeClass
	public void TC_001_Data()
	{
		browserName = "chrome";
		LoginAS="user";
		testCaseName = "Quick Search";
		testDescription = "PHP Travels";
		category = "Smoke";
		authors = "Vignesh Mohan";
		dataSheetName = "TC001";
	}
	
	
	@Test
	public void runTest1() throws Throwable 
	{
		DateFormat dateformat = new SimpleDateFormat("dd//MM//yyyy");
		Date date = new Date();
		String currentdate = dateformat.format(date);
		System.out.println(currentdate);
		String pdate =currentdate.substring(0, 2);
		System.out.println(pdate);
		int ipdate = Integer.parseInt(pdate);
		
		int ipickupdate = ipdate +2;
		int ipickoffdate = ipdate +6;
		
		System.out.println(ipickupdate);
		System.out.println(ipickoffdate);
		
		String pickupdate = String.valueOf(ipickupdate);
		
		String dropoffdate = String.valueOf(ipickoffdate);
		
		System.out.println("Inside test method");
		new UserPhpPage(driver, test)
		.clickCar()
		.click_Pick_UP_Location()
		.select_Pick_UP_Location()
		.click_Drop_Off_Location()
		.click_Pick_Up_Date()
		.select_Pick_Up_Date(pickupdate)
		.select_Drop_Off_Time()
		.click_Drop_Off_Date()
		.select_Dop_Off_Date(dropoffdate)
		.click_Quick_Search();
	
		
		
	}

}
