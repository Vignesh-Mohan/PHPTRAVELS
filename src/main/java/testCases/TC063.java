package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC063 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_063_Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC063";
		testDescription = "Sort the Coupon codes";
		category = "P2";
		authors = "Nithya";
		//dataSheetName = "TC001";
	}
	@Test(groups="P2")
	public void testCase63() throws InterruptedException
	{
		new AdminLoginPage(driver,test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickCoupons()
		.sortCouponCode();
		
	}
	

}
