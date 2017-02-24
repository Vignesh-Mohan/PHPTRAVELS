package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC051 extends PHP_Wrapper{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC051";
		testDescription = "Adding a new Car";
		category = "P1";		
		authors = "satheesh";
		LoginAS = "Admin";
	}

	@Test(groups={"addCar","P1"})
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
		.enter_CarName("Rolls Royce")
		.enter_CarDescription("A luxurious Rolls Royce...")
		.select_Num_CarStars()
		.select_Num_Passengers()
		.select_Num_Doors()
		.select_TransmissionType()
		.select_Baggage()
		.select_AirportPickup()
		.select_CarType()
		.selectPickupLocation1 ()
		.selectDropOffLocation1 ()
		.enterPrice()
		.select_RelatedCars()
		.click_SubmitCar()
		.verifyNewlyAddedCarPresent("Rolls Royce");
	}
}
