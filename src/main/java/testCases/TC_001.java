package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginsPage;
import wrappers.PHP_Wrapper;


public class TC_001 extends PHP_Wrapper {


	@BeforeClass
	public void TC_001_Data()
	{
		browserName = "chrome";
		LoginAS="user";
		testCaseName = "Login";
		testDescription = "PHP Travels";
		category = "smoke";
		authors = "PHP";
		dataSheetName = "TC001";
	}
	
	@Test
	public void runTest1() throws Throwable 
	{
		System.out.println("Inside test method");
		new LoginsPage(driver, test)
		.clickCar()
		.clickStarGrade();
	
		
		
	}

}
