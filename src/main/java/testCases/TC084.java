package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;

import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC084 extends PHP_Wrapper {


	@BeforeClass
	public void TC084Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC084";
		testDescription = "To delete a particular customer profile.";
		category = "P1";
		authors = "Vignesh Mohan";
		dataSheetName = "TC084";
	}
	
	
	@Test()
	public void runTC084(String customerLastName) throws Throwable 
	{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickAccounts()
		.clickCustomers()
		.clickSearch()
		.enterSearch(customerLastName)
		.clickGo()
		.clickDelete(customerLastName);
	
		
		
	}

}
