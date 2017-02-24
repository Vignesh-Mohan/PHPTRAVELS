package testCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.UserLandingPage;
import wrappers.PHP_Wrapper;

public class TC094 extends PHP_Wrapper{
	@BeforeClass
	public void setValues(){
		browserName = "chrome";
		testCaseName = "TC094";
		testDescription = "Book a car by passing invalid values";
		category = "P2";		
		authors = "satheesh";
		LoginAS = "user";
	}

	@Test(groups="P2")
	public void login() throws InterruptedException{
		
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String currentdate = dateformat.format(date);
		System.out.println(currentdate);
		String pdate =currentdate.substring(0, 2);
		System.out.println(pdate);
		int ipdate = Integer.parseInt(pdate);
		
		int ipickupdate = ipdate +2;
		int ipickoffdate = ipdate +6;
		
		
		System.out.println(ipickupdate);
		System.out.println(ipickoffdate);
		
		String pickupdate = String.valueOf(ipickupdate);
		
		
		
		
		new UserLandingPage(driver, test)
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")		
		.clickLogin()	
		.clickCars()
		.click_Pick_UP_Location()
		.select_Pick_UP_Location()
		//.click_Drop_Off_Location()
		.select_Pick_Up_Date(pickupdate)
		.select_Drop_Off_Time()	
		.click_Quick_Search()
		.viewACar()
		.enterPickUpDate("#$%^&*")
		.verifyErrorForDate();
		}
}
