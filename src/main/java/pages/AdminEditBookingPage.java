package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class AdminEditBookingPage extends PHP_Wrapper {
	public AdminEditBookingPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Edit Booking")){
			reportStep("This is notEdit Booking page", "FAIL");
		}
		
	}
	public AdminEditBookingPage selectBookingStatus(String data)
	{
		selectVisibleTextByName("status", data);
		return this;	
	}
	public AdminBookingManagementPage clickUpdateBooking()
	{
		clickByXpath("//input[@type='submit']");
		return new AdminBookingManagementPage(driver, test);	
	}
	
	public AdminEditBookingPage changeTheBookingStatus(String status)
	{
		selectVisibleTextByName("status", status);
		System.out.println("Booking Status Updated to: "+status);
		return this;
	}
	
	public AdminEditBookingPage selectPaymentMode(String PaymentMode)
	{
		selectVisibleTextByXpath("//select[@name='paymethod']", PaymentMode);
		return this;
	}
	
}


