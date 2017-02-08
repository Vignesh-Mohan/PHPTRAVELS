package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class UserPhpPage extends PHP_Wrapper
{
	
	public UserPhpPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		
		if(!verifyTitle("PHPTRAVELS | Travel Technology Partner"))
		{
			reportStep("This is not my PHP Travels Page","FAIL");
		}
		
		
	}	
		
		public UserCarsListingPage clickCar() 
		{
			System.out.println("In Click Car page");
			clickByLink("Cars");
			return new UserCarsListingPage(driver,test);
		}
		
		
		public UserPhpPage addNewsLetterSubscriber(String data)
		{
			enterById("exampleInputEmail1", data);
			actionClickElementUsingXpath("(//button[@type='submit'])[4]");
		
			return this;
		}
		
	}
		
		
	
	
	

	

	
	

