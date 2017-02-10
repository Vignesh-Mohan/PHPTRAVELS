package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminBookingManagementPage extends PHP_Wrapper
{
	public AdminBookingManagementPage(RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
	}
	
	public AdminBookingManagementPage viewInvoice()
	{
		switchToParentWindow();
		clickByXpath("//i[@class='fa fa-search-plus']");
		
		switchToLastWindow();
		return this;
	}
	
	public AdminBookingManagementPage getTotalAmount()
	{
		String TotalInvoiceAmount=getTextByXpath("//td[contains(.,'Total Amount')]/following-sibling::td");
		System.out.println("Total Invoice amount: " +TotalInvoiceAmount);
		
		return this;
	}
	
	public AdminBookingManagementPage editABooking()
	{
		
		clickByXpath("//i[@class='fa fa-edit']");
		return this;
	}
	
	public AdminBookingManagementPage clickOnUploadBasedUponCarName(String carName)
	{
		String CarNameXpath="\"//a[contains(.,'" + carName + "')]\"";
		String getCarName=getTextByXpath(CarNameXpath);
		if(getCarName.equals(carName))
		{
			System.out.println("The Car: "+carName+" taken for photo upload");
			
		}
		return this;
	}
	public AdminBookingManagementPage uploadImage()
	{
		
		return this;
	}
	public AdminBookingManagementPage clickSearchButton()
	{
		scrollDown();
		System.out.println("scrolled down");
		System.out.println("Click on Search button");
		clickByXpath("//a[contains(.,'Search')]");
		
		return this;
	}
	
	public AdminBookingManagementPage searchWithParticulars(String SearchKey)
	{
		System.out.println("Search with search key");
		enterByName("phrase", SearchKey);
		clickByXpath("//a[contains(.,'Go')]");
		return this;
	}
	
	public AdminBookingManagementPage searchWithAllFields()
	{
		System.out.println("Search with all fields");
		clickByXpath("//a[contains(.,'Go')]");
		return this;
	}
	
}
