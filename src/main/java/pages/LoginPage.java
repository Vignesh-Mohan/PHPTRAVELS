package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class LoginPage extends PHP_Wrapper
{
	
	public LoginPage (RemoteWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		/*if(verifyTitle("PHPTRAVELS | Travel Technology Partner")==true)
		{
			System.out.println("Page title equals");
		}*/
	}	
		
		public CarsListingPage clickCar() throws Throwable
		{
			System.out.println("In Click Car page");
			clickByLink("Cars");
			return new CarsListingPage(driver,test);
		}
	}
		
		
	
	
	

	

	
	

