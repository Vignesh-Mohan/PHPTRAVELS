package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC092 extends PHP_Wrapper{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC092";
		testDescription = "Book a car using Coupon code";
		category = "P1";		
		authors = "satheesh";
		LoginAS = "user";
	}

	@Test(groups={"bookACarUsingCoupon"},dependsOnGroups="modifyCoupon")
	public void login() throws InterruptedException{
		new UserLandingPage(driver, test)
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")		
		.clickLogin()	
		.clickCars()
		.click_Pick_UP_Location()
		.select_Pick_UP_Location()
		//.click_Drop_Off_Location()
		.select_Drop_Off_Time()	
		.click_Quick_Search()
		.viewACar()
		.bookNow()
		.enterCouponCode()
		.clickApplyCoupon()
		.discountByCoupon()
		.bookingSummaryConfirmationPage()
		.clickPayOnArrival()
		.checkReservedStatus();
		}
}
