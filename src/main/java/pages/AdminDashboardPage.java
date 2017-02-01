package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminDashboardPage extends PHP_Wrapper{
	public AdminDashboardPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		/*if(!verifyTitle("Dashboard"))
		{
			reportStep("This is not Adminstrator Dashboard Page", "FAIL");
		
		}*/
	}

	public NewsLetterManagementPage click_Newsletter_Tab()
	{
		clickByLink("Newsletter");
		return new NewsLetterManagementPage(driver,test);
	}
}
