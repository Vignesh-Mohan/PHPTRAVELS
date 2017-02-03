package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class PhpPage extends PHP_Wrapper
{
	
	public PhpPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		
		if(!verifyTitle("PHPTRAVELS | Travel Technology Partner"))
		{
			reportStep("This is not my PHP Travels Page","FAIL");
		}
		
		
	}	
		
		public CarsListingPage clickCar() 
		{
			System.out.println("In Click Car page");
			clickByLink("Cars");
			return new CarsListingPage(driver,test);
		}
		
		
		public PhpPage addNewsLetterSubscriber(String data)
		{
			enterById("exampleInputEmail1", data);
			action_clickElement_UsingXpath("(//button[@type='submit'])[4]");
		
			return this;
		}
		
	}
		
		
	
	
	

	

	
	

