package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;


public class TC_004 extends PHP_Wrapper {


	@BeforeClass
	public void TC_004_Data()
	{
		browserName = "chrome";
		LoginAS="admin";
		testCaseName = "Edit NewsLetter Subscriber";
		testDescription = "PHP Travels";
		category = "Smoke";
		authors = "Vignesh Mohan";
		dataSheetName = "TC004";
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
		.click_checkbox()
		.click_editIcon()
		.edit_Subscriber("Changeddata@yopmail.com")
		.select_Type("admin")
		.select_enable("Yes")
		.get_Executiontime_MemoryUsage()
		.click_SaveReturn();
		
				
	}

}
