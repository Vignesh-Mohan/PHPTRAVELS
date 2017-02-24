package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;



import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC106 extends PHP_Wrapper {


	@BeforeClass
	public void TC106Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC106";
		testDescription = "Search a admin using invalid values";
		category = "P2";
		authors = "Vignesh Mohan";
		dataSheetName = "TC106";
	}
	
	
	@Test(dataProvider="fetchData",groups="P2")
	public void runTC106(String adminName) throws Throwable 
	{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickAccounts()
		.clickAdmins()
		.clickSearch()
		.enterSearch(adminName)
		.clickGo()
		.verifyAdmin(adminName);
		
		
		
	
	}

}
