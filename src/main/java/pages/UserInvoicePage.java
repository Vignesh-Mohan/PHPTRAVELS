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
		InvoiceNumber=getTextByXpath("//div[@class='col-md-6']//div[3]");
		InvoiceNumber=InvoiceNumber.substring(InvoiceNumber.indexOf("Code ")+5,InvoiceNumber.length());
		System.out.println("Invoice No. is:"+InvoiceNumber);
		Boolean StatusCheck=driver.findElement(By.xpath("//b[contains(.,'Reserved')]")).isDisplayed();
		
		if(StatusCheck==true)
		{
			System.out.println("Pay on Arrival is confirmed");
		}
		else
			System.out.println("Reservation might be on the status of Cancelled/Unpaid");
		
	//	checkAllDetails();
		
		return this;
	}
	
	
	
}
