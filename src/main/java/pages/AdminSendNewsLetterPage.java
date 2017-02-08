package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminSendNewsLetterPage extends PHP_Wrapper{
	public AdminSendNewsLetterPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Send Newsletter"))
		{
			reportStep("This is not Send NewsLetter Page", "FAIL");
		
		}
	}

	public AdminSendNewsLetterPage click_Newsletter_Tab()
	{
		clickByLink("Newsletter");
		return new AdminSendNewsLetterPage(driver,test);
	}
	
	public AdminSendNewsLetterPage enter_Subject(String subject)
	{
		enterByName("subject", subject);
		return this;
	}
	
	public AdminSendNewsLetterPage enter_body(String body)
	{
		switchToFrame("//iframe[@class='cke_wysiwyg_frame cke_reset']");
		enterByXpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']", body);
		switchToDefaultContent();
		return this;
	}
	
	public AdminSendNewsLetterPage click_Send_Button()
	{
		clickByXpath("//button[@class='btn btn-primary btn-block']");
		return this;
	}
	
}
