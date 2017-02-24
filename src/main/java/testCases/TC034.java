package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC034 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_034_Data()
	{
		browserName = "chrome";
		LoginAS="User";
		testCaseName = "TC034";
		testDescription = "To verify whether the information given while booking an the info shown in invoice are the same ";
		category = "P1";
		authors = "Nithya";
		//dataSheetName = "TC001";
	}
	@Test(groups="P1")
	public void testCase34() throws InterruptedException
	{
		/*String str="chk(eer)";
		
		String partialRGB = str.substring(str.indexOf("(") + 1, str.indexOf(")"));;
		partialRGB=partialRGB.trim();
		partialRGB=partialRGB.replace(",", "");
		int RBG_Number=Integer.valueOf(partialRGB);*/
		
		
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
		.addBabySeat()
		.addChildSeat()
		.addGPS()
		.addAdditionalDriver()
		.bookingSummaryConfirmationPage()
		.clickPayOnArrival()
		.checkReservedStatus();
		
	}

}
