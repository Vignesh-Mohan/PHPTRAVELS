package testCases;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import wrappers.PHP_Wrapper;

public class TC059 extends PHP_Wrapper {
@BeforeClass
public void setValues(){
	browserName = "chrome";
	testCaseName = "TC059";
	testDescription = "Delete a Coupon";
	category = "P1";
	authors = "Manoj";
	LoginAS = "admin";
	dataSheetName = "TC001";
	
}
@Test(dataProvider="fetchData",groups="P1")
public void login(String username,String password) throws InterruptedException
{
	DateFormat dateformat = new SimpleDateFormat("dd//MM//yyyy");
	Date date = new Date();
	String currentdate = dateformat.format(date);
	System.out.println(currentdate);
	String pdate =currentdate.substring(0, 2);
	System.out.println(pdate);
	int ipdate = Integer.parseInt(pdate);
	
	int ipickupdate ;
	int ipickoffdate;
	if(ipdate>=28)
	{
	 ipickupdate = ipdate;
	 ipickoffdate = ipdate;
	}else{

		ipickupdate = ipdate +2;
		ipickoffdate = ipdate +3;
	}
	
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
	.clickSubmit()
	.clickDelete()
	.clickSearch()
	.enterSearchByCode()
	.clickGo()
	.verifyCouponCode();
}
}
