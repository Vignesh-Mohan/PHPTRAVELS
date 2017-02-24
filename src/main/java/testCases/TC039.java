package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC039 extends PHP_Wrapper{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC039";
		testDescription = "Adding car to Wish list";
		category = "P1";		
		authors = "satheesh";
		LoginAS = "user";
	}

	@Test(groups="P1")
	public void login() throws InterruptedException{
		new UserLandingPage(driver, test)
		//.selectTheLanguage()
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")		
		.clickLogin()
		.clickCars()
		.click_Pick_UP_Location()
		.select_Pick_UP_Location()
		//.click_Drop_Off_Location()
		.select_Drop_Off_Time()	
		.click_Quick_Search()
		.viewACar()
		.addToWishList()	
		.verifyTextAfterAddingCarToWhislist();
	}
}
