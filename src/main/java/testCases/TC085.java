package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;

import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC085 extends PHP_Wrapper {


	@BeforeClass
	public void TC085Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC085";
		testDescription = "To add a new customer.";
		category = "P1";
		authors = "Vignesh Mohan";
		dataSheetName = "TC085";
	}
	
	
	@Test(dataProvider="fetchData",groups="addCustomer")
	public void runTC085(String customerFirstName,String customerLastName,String customerMobile,
							String customerEmail,String customerPassword,String customerAdd1,
							String customerAdd2,String customerCountry) throws Throwable 
	{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickAccounts()
		.clickCustomers()
		.clickAdd()
		.enterFirstName(customerFirstName)
		.enterLastName(customerLastName)
		.enterMobile(customerMobile)
		.enterEmailID(customerEmail)
		.enterPassword(customerPassword)
		.enterAddress1(customerAdd1)
		.enterAddress2(customerAdd2)
		.selectCountry(customerCountry)
		.clickSubmit();
	
	}

}
