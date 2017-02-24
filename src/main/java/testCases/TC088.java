package testCases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC088 extends PHP_Wrapper {
@BeforeClass
public void setValues(){
	browserName = "chrome";
	testCaseName = "TC088";
	testDescription = "To delete a particular booking as a admin.";
	category = "P1";
	authors = "Manoj";
	LoginAS = "admin";
	dataSheetName = "TC001";
	
}
@Test(dataProvider="fetchData",groups={"editAdmin"},dependsOnGroups="addAdmin")
public void login(String username,String password) throws InterruptedException
{
	new AdminLoginPage(driver, test)
	.enterUsername(username)
	.enterPassowrd(password)
	.clickLogin()
	.clickAccounts()
	.clickAdmins()
	.clickedit("get")
	.enterFirstName("test")
	.enterPassword("test212345")
	.clickSubmit()
	.clickSearch()
	.enterSearch("test")
	.clickGo()
	.verifyAdmin("test");
}
}