package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;


public class TC_007 extends PHP_Wrapper {


	@BeforeClass
	public void TC_007_Data()
	{
		browserName = "chrome";
		LoginAS="admin";
		testCaseName = "Delete NewsLetter Subscriber";
		testDescription = "PHP Travels";
		category = "Smoke";
		authors = "Vignesh Mohan";
		dataSheetName = "TC007";
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
		.click_SearchSubscribers()
		.enter_SubscriberToSearch("kevin@gmail.com")
		.click_DelteSubscriber("kevin@gmail.com");
		
				
	}

}
