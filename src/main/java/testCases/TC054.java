package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC054 extends PHP_Wrapper{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC054";
		testDescription = "Edit the Car";
		category = "P1";		
		authors = "satheesh";
		LoginAS = "Admin";
	}

	@Test(groups={"editCar","P1"}, dependsOnGroups="addCar")
	public void login() throws InterruptedException{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")		
		.clickLogin()	
		.clickOnCarsMenu()
		.clickOnSubCarMenu()
		.editACar()
		.ModifyStar()
		.enterPickUpLocation("Dubai")
		.enterDropOffLocation("Dubai")
		.enterPrice("500")
		.updateCarDetails();
	}

}
