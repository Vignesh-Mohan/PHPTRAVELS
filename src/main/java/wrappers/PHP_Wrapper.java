package wrappers;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class PHP_Wrapper extends GenericWrapper
{
	
	public static String browserName;
	public static String LoginAs;
	//public String LoginAs;
	public String dataSheetName;
	
/*	public PHP_Wrapper(RemoteWebDriver driver, ExtentTest test) 
	{
		super(driver,test);
		this.driver=driver;
		this.test=test;
		
	}*/
	

	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}

	@BeforeTest
	public void beforeTest()
	{
		
	}
	
	@BeforeMethod
	public void beforeMethod(){
		test = startTestCase(testCaseName, testDescription);
		test.assignCategory(category);
		test.assignAuthor(authors);
		
		invokeApp(browserName,LoginAs);
	}
		
	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	@AfterTest
	public void afterTest(){
		
	}
	
	@AfterMethod
	public void afterMethod(){
		endTestcase();
		quitBrowser();
		
	}
	
	/*@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}	
	*/
	

	
}
