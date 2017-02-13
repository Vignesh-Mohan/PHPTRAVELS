package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;

import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC083 extends PHP_Wrapper {


	@BeforeClass
	public void TC083Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC083";
		testDescription = "To edit/update  the customer profile.";
		category = "P1";
		authors = "Vignesh Mohan";
		dataSheetName = "TC083";
	}
	
	
	@Test(dataProvider="fetchData",groups="editCustomer",dependsOnGroups="addCustomer")
	public void runTC083(String customerLastName) throws Throwable 
	{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickAccounts()
		.clickCustomers()
		.clickedit(customerLastName)
		.enterFirstName("C.T Vignesh")
		.enterLastName("C.T Mohan")
		.enterAddress1(" Bla bla street 1")
		.enterAddress2("bla bla street 2")
		.enterMobile("9000000009")
		.enterEmailID("changedemail@yopmail.com")
		.clickSubmit();
		
		
	
		
		
	}

}
