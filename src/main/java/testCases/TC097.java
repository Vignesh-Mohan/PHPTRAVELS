package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC097 extends PHP_Wrapper{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC097";
		testDescription = "Edit the car field values with invalid values";
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
		.editACar()
		.enterCarName(" ")
		.updateCarDetails();
	}
}
