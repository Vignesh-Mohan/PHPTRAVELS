package testCases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC089 extends PHP_Wrapper {
@BeforeClass
public void setValues(){
	browserName = "chrome";
	testCaseName = "TC089";
	testDescription = "To delete a particular Admin profile.";
	category = "P1";
	authors = "Manoj";
	LoginAS = "admin";
	dataSheetName = "TC001";
	
}
@Test(dataProvider="fetchData",groups={"deleteAdmin"},dependsOnGroups="editInvalidAdmin")
public void login(String username,String password) throws InterruptedException
{
	new AdminLoginPage(driver, test)
	.enterUsername(username)
	.enterPassowrd(password)
	.clickLogin()
	.clickAccounts()
	.clickAdmins()
	.clickDelete("get")
	.clickSearch()
	.enterSearch("get")
	.clickGo()
	.verifyAdmin("get");
}
}