package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;



import pages.PhpPage;
import wrappers.PHP_Wrapper;


public class TC_001 extends PHP_Wrapper {


	@BeforeClass
	public void TC_001_Data()
	{
		browserName = "chrome";
		LoginAS="user";
		testCaseName = "Quick Search";
		testDescription = "PHP Travels";
		category = "Smoke";
		authors = "Vignesh Mohan";
		dataSheetName = "TC001";
	}
	
	@Test
	public void runTest1() throws Throwable 
	{
		System.out.println("Inside test method");
		new PhpPage(driver, test)
		.clickCar()
		.click_Pick_UP_Location()
		.select_Pick_UP_Location()
		.click_Drop_Off_Location()
		.click_Pick_Up_Date()
		.select_Pick_Up_Date("6")
		.select_Drop_Off_Time()
		.click_Drop_Off_Date()
		.select_Dop_Off_Date("15")
		.click_Quick_Search();
	
		
		
	}

}
