package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC033 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_033_Data()
	{
		browserName = "chrome";
		LoginAS="User";
		testCaseName = "TC033";
		testDescription = "To verify whether the user is able to select pay on arrival";
		category = "P1";
		authors = "Nithya";
		//dataSheetName = "TC001";
	}
	@Test(groups="P1")
	public void testCase33() throws InterruptedException
	{
		new UserLandingPage(driver, test)
		.selectTheLanguage()
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")
		.clickLogin()
		.clickCars()
		.click_Pick_UP_Location()
		.select_Pick_UP_Location()
		//.click_Drop_Off_Location()
		//.select_drop_Off_Location()
		.click_Quick_Search()
		.viewACar()
		.confirmBooking()
		.addToWishList()
		.bookNow()
		.bookingSummaryConfirmationPage()
		.clickPayOnArrival();
		
		
	}
}
