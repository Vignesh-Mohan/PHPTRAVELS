package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminDashboardPage extends PHP_Wrapper{
	public AdminDashboardPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		/*if(!verifyTitle("Dashboard"))
		{
			reportStep("This is not Adminstrator Dashboard Page", "FAIL");
		
		}*/
	}

	public AdminNewsLetterManagementPage click_Newsletter_Tab()
	{
		clickByLink("Newsletter");
		return new AdminNewsLetterManagementPage(driver,test);
	}
	
	
	public AdminDashboardPage click_CarsTab() 
	{
		clickByXpath("( //i[@class='fa arrow'])[4]");
		return this;
	}
	
	public AddCarsManagementPage click_Cars()
	{
		clickByXpath(" (//a[contains(text(),'Cars')])[1]");
		return new AddCarsManagementPage(driver,test);
	}
	
	public AdminDashboardPage click_Accounts()
	{
		clickById("Accounts");
		return this;
	}
	
	
}
