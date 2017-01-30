package testCases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CarsListingPage;
import pages.LoginPage;


import wrappers.PHP_Wrapper;

public class TC_001 extends PHP_Wrapper {


	@BeforeClass
	public void TC_001_Data()
	{
		browserName = "chrome";
		LoginAs="user";
		testCaseName = "Login";
		testDescription = "";
		category = "smoke";
		authors = "PHP";
		dataSheetName = "TC001";
	}
	
	@Test
	public void runTest1() throws Throwable 
	{
		System.out.println("Inside test method");
		new LoginPage(driver, test)
		.clickCar()
		.click_Pick_UP_Location();
	
		
		
	}

}
