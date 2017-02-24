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
	public UserInvoicePage editedbookingSummaryConfirmationPage()
	{
		String confirmBookingAmount=getTextById("displaytotal");
		System.out.println("Amount in Booking Summary Page: "+confirmBookingAmount);
		
		
			clickByName("logged");
		
		return new UserInvoicePage(driver,test);
	}
	public UserPersonalInfoConfirmationPage enterCouponCode()
	{
		String code = AdminCouponCodePage.code;
		enterByXpath("//input[@class='RTL form-control coupon']",code);
		return this;
	}
	public UserPersonalInfoConfirmationPage clickApplyCoupon()
	{
		clickByXpath("//div[@class='col-md-4 go-left']/span[@class='btn btn-danger applycoupon']");
		return this;
	}
	public UserPersonalInfoConfirmationPage discountByCoupon()
	{
		verifyTextByXpath("//div[@class='alert alert-success']", "10% coupon discount has been applied to your booking! please continue by clicking book now to see the discounted price on invoice page.");
		return this;
	}
	public UserPersonalInfoConfirmationPage addBabySeat()
	{
		
		clickByXpathForSmartTextBox("//span/span[contains(.,'Yes')]");
		System.out.println("Baby Seat Added");
		return this;
	}
	public UserPersonalInfoConfirmationPage addChildSeat()
	{
		
		clickByXpathForSmartTextBox("(//span/span[contains(.,'Yes')])[2]");
		System.out.println("Child Seat Added");
		return this;
	}
	public UserPersonalInfoConfirmationPage addGPS()
	{
		
		clickByXpathForSmartTextBox("(//span/span[contains(.,'Yes')])[3]");
		System.out.println("GPS Added");
		return this;
	}
	public UserPersonalInfoConfirmationPage addAdditionalDriver()
	{
		
		clickByXpathForSmartTextBox("(//span/span[contains(.,'Yes')])[3]");
		System.out.println("Additional Driver Added");
		return this;
	}

}
