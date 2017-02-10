package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class UserPersonalInfoConfirmationPage extends PHP_Wrapper
{

	public UserPersonalInfoConfirmationPage(RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver = driver;
		this.test = test;
	
	}
	
	public UserInvoicePage bookingSummaryConfirmationPage()
	{
		String confirmBookingAmount=getTextById("displaytotal");
		System.out.println("Amount in Booking Summary Page: "+confirmBookingAmount);
		
		if(confirmBookingAmount.equals(UserViewCarsDetailsPage.Amount))
		{
			clickByName("logged");
		}
		else
			System.out.println("The Total Amount in Booking Summary: "+confirmBookingAmount + " doesn't equals the Actual Amount: " +UserViewCarsDetailsPage.Amount);
		return new UserInvoicePage(driver,test);
	}

}
