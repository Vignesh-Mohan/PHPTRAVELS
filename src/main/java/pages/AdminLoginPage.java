package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class AdminLoginPage extends PHP_Wrapper {
	public AdminLoginPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Administator Login")){
			reportStep("This is not admin login page", "FAIL");
		}
		
	}
	public AdminLoginPage enterUsername(String data)
	{
		enterByXpath("//input[@name='email']",data );
		return this;
	}
	public AdminLoginPage enterPassowrd(String data)
	{
		enterByXpath("//input[@name='password']",data );
		return this;
	}
	public AdminDashboardPage clickLogin() throws InterruptedException
	{
		clickByXpath("//button[@type='submit']");
		Thread.sleep(6000);
		return new AdminDashboardPage(driver,test);
	}
}
