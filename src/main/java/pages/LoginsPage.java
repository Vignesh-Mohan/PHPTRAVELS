package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class LoginsPage extends PHP_Wrapper
{
	
	public LoginsPage (RemoteWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		if(!verifyTitle("PHPTRAVELS | Travel Technology Partner"))
		{
			reportStep("This is not my PHP Travels Page","FAIL");
		}
		
		
	}	
		
		public CarsListingPage clickCar() throws Throwable
		{
			System.out.println("In Click Car page");
			clickByLink("Cars");
			return new CarsListingPage(driver,test);
		}
	}
		
		
	
	
	

	

	
	

