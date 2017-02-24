package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;



import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC108 extends PHP_Wrapper {


	@BeforeClass
	public void TC108Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC108";
		testDescription = "Edit a Admin with invalid values";
		category = "P2";
		authors = "Vignesh Mohan";
		dataSheetName = "TC108";
	}
	
	
	@Test(dataProvider="fetchData",groups={"editInvalidAdmin"},dependsOnGroups="editAdmin")
	public void runTC108(String searchAdminName, String adminFirstName,String adminLastName, String adminEmail, String adminPassword,
							String adminAdd1, String adminAdd2, String adminMobile, String adminCountry) throws Throwable 
	{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickAccounts()
		.clickAdmins()
		.clickSearch()
		.enterSearch(searchAdminName)
		.clickGo()
		.clickedit(searchAdminName)
		.enterFirstName(adminFirstName)
		.enterLastName(adminLastName)
		.enterEmailID(adminEmail)
		.enterPassword(adminPassword)
		.enterAddress1(adminAdd1)
		.enterAddress2(adminAdd2)
		.enterMobile(adminMobile)
		.selectCountry("india")
		.selectEditModules("All")
		.clickSubmit();
		
		
		
		
	
	}

}
