package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;




import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC073 extends PHP_Wrapper {


	@BeforeClass
	public void TC073Data()
	{
		browserName = "chrome";
		LoginAS="admin";
		testCaseName = "TC073";
		testDescription = "To search a booking using customer using All fields";
		category = "P2";
		authors = "Vignesh Mohan";
		//dataSheetName = "";
	}
	
	
	@Test(groups="P2")
	public void runTC073() throws Throwable 
	{
			
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickOnBookingMenu()
		.clickSearchButton()
		.searchWithParticulars("John");
		
	}

}
