package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class CarsListingPage extends PHP_Wrapper{
	public CarsListingPage (RemoteWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		/*if(!verifyTitle("Cars Listings"))
		{
			reportStep("This is not Cars Listing Page", "FAIL");
		
		}*/
	}

	public CarsListingPage clickStarGrade()
	{
		System.out.println("In CarListing Page");
		clickByXpath("(//div[@class='iradio_square-grey'])[3]");
		return this;
	}
		
	
	public CarsListingPage click_Pick_UP_Location()
	{
		System.out.println("In CarListing Page");
		clickByLink("Pick up Location");
		return this;
	}
}
