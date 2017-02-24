package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC099 extends PHP_Wrapper {


	@BeforeClass
	public void TC099Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC099";
		testDescription = "Save the Coupon code with empty values";
		category = "P2";
		authors = "Vignesh Mohan";
		dataSheetName = "TC099";
	}
	
	
	@Test(dataProvider="fetchData",groups="P2")
	public void runTC099(String percentage,String maxusers, String couponcode) throws Throwable 
	{
		DateFormat dateformat = new SimpleDateFormat("dd//MM//yyyy");
		Date date = new Date();
		String currentdate = dateformat.format(date);
		System.out.println(currentdate);
		String pdate =currentdate.substring(0, 2);
		System.out.println(pdate);
		int ipdate = Integer.parseInt(pdate);
		
		int ipickupdate = ipdate +2;
		int ipickoffdate = ipdate +6;
		
		System.out.println(ipickupdate);
		System.out.println(ipickoffdate);
		
		String startdate = String.valueOf(ipickupdate);
		
		String expirydate = String.valueOf(ipickoffdate);
		
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickCoupons()
		.clickAdd()
		.enterPercentage(percentage)
		.enterMaxVal(maxusers)
		.selectStartDate(startdate)
		.selectEnddate(expirydate)
		.enterCouponCode(couponcode)
		.noCoupon();
		
	
	}

}
