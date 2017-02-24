package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC032 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_032_Data()
	{
		browserName = "chrome";
		LoginAS="User";
		testCaseName = "TC032";
		testDescription = "To verify whether the user is able to confirm booking without selecting the extras";
		category = "P1";
		authors = "Nithya";
		//dataSheetName = "TC001";
	}
	@Test(groups="P1")
	public void testCase32() throws InterruptedException
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
		.bookNow()
		.bookingSummaryConfirmationPage()
		.clickPayOnArrival();
		
		
	}

}
