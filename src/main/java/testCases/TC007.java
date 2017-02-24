package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC007 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_007_Data()
	{
		browserName = "chrome";
		LoginAS="User";
		testCaseName = "TC007";
		testDescription = "To verify whether the user is able to login with valid credentials";
		category = "P1";
		authors = "Nithya";
		//dataSheetName = "TC001";
	}
	
	@Test(groups="P1")
	public void testCase7() throws InterruptedException
	{
		new UserLandingPage(driver, test)
		.selectTheLanguage()
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")
		.clickLogin();
		
	}

}
