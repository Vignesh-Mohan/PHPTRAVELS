package pages;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class UserLandingPage extends PHP_Wrapper
{

	 public UserLandingPage(RemoteWebDriver driver, ExtentTest test) 
	 {
			this.driver = driver;
			this.test = test;
	 }
	 
	 
	 public UserLandingPage selectTheLanguage()
	 {
		 clickByClassName("dropdown-toggle");
		 clickById("en");
		 
		 return this;
	 }
	 
	 public UserLandingPage clickOnMyAccount()
	 {
		 clickByXpath("//i[@class='icon_set_2_icon-105']");
		 return this;
	 }
	 
	 public UserLoginPage clickOnLoginButton()
	 {
		 clickByXpath("//a[contains(text(),'Login')]");
		 return new UserLoginPage(driver,test);
	 }
	 public SignUpPage clickSignupLink()
		{
			clickByLink("Sign Up");
			return new SignUpPage(driver, test);
		}
	
}
