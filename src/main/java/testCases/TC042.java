package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC042 extends PHP_Wrapper{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC042";
		testDescription = "Remove the car from the Wish list under Whishlist tab of useraccount";
		category = "P1";		
		authors = "satheesh";
		LoginAS = "user";
	}

	@Test(groups="P1")
	public void login() throws InterruptedException{
		new UserLandingPage(driver, test)
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")		
		.clickLogin()	
		.clickWhishlist()
		.clickRemoveButton();
		}
}
