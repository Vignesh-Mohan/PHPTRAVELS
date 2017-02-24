package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;

import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC101 extends PHP_Wrapper {


	@BeforeClass
	public void TC101Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC101";
		testDescription = "Search for empty coupon code";
		category = "P2";
		authors = "Vignesh Mohan";
		//dataSheetName = "";
	}
	
	
	@Test(groups="P2")
	public void runTC101() throws Throwable 
	{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickCoupons()
		.clickSearch()
		.enterSearchByCodeName("")
		.clickGo()
		.verifyCouponCodewithName("");
		
	
	}

}
