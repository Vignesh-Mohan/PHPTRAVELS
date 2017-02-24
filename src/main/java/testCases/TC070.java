package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC070 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_070_Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC070";
		testDescription = "To view a newsletter subscriber";
		category = "P1";
		authors = "Nithya";
		//dataSheetName = "TC001";
	}
	@Test(groups="P1")
	public void testCase70() throws InterruptedException
	{
		new AdminLoginPage(driver,test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.click_Newsletter_Tab()
		.click_View_NewsLetterSubscriber()
		.click_returnToNewsLettepage();
	}
}
