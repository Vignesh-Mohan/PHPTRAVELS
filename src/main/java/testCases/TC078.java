package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC078 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_078_Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC078";
		testDescription = "To edit the booking and changing the booking status to paid,unpaid,reserved,cancelled and update the booking.";
		category = "P1";
		authors = "Nithya";
		//dataSheetName = "TC001";
	}
	@Test(groups="P1")
	public void testCase78() throws InterruptedException
	{
		new AdminLoginPage(driver,test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickOnBookingMenu()
		.editABooking()
		.changeTheBookingStatus("Cancelled")
		.selectPaymentMode("Pay On Arrival")
		.clickUpdateBooking()
		.editABooking()
		.changeTheBookingStatus("Paid")
		.selectPaymentMode("Pay On Arrival")
		.clickUpdateBooking()
		.editABooking()
		.changeTheBookingStatus("Unpaid")
		.selectPaymentMode("Pay On Arrival")
		.clickUpdateBooking()
		.editABooking()
		.changeTheBookingStatus("Reserved")
		.selectPaymentMode("Pay On Arrival")
		.clickUpdateBooking();
	}

}
