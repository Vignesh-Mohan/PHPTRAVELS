package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;


public class TC_003 extends PHP_Wrapper {


	@BeforeClass
	public void TC_003_Data()
	{
		browserName = "chrome";
		LoginAS="admin";
		testCaseName = "Admin Login";
		testDescription = "PHP Travels";
		category = "Smoke";
		authors = "Vignesh Mohan";
		dataSheetName = "TC003";
	}
	
	@Test
	public void runTest1() throws Throwable 
	{
		System.out.println("Inside test method");
		new AdminLoginPage(driver,test)
		.enter_Email("admin@phptravels.com")
		.enter_Password("demoadmin")
		.click_LoginButton()
		.click_Newsletter_Tab()
		.click_Send_NewsLetter_Button()
		.enter_Subject("Heloooo!!!! PHP Travels Users!")
		.enter_body(" Hi! EveryBody,  Greeting from PHP Travels, This is to inform you that we are pleased with your support, so we are giving you Compliment of 75% discount to your next bookings")
		.click_Send_Button();
				
		
				
	}

}
