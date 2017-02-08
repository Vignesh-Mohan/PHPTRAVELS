package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


import pages.AdminLoginPage;

import wrappers.PHP_Wrapper;


public class TC_008 extends PHP_Wrapper {


	@BeforeClass
	public void TC_008_Data()
	{
		browserName = "chrome";
		LoginAS="admin";
		testCaseName = "Add NewsLetter Subscriber";
		testDescription = "PHP Travels";
		category = "Smoke";
		authors = "Vignesh Mohan";
		dataSheetName = "TC008";
	}
	String carname ="Vicky Lambourgini";
	@Test

	public void runTest1() throws Throwable 
	{
		
		/*System.out.println("Inside test method");
		new PhpPage(driver,test)
		.addNewsLetterSubscriber(email);
		invokeApp("chrome", "admin");*/
		new AdminLoginPage(driver, test)
		.enter_Email("admin@phptravels.com")
		.enter_Password("demoadmin")
		.click_LoginButton()
		.click_CarsTab()
		.click_Cars()
		.click_AddCar()
		.click_PolicyTab()
		.select_PaymentOptions()
		.enter_PolicyAndTerms()
		.click_GeneralTab()
		.enter_CarName(carname)
		.enter_CarDescription(" Vick DeLorean is used to Time Travel. You go to the future or to the past... in the time continuum")
		.select_Num_CarStars()
		.select_Num_Doors()
		.select_Num_Passengers()
		.select_TransmissionType()
		.select_Baggage()
		.select_AirportPickup()
		.select_CarType()
		.selectPickupLocation1()
		.selectDropOffLocation1()
		.enterPrice()
		.select_RelatedCars()
		.click_SubmitCar()
		.verify_addedCar(carname);
		
		
		
		
		
				
	}

}
