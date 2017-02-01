package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class CarsListingPage extends PHP_Wrapper{
	public CarsListingPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Cars Listings"))
		{
			reportStep("This is not Cars Listing Page", "FAIL");
		
		}
	}

	public CarsListingPage clickStarGrade()
	{
		System.out.println("In CarListing Page");
		clickByXpath("(//div[@class='iradio_square-grey'])[3]");
		return this;
	}
		
	
	public CarsListingPage click_Pick_UP_Location()
	{
		
		clickByLink("Pick up Location");
		return this;
	}
	
	public CarsListingPage select_Pick_UP_Location()
	{
		clickByXpath("//div[contains(text(),'Nile Egypt')]");
		return this;
	}
	
	public CarsListingPage click_Drop_Off_Location()
	{
		clickByLink("Drop off Location");
		return this;
	}
	
	public CarsListingPage click_Pick_Up_Date()
	{
		clickByName("pickupDate");
		return this;
	}
	
	public CarsListingPage select_Pick_Up_Date(String dateVal)
	{
		daysPicker_UsingXpath("(//div[@class='datepicker-days']/table)", dateVal);
		return this;
	}
	
	public CarsListingPage click_Drop_Off_Date()
	{
		clickByName("dropoffDate");
		return this;
	}
	
	
	
	public CarsListingPage select_Dop_Off_Date(String dateVal)
	{
		// for selecting month
		
		daysPicker_UsingXpath("(//div[@class='datepicker-days']/table)[2]", dateVal);
		return this;
	
	}
	
	public CarsListingPage select_Drop_Off_Time()
	{
		selectIndextByName("dropoffTime", "07:00");
		return this;
	}
	public CarsListingPage  click_Quick_Search()
	{
		clickByXpath("(//button[contains(text(),'Search')])[1]");
		return this;
	}
	
	public CarsListingPage click_Price_Range()
	{
		action_MoveElement_UsingXpath("(//div[@class='slider-handle round'])[2]", -131, 962);
		return this;
		
	}
	
	public CarsListingPage click_Car_Type()
	{
		clickByXpath("(//div[@class='iradio_square-grey'])[8]");
		return this;
		
	}
	
	public CarsListingPage click_Airport_Pickup(String Val)
	{
		selectVisibleTextByName("pickup", Val);
		return this;
	}
	
	public CarsListingPage click_Filter_Search()
	{
		clickById("searchform");
		return this;
	}

}
