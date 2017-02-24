package testCases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC001 extends PHP_Wrapper
{
	
	@BeforeClass
	public void TC_001_Data()
	{
		
		browserName = "chrome";
		LoginAS="User";
		testCaseName = "TC001";
		testDescription = "To Verify whether the user is able to create a customer account using sign up";
		category = "P1";
		authors = "Nithya";
		dataSheetName = "TC_001";
	}
	
	@Test(dataProvider="fetchData", groups={"SignUp","P1"})
	public void testCase1(String fName, String lName, String pwd) throws InterruptedException
	{
		
		//String mobileNo=String.valueOf(Mobile);
		new UserLandingPage(driver, test)
		.selectTheLanguage()
		.clickOnMyAccount()
		.clickSignupLink()
		.enterFirstName(fName)
		.enterLastName(lName)
		.enterMobileNumber("9078588883")
		.enterEmailID(generateUniqueMailIDs())
		.enterPassword(pwd)
		.enterConfirmPassword(pwd)
		.clickSignup()
		.checkUserName();		
		
	}

}
