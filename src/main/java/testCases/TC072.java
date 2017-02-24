package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;



import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC072 extends PHP_Wrapper {


	@BeforeClass
	public void TC072Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC072";
		testDescription = "To get the Execution time and the memory usage of the Newsletter management page for every action done in the page.";
		category = "P4";
		authors = "Vignesh Mohan";
		//dataSheetName = "";
	}
	
	
	@Test(groups="P4")
	public void runTC072() throws Throwable 
	{
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.click_Newsletter_Tab()
		.click_SearchSubscribers()
		.get_Executiontime_MemoryUsage();
		
		
		
	
	}

}
