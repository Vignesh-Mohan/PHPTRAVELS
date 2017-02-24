package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC093 extends PHP_Wrapper{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC093";
		testDescription = "Search a car by passing invalid values";
		category = "P2";		
		authors = "satheesh";
		LoginAS = "user";
	}

	@Test(groups="P2")
	public void login() throws InterruptedException{
		new UserLandingPage(driver, test)
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")
		.clickLogin()
		.clickCars()
		.enterPickUpDate("2017/010/123")
		.verifyTextNoResults();
		
		}
}
