package testCases;

import org.testng.annotations.Test;


import pages.UserLandingPage;

import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC006 extends PHP_Wrapper {


	@BeforeClass
	public void TC006Data()
	{
		browserName = "chrome";
		LoginAS="user";
		testCaseName = "TC006";
		testDescription = "To verify whether sign up fails when the user enters characters in mobile number field";
		category = "P3";
		authors = "Vignesh Mohan";
		//dataSheetName = "";
	}
	
	
	@Test(groups="P3")
	public void runTC006() throws Throwable 
	{
		new UserLandingPage(driver, test)
		.selectTheLanguage()
		.clickOnMyAccount()
		.clickSignupLink()
		.enterFirstName("Vignesh")
		.enterLastName("Mohan")
		.enterEmailID("vick@yopmail.com")
		.enterPassword("test@123")
		.enterConfirmPassword("test@123")
		.enterMobileNumber("qwerty")
		.clickiSignup();
		
		
	
	}

}
