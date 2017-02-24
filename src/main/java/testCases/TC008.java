package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC008 extends PHP_Wrapper{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC008";
		testDescription = "To verify whether the user is able to login with invalid credentials";
		category = "P1";
		
		authors = "satheesh";
		LoginAS = "user";
		dataSheetName = "TC008";
	}

	@Test(dataProvider="fetchData",groups="P1")
	public void login(String Email, String Password) throws InterruptedException{
		new UserLandingPage(driver, test)
		//.selectTheLanguage()
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername(Email)
		.enterPassowrd(Password)
		.invalidLogin();
	}
}
