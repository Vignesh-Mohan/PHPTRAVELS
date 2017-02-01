package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import pages.LoginsPage;
import wrappers.PHP_Wrapper;


public class TC_002 extends PHP_Wrapper {


	@BeforeClass
	public void TC_002_Data()
	{
		browserName = "chrome";
		LoginAS="user";
		testCaseName = "Filter Search";
		testDescription = "PHP Travels";
		category = "Smoke";
		authors = "Vignesh Mohan";
		dataSheetName = "TC001";
	}
	
	@Test
	public void runTest1() throws Throwable 
	{
		System.out.println("Inside test method");
		new LoginsPage(driver, test)
		.clickCar()
		.clickStarGrade()
		.click_Car_Type()
		.click_Price_Range()
		.click_Airport_Pickup("Yes")
		.click_Filter_Search();
		
		
		
		
	}

}
