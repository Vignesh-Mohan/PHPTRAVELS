package pages;


import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AddCarsManagementPage extends PHP_Wrapper{
	public AddCarsManagementPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Cars Management"))
		{
			reportStep("This is not Cars Management Page", "FAIL");
		
		}
	}

	public AdminAddCarPage click_AddCar()
	{
		clickByXpath("(//button[contains(text(),'Add')])");
		return new AdminAddCarPage(driver,test);
	}
	

	
}
