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
	
	
	@Test(dataProvider="fetchData",groups={"P1","editCustomer"},dependsOnGroups="addCustomer")
	public void runTC083(String customerFirstName,String customerLastName,String customerMobile,
			String customerPassword,String customerAdd1,
			String customerAdd2,String customerCountry) throws Throwable 
	{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickAccounts()
		.clickCustomers()
		.clickedit("John")
		.enterFirstName(customerFirstName)
		.enterLastName(customerLastName)
		.enterMobile(customerMobile)
		.enterEmailID(generateUniqueMailIDs())
		.enterPassword(customerPassword)
		.selectCountry("india")
		.enterAddress1(customerAdd1)
		.enterAddress2(customerAdd2)
		.clickSubmit();
		
	
		
		
	}

}
