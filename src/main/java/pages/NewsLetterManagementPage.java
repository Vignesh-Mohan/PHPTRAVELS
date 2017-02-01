package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class NewsLetterManagementPage extends PHP_Wrapper{
	public NewsLetterManagementPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Newsletter Management"))
		{
			reportStep("This is not NewsLetter Management Page", "FAIL");
		
		}
	}

	public NewsLetterManagementPage click_Newsletter_Tab()
	{
		clickByLink("Newsletter");
		return new NewsLetterManagementPage(driver,test);
	}
	
	public SendNewsLetterPage click_Send_NewsLetter_Button()
	{
		clickByXpath("//button[@class='btn btn-success']");
		return new SendNewsLetterPage(driver,test);
	}
	
	
}
