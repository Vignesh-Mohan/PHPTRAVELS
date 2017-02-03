package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


import pages.AdminLoginPage;
import pages.PhpPage;
import wrappers.PHP_Wrapper;


public class TC_008 extends PHP_Wrapper {


	@BeforeClass
	public void TC_008_Data()
	{
		browserName = "chrome";
		LoginAS="user";
		testCaseName = "Delete NewsLetter Subscriber";
		testDescription = "PHP Travels";
		category = "Smoke";
		authors = "Vignesh Mohan";
		dataSheetName = "TC007";
	}
	String email ="GooodaGoooda@gmail.com";
	@Test

	public void runTest1() throws Throwable 
	{
		
		System.out.println("Inside test method");
		new PhpPage(driver,test)
		.addNewsLetterSubscriber(email);
		invokeApp("chrome", "admin");
		new AdminLoginPage(driver, test)
		.enter_Email("admin@phptravels.com")
		.enter_Password("demoadmin")
		.click_LoginButton()
		.click_Newsletter_Tab()
		.click_SearchSubscribers()
		.enter_SubscriberToSearch(email)
		.click_DelteSubscriber(email)
		.get_NoEntryConfirmation();
		
				
	}

}
