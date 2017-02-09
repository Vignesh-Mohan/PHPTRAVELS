package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class UserCarsListingPage extends PHP_Wrapper{
	public UserCarsListingPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Cars Listings"))
		{
			reportStep("This is not Cars Listing Page", "FAIL");
		
		}
	}

	public UserCarsListingPage clickStarGrade()
	{
		System.out.println("In CarListing Page");
		clickByXpath("(//div[@class='iradio_square-grey'])[3]");
		return this;
	}
		
	
	public UserCarsListingPage click_Pick_UP_Location()
	{
		
		clickByLink("Pick up Location");
		return this;
	}
	
	public UserCarsListingPage select_Pick_UP_Location()
	{
		clickByXpath("//div[contains(text(),'London')]");
		return this;
	}
	
	public UserCarsListingPage click_Drop_Off_Location()
	{
		clickByLink("Drop off Location");//changes by NA
		return this;
	}
	
	public UserCarsListingPage click_Pick_Up_Date() throws InterruptedException
	{
		Thread.sleep(1000);
		clickByName("pickupDate");
		return this;
	}
	
	public UserCarsListingPage select_Pick_Up_Date(String dateVal)
	{
		daysPickerUsingXpath("(//div[@class='datepicker-days']/table)", dateVal);
		return this;
	}
	
	public UserCarsListingPage click_Drop_Off_Date()
	{
		clickByName("dropoffDate");
		return this;
	}
	
	
	
	public UserCarsListingPage select_Dop_Off_Date(String dateVal)
	{
		// for selecting month
		
		daysPickerUsingXpath("(//div[@class='datepicker-days']/table)[2]", dateVal);
		return this;
	
	}
	
	public UserCarsListingPage select_Drop_Off_Time()
	{
		selectIndextByName("dropoffTime", "07:00");
		return this;
	}
	public UserCarsListingPage  click_Quick_Search()
	{
		clickByXpath("(//button[contains(text(),'Search')])[1]");
		return this;
	}
	
	public UserCarsListingPage click_Price_Range()
	{
		actionMoveElementUsingXpath("(//div[@class='slider-handle round'])[2]", -131, 962);
		return this;
		
	}
	
	public UserCarsListingPage click_Car_Type()
	{
		clickByXpath("(//div[@class='iradio_square-grey'])[8]");
		return this;
		
	}
	
	public UserCarsListingPage click_Airport_Pickup(String Val)
	{
		selectVisibleTextByName("pickup", Val);
		return this;
	}
	
	public UserCarsListingPage click_Filter_Search()
	{
		clickById("searchform");
		return this;
	}

}
