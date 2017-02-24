package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;
import pages.UserLandingPage;

import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC103 extends PHP_Wrapper {


	@BeforeClass
	public void TC103Data()
	{
		browserName = "chrome";
		LoginAS="User";
		testCaseName = "TC103";
		testDescription = "Edit a NewsletterSubscriber  with invalid values";
		category = "P2";
		authors = "Vignesh Mohan";
		dataSheetName = "TC103";
	}
	
	
	@Test(dataProvider="fetchData",groups={"P2","Newsletter"})
	public void runTC103(String subscriberEmail, String changedSubscriberEmail) throws Throwable 
	{
		new UserLandingPage(driver, test)
		.selectTheLanguage()
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")
		.clickLogin()
		.addNewsLetterSubscriber(subscriberEmail);
		closeBrowser();
		invokeApp("chrome", "Admin", false);
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.click_Newsletter_Tab()
		.click_SearchSubscribers()
		.enter_SubscriberToSearch(subscriberEmail)
		.click_editIcon()
		.edit_Subscriber(changedSubscriberEmail);
		
		
		
	
	}

}
