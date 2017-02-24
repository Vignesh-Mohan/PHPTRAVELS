package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;



import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC107 extends PHP_Wrapper {


	@BeforeClass
	public void TC106Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC107";
		testDescription = "Add a Admin with invalid values";
		category = "P2";
		authors = "Vignesh Mohan";
	
	}
	
	
	@Test(groups="P2")
	public void runTC107() throws Throwable 
	{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickAccounts()
		.clickAdmins()
		.clickAdd()
		.enterFirstName("")
		.enterLastName("")
		.enterAddress1("")
		.enterAddress2("")
		.enterEmailID("")
		.enterPassword("")
		.enterMobile("")
		.addInvalidAdmin();
		
		
	
	}

}
