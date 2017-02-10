package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class UserInvoicePage extends PHP_Wrapper
{
	public static String InvoiceNumber;
	public UserInvoicePage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
	}
	
	public UserInvoicePage clickPayOnArrival()
	{
		System.out.println("Step 6 : Click for Pay On Arrival");
		acceptAnAlertAfterClickByXpath("//button[contains(.,'Pay on Arrival')]");
		
		return this;
	}
	
	public UserInvoicePage checkReservedStatus()
	{
		InvoiceNumber=getTextByXpath("//strong[contains(.,'Booking Code')]");
		System.out.println("Invoice Number:" +InvoiceNumber);
		Boolean StatusCheck=driver.findElement(By.xpath("//b[contains(.,'Reserved')]")).isDisplayed();
		
		if(StatusCheck==true)
			System.out.println("Pay on Arrival is confirmed");
		else
			System.out.println("Reservation might be on the status of Cancelled/Unpaid");
		
		return this;
	}
	
}
