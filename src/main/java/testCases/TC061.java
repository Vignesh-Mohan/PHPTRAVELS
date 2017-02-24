package testCases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC061 extends PHP_Wrapper {
@BeforeClass
public void setValues(){
	browserName = "chrome";
	testCaseName = "TC061";
	testDescription = "Disable the Coupon code";
	category = "P2";
	authors = "Manoj";
	LoginAS = "admin";
	dataSheetName = "TC001";
	
}
@Test(dataProvider="fetchData",groups={"disableCoupon"},dependsOnGroups="searchCoupon")
public void login(String username,String password) throws InterruptedException
{
	new AdminLoginPage(driver, test)
	.enterUsername(username)
	.enterPassowrd(password)
	.clickLogin()
	.clickCoupons()
	.clickEdit()
	.selectEditStatus("Disable")
	.clickEditUpdate();

}
}