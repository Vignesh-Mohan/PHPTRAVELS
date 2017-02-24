package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class UserLoginPage extends PHP_Wrapper {
	public UserLoginPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Login")){
			reportStep("This is user login page", "FAIL");
		}
		
	}
	public UserLoginPage enterUsername(String data)
	{
		enterByXpath("//input[@name='username']",data );
		return this;
	}
	public UserLoginPage enterPassowrd(String data)
	{
		enterByXpath("//input[@name='password']",data );
		return this;
	}
	public UserAccountPage clickLogin() throws InterruptedException
	{
		clickByXpath("//button[@type='submit']");
		Thread.sleep(2000);
		return new UserAccountPage(driver, test);
	}
	public UserLoginPage invalidLogin() throws InterruptedException
	{
		clickByXpath("//button[@type='submit']");
		Thread.sleep(6000);
		verifyTextContainsByXpath("//div[contains(text(),'Invalid Email or Password')]", "Invalid Email or Password");
		return this;
	}
	
	
}
