package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminLoginPage extends PHP_Wrapper{
	public AdminLoginPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Administator Login"))
		{
			reportStep("This is not Adminstrator Login Page", "FAIL");
		
		}
	}

	public AdminLoginPage enter_Email(String data)
	{
		enterByName("email", data);
		return this;
	}
	
	public AdminLoginPage enter_Password(String data)
	{
		enterByName("password", data);
		return this;
	}
	
	public AdminDashboardPage click_LoginButton()
	{
		clickByXpath("//span[contains(text(),'Login')]");
		return new AdminDashboardPage(driver,test);
	}
}
