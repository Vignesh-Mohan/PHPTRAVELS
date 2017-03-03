package testCases;

import org.testng.annotations.Test;

import pages.UserLandingPage;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.annotations.BeforeClass;




import wrappers.PHP_Wrapper;


public class TC021 extends PHP_Wrapper {


	@BeforeClass
	public void TC021Data()
	{
		browserName = "chrome";
		LoginAS="user";
		testCaseName = "TC021";
		testDescription = "To verify whether the user is able to search for the available car using quick search";
		category = "P1";
		authors = "Vignesh Mohan";
		//dataSheetName = "";
	}
	
	
	@Test(groups="P1")
	public void runTC021() throws Throwable 
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
		
		String pickupdate = String.valueOf(ipickupdate);
		
		String dropoffdate = String.valueOf(ipickoffdate);
		
		System.out.println("Inside test method");
		new UserLandingPage(driver, test)
		.selectTheLanguage()
		.clickOnMyAccount()
		.clickOnLoginButton()
		.enterUsername("user@phptravels.com")
		.enterPassowrd("demouser")
		.clickLogin()
		.clickCars()
		.click_Pick_UP_Location()
		.select_Pick_UP_Location()
	//	.click_Drop_Off_Location()
		.click_Pick_Up_Date()
		.select_Pick_Up_Date(pickupdate)
		.select_Drop_Off_Time()
		.click_Drop_Off_Date()
		.select_Dop_Off_Date(dropoffdate)
		.click_Quick_Search()
		.viewACar();
		
		
		
	
		
		
	}

}
