package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class UserNewsletterSubscriber extends PHP_Wrapper
{
	
	public UserNewsletterSubscriber (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		
		if(!verifyTitle("PHPTRAVELS | Travel Technology Partner"))
		{
			reportStep("This is not my PHP Travels Page","FAIL");
		}
		
		
	}	
		
		public UserSearchCarsPage clickCar() 
		{
			System.out.println("In Click Car page");
			clickByLink("Cars");
			return new UserSearchCarsPage(driver,test);
		}
		
		
	
	}
		
		
	
	
	

	

	
	

