package testCases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC080 extends PHP_Wrapper {
@BeforeClass
public void setValues(){
	browserName = "chrome";
	testCaseName = "TC080";
	testDescription = "To delete a particular booking as a admin.";
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
	.clickOnBookingMenu()
	.deleteBooking("5263")
	.clickSearchButton()
	.searchWithParticulars("5263");
	
}
}