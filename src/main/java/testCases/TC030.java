package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC030 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_030_Data()
	{
		browserName = "chrome";
		LoginAS="User";
		testCaseName = "TC030";
		testDescription = "Book a car and confirm";
		category = "P1";
		authors = "Nithya";
		//dataSheetName = "TC001";
	}
	@Test(groups="P1")
	public void testCase30() throws InterruptedException
	{
		String InvoiceNumber="Invoice Number : 15 Booking Code 0678";
		//InvoiceNumber=driver.findElement(By.xpath("//div[@class='col-md-6']//div[3]")).getText();
		InvoiceNumber=InvoiceNumber.substring(InvoiceNumber.indexOf("Code ")+5,InvoiceNumber.length());
		System.out.println("Invoice # "+InvoiceNumber);
		
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
