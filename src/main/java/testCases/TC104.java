package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC104 extends PHP_Wrapper
{
	@BeforeClass
	public void TC_104_Data()
	{
		browserName = "chrome";
		LoginAS="Admin";
		testCaseName = "TC104";
		testDescription = "Edit a customer profile with invalid values";
		category = "P2";
		authors = "Nithya";
		dataSheetName = "TC_001";
	}
	@Test(dataProvider="fetchData",groups="P2", dependsOnGroups="SignUp")
	public void testCase104(String fName, String lName, String pwd) throws InterruptedException
	{
		new AdminLoginPage(driver,test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickAccounts()
		.clickCustomers()
		.clickedit(fName)
		.checkWithoutFirstName(" ", lName,  pwd,"9088019998","Algeria")
		.checkWithoutCountrySelection(fName, lName,  pwd,"9088019998","Please Select")
		.checkWithoutLastName(fName, " " ,  pwd,"9088019998","india")
		.checkWithoutEmailID(fName, lName, " ", pwd,"9088019998","Algeria")
		
		.clickSubmit();
	}
	

}
