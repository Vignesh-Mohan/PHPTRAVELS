package testCases;

import org.testng.annotations.Test;

import pages.UserLandingPage;

import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC022 extends PHP_Wrapper {


	@BeforeClass
	public void TC022Data()
	{
		browserName = "chrome";
		LoginAS="user";
		testCaseName = "TC022";
		testDescription = "To verify whether the user is able to search for the available car using filter search";
		category = "P1";
		authors = "Vignesh Mohan";
		dataSheetName = "";
	}
	
	
	@Test
	public void runTC022() throws Throwable 
	{
			
		System.out.println("Inside test method");
		new UserLandingPage(driver, test)
		.selectTheLanguage()
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")
		.clickLogin()
		.clickCars()
		.clickStarGrade()
		.click_Price_Range()
		.click_Car_Type()
		.click_Airport_Pickup("No")
		.click_Filter_Search()
		.viewACar();
		
		
		
	
		
		
	}

}
