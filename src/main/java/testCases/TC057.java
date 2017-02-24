package testCases;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC057 extends PHP_Wrapper {
@BeforeClass
public void setValues(){
	browserName = "chrome";
	testCaseName = "TC057";
	testDescription = "Add a new Coupon code";
	category = "P2";
	authors = "Manoj";
	LoginAS = "admin";
	dataSheetName = "TC001";
	
}
@Test(dataProvider="fetchData",groups={"addCoupon"})
public void login(String username,String password) throws InterruptedException
{
	
	DateFormat dateformat = new SimpleDateFormat("dd//MM//yyyy");
	Date date = new Date();
	String currentdate = dateformat.format(date);
	System.out.println(currentdate);
	String pdate =currentdate.substring(0, 2);
	System.out.println(pdate);
	int ipdate = Integer.parseInt(pdate);
	
	int ipickupdate = ipdate +2;
	int ipickoffdate = ipdate +3;
	
	System.out.println(ipickupdate);
	System.out.println(ipickoffdate);
	
	String startdate = String.valueOf(ipickupdate);
	
	String enddate = String.valueOf(ipickoffdate);
	
	new AdminLoginPage(driver, test)
	.enterUsername(username)
	.enterPassowrd(password)
	.clickLogin()
	.clickCoupons()
	.clickAdd()
	.enterPercentage("60")
	.enterMaxVal("6")
	.clickGenerate()
	.selectStartDate(startdate)
	.selectEnddate(enddate)
	.assignToCars("Kia Pacanto 2014")
	.clickSubmit()
	.clickSearch()
	.enterSearchByCode()
	.clickGo()
	.verifyCouponCode();
}
}