package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.DataProvider;

import basket.DataInputProvider;



public class PHP_Wrapper extends GenericWrapper {
	
	public String browserName;
	public String dataSheetName,LoginAS;
	
	

	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}

	
	
	@BeforeMethod
	public void beforeMethod(){
		test = startTestCase(testCaseName, testDescription);
		test.assignCategory(category);
		test.assignAuthor(authors);
		invokeApp(browserName,LoginAS);
	}
		
	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	
	
	@AfterMethod
	public void afterMethod(){
		endTestcase();
	//	quitBrowser();
		
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}	
	
	
}






