package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class SignUpPage extends PHP_Wrapper {
	
	static String UserFirstName, UserLastName;
	public SignUpPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Register")){
			reportStep("This is not SignUp Page", "FAIL");
		}
		
	}
public SignUpPage enterFirstName(String data)
{
	UserFirstName=data;
	enterByName("firstname", data);
	return this;
}
public SignUpPage enterLastName(String data)
{	UserLastName=data;
	enterByName("lastname", data);
	return this;
}
public SignUpPage enterMobileNumber(String data)
{
	enterByName("phone", data);
	return this;
}
public SignUpPage enterEmailID(String data)
{
	enterByName("email", data);
	return this;
}
public SignUpPage enterPassword(String data)
{
	enterByName("password", data);
	return this;
}
public SignUpPage enterConfirmPassword(String data)
{
	enterByName("confirmpassword", data);
	return this;
}
public UserAccountPage clickSignup() throws InterruptedException
{
	clickByXpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']");
	Thread.sleep(4000);
	return new UserAccountPage(driver, test);
}

public UserAccountPage clickiSignup() throws InterruptedException 
{
	clickByXpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']");
	reportStep("Potential Failure: Bug Mobile number field accepts characters","ERROR");
	Thread.sleep(4000);
	return new UserAccountPage(driver, test);
}
public SignUpPage clickSignupInvalidCredentials() throws InterruptedException
{
	clickByXpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']");
	Thread.sleep(2000);
	return this;
}

}
