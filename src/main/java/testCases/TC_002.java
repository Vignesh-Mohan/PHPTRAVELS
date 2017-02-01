package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginsPage;
import wrappers.PHP_Wrapper;


public class TC_002 extends PHP_Wrapper {


	@BeforeClass
	public void TC_001_Data()
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
		.click_Airport_Pickup("1")
		.click_Filter_Search();
		
		
		
		
	}

}
