package testCases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;


import wrappers.PHP_Wrapper;

public class TC098 extends PHP_Wrapper {
@BeforeClass
public void setValues(){
	browserName = "chrome";
	testCaseName = "TC098";
	testDescription = "Add a coupon code with long values";
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
	.clickCoupons()
	.clickAdd()
	.selectStartDate("17")
	.selectEnddate("19")
	.selectStatus("Disable")
	.enterPercentage("7")
	.enterMaxVal("3")
	.enterCouponCode("tWdSp23145778ThD")
	.clickSubmit()
	.verifyCouponCodewithName("tWdSp23145778ThD");

}
}