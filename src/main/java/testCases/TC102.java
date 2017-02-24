package testCases;

import org.testng.annotations.Test;

import pages.UserLandingPage;


import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC102 extends PHP_Wrapper {


	@BeforeClass
	public void TC102Data()
	{
		browserName = "chrome";
		LoginAS="User";
		testCaseName = "TC102";
		testDescription = "Add a newsletter with invalid values";
		category = "P2";
		authors = "Vignesh Mohan";
		dataSheetName = "TC102";
	}
	
	
	@Test(dataProvider="fetchData",groups="P2")
	public void runTC102(String subscriberEmail) throws Throwable 
	{
		new UserLandingPage(driver, test)
		.selectTheLanguage()
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")
		.clickLogin()
		.invalidAddNewsLetterSubscriber(subscriberEmail);
		
		
		
	
	}

}
