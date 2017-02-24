package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC055 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_055_Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC055";
		testDescription = "Upload a Car";
		category = "P2";
		authors = "Nithya";
		//dataSheetName = "TC001";
	}
	@Test(groups="P2")
	public void testCase55() throws InterruptedException, IOException
	{
		new AdminLoginPage(driver,test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.click_CarsTab()
		.clickOnSubCarMenu()
		.clickOnUploadLinkBasedOnCarName()
		.clickAddPhoto()
		.clickOnDropButton();
		
		
	}

}
