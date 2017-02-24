package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC069 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_069_Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC069";
		testDescription = "To edit a  newsletter subscriber";
		category = "P2";
		authors = "Nithya";
		//dataSheetName = "TC001";
	}
	@Test( groups="P2")
	public void testCase69() throws InterruptedException
	{
		new AdminLoginPage(driver,test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.click_Newsletter_Tab()
		.click_editIcon()
		.edit_Subscriber("user@phptravels.com")
		.select_Type("customers")
		.select_enable("Yes")
		.click_SaveReturn();
	}
		
	
}
