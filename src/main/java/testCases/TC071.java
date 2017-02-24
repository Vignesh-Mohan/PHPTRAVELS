package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC071 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_071_Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC071";
		testDescription = "To delete a newsletter subscriber";
		category = "P1";
		authors = "Nithya";
		dataSheetName = "TC103";
	}
	@Test(dataProvider="fetchData",dependsOnGroups={"Newsletter"})
	public void testCase71(String subscriberEmail,
			String changedSubscriberEmail) throws InterruptedException
	{
		new AdminLoginPage(driver,test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.click_Newsletter_Tab()
		.click_DelteSubscriber(changedSubscriberEmail);
		
	}

}
