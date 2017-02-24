package testCases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;

import wrappers.PHP_Wrapper;

public class TC003 extends PHP_Wrapper {
@BeforeClass
public void setValues(){
	browserName = "chrome";
	testCaseName = "TC003";
	testDescription = "To To verify whether sign up fails when the user creates a password with less than 6 characters";
	category = "P2";
	authors = "Manoj";
	LoginAS = "user";
	dataSheetName = "TC001";
	
}
@Test(dataProvider="fetchData",groups="P2")
public void login(String username,String password) throws InterruptedException
{
	new UserLandingPage(driver, test)
	.selectTheLanguage()
	.clickOnMyAccount()
	.clickSignupLink()
	.enterFirstName("first")
	.enterLastName("test")
	.enterMobileNumber("6754328900")
	.enterEmailID("tyst12@gmail.com")
	.enterPassword("test1")
	.enterConfirmPassword("test1")
	.clickSignupInvalidCredentials();
	

}
}