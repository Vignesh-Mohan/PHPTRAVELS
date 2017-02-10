package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminCarsManagementPage extends PHP_Wrapper 
{
	public AdminCarsManagementPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;		
	}
	
	public AdminEditACarPage editACar()
	{
		clickByXpath("//i[@class='fa fa-edit']");
		System.out.println("Edit button clicked");
		return new AdminEditACarPage(driver,test);
	}
	
	public AdminCarsManagementPage clickSearchButton()
	{
		scrollDown();
		System.out.println("scrolled down");
		System.out.println("Click on Search button");
		clickByXpath("//a[contains(.,'Search')]");
		
		return this;
	}
	
	public AdminCarsManagementPage searchWithParticulars(String SearchKey)
	{
		System.out.println("Search with search key");
		enterByName("phrase", SearchKey);
		clickByXpath("//a[contains(.,'Go')]");
		return this;
	}
	public AdminAddCarPage click_AddCar()
	{
		clickByXpath("(//button[contains(text(),'Add')])");
		return new AdminAddCarPage(driver,test);
	}
}
