package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC067 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_067_Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC067";
		testDescription = "To verify the functionality of Send Newsletter to Everyone";
		category = "P1";
		authors = "Nithya";
		//dataSheetName = "TC001";
	}
	@Test(groups="P1")
	public void testCase67() throws InterruptedException
	{
		new AdminLoginPage(driver,test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.click_Newsletter_Tab()
		.click_Send_NewsLetter_Button()
		.enter_Subject("Hurry Up New Deals On Rise")
		.enter_body("Hi, Hurry Up New Deals On Rise")
		.click_Send_Button();
		
		
		
	}

}
