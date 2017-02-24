package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC009 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_009_Data()
	{
		browserName = "chrome";
		LoginAS="User";
		testCaseName = "TC009";
		testDescription = "Logout the user account";
		category = "P1";
		authors = "Nithya";
		
	}
	@Test(groups="P1")
	public void testCase9() throws InterruptedException
	{
		new UserLandingPage(driver, test)
		.selectTheLanguage()
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")
		.clickLogin()
		.clickUserName()
		.logOut();
	}
	
}
