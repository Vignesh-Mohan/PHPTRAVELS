package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC095 extends PHP_Wrapper{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC095";
		testDescription = "Edit the book a car page with invalid values";
		
		category = "P2";		
		authors = "satheesh";
		LoginAS = "Admin";
	}

	@Test(groups="P2")
	public void login() throws InterruptedException{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")		
		.clickLogin()	
		.clickOnBookingMenu()
		.editABooking()
		.selectBookingStatus("Paid")
		.clickUpdateBooking();
		
		
		}
}
