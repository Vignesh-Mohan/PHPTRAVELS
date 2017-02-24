package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;

import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC100 extends PHP_Wrapper {


	@BeforeClass
	public void TC100Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC100";
		testDescription = "Search for invalid coupon code";
		category = "P2";
		authors = "Vignesh Mohan";
		dataSheetName = "TC100";
	}
	
	
	@Test(dataProvider="fetchData",groups="P2")
	public void runTC100(String couponcode) throws Throwable 
	{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickCoupons()
		.clickSearch()
		.enterSearchByCodeName(couponcode)
		.clickGo()
		.verifyCouponCodewithName(couponcode);
		
	
	}

}
