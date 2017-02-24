package testCases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC058 extends PHP_Wrapper {
@BeforeClass
public void setValues(){
	browserName = "chrome";
	testCaseName = "TC058";
	testDescription = "Modify the Coupon code";
	category = "P2";
	authors = "Manoj";
	LoginAS = "admin";
	dataSheetName = "TC001";
	
}
@Test(dataProvider="fetchData",groups={"modifyCoupon"}, dependsOnGroups="addCoupon")
public void login(String username,String password) throws InterruptedException
{
	System.out.println("TC058");
	new AdminLoginPage(driver, test)
	.enterUsername(username)
	.enterPassowrd(password)
	.clickLogin()
	.clickCoupons()
	.clickEdit()
	.clickEditUpdate();

}
}