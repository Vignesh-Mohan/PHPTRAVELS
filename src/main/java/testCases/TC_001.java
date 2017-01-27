package testCases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import wrappers.GenericWrapper;
import wrappers.PHP_Wrapper;

public class TC_001 extends PHP_Wrapper {


	@BeforeClass
	public void TC_001_Data()
	{
		browserName = "chrome";
		LoginAs="Admin";
		testCaseName = "Login";
		testDescription = "Login to LeafTaps";
		category = "smoke";
		authors = "PHP";
		dataSheetName = "TC001";
	}
	
	@Test
	public void runTest1() 
	{
		System.out.println("Inside test method");
		new GenericWrapper(driver, test);
		//gw.invokeApp(browserName,"user");
		
	}

}
