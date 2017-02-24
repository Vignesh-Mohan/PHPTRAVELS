package testCases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC090 extends PHP_Wrapper {
@BeforeClass
public void setValues(){
	browserName = "chrome";
	testCaseName = "TC090";
	testDescription = "To add a new Admin";
	category = "P1";
	authors = "Manoj";
	LoginAS = "admin";
	dataSheetName = "TC001";
	
}
@Test(dataProvider="fetchData",groups={"addAdmin"})
public void login(String username,String password) throws InterruptedException
{
	new AdminLoginPage(driver, test)
	.enterUsername(username)
	.enterPassowrd(password)
	.clickLogin()
	.clickAccounts()
	.clickAdmins()
	.clickAdd()
	.enterFirstName("get")
	.enterLastName("name")
	.enterEmailID(generateUniqueMailIDs())
	.enterPassword("Test@12345")
	.enterMobile("7689543210")
	.selectCountry("united States")
	.enterAddress1("12 los vegas")
	.enterAddress2("go to test")
	.selectStatus("Disabled")
	.emailNewsLetterSubscriber()
	.selectEditModules("All")
	.selectAddModules("All")
	.clickSubmit()
	.clickSearch()
	.enterSearch("get")
	.clickGo()
	.verifyAdmin("get");
}
}