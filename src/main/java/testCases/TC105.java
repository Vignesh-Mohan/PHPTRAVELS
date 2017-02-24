package testCases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;


import wrappers.PHP_Wrapper;

public class TC105 extends PHP_Wrapper {
@BeforeClass
public void setValues(){
	browserName = "chrome";
	testCaseName = "TC105";
	testDescription = "Add a new customer with invalid values";
	category = "P2";
	authors = "Manoj";
	LoginAS = "admin";
	dataSheetName = "TC001";
	
}
@Test(dataProvider="fetchData",groups="P2")
public void login(String username,String password) throws InterruptedException
{
	new AdminLoginPage(driver, test)
	.enterUsername(username)
	.enterPassowrd(password)
	.clickLogin()
	.clickAccounts()
	.clickCustomers()
	.clickAdd()
	.enterFirstName("test")
	.enterLastName("data")
	.enterEmailID("das@gmail.com")
	.enterPassword("123")
	.enterMobile("786549043")
	.selectCountry("United States")
	.enterAddress1("123 losangels")
	.clickInavlidSubmit();
}
}