package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC096 extends PHP_Wrapper{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName= "TC096";
		testDescription = "Add a car with invalid values";
		category = "P2";		
		authors = "satheesh";
		LoginAS = "Admin";
	}

	@Test(groups="P2")
	public void login() throws InterruptedException{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")		
		.clickLogin()	
		.clickOnCarsMenu()
		.clickOnSubCarMenu()
		.click_AddCar()
		.click_PolicyTab()
		.select_PaymentOptions()
		.enter_PolicyAndTerms()
		.click_GeneralTab()
		.enter_CarName(" ")
		.clickSubmitCarwithemptyCarName();
	}
}
