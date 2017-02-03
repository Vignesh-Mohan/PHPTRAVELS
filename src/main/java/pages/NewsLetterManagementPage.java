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
	
	public NewsLetterManagementPage click_checkbox()
	{
		clickByXpath("(//ins[@class='iCheck-helper'])[2]");
		return this;
	}
	
	public NewsLetterManagementPage click_editIcon()
	{
		clickByXpath("(//i[@class='fa fa-edit'])[1]");
		return this;
	}
	
	public NewsLetterManagementPage edit_Subscriber(String data)
	{
		enterByXpath("(//*[@class='xcrud-input form-control'])[1]", data);
		return this;
	}
	
	public NewsLetterManagementPage select_Type(String Val)
	{
		selectVisibleByXpath("(//*[@class='xcrud-input form-control'])[2]", Val);
		return this;
	}
	
	public NewsLetterManagementPage select_enable(String Val)
	{
		selectVisibleByXpath("(//*[@class='xcrud-input form-control'])[3]", Val);
		return this;
	}
	
	public NewsLetterManagementPage get_Executiontime_MemoryUsage()
	{
		getTextByClass("xcrud-benchmark");
		return this;
	}
	
	public NewsLetterManagementPage click_SaveReturn()
	{
		clickByLink("Save & Return");
		return this;
	}
	
	public NewsLetterManagementPage click_View_NewsLetterSubscriber()
	{
		clickByXpath("(//*[@class='fa fa-search'])[2]");
		return this;
	}
	
	public NewsLetterManagementPage get_NewsLetterSubscriber()
	{
		getTextByClass("panel-body");
		return this;
	}

	public NewsLetterManagementPage click_returnToNewsLettepage()
	{
		clickByLink("Return");
		return this;
	}
	
	public NewsLetterManagementPage click_SearchSubscribers()
	{
		clickByLink("Search");
		return this;
	}
	
	public NewsLetterManagementPage enter_SubscriberToSearch(String data) throws InterruptedException
	{
		enterByXpath("(//input[@name='phrase'])", data);
		clickByLink("Go");
		Thread.sleep(2000);
		clickByXpath("(//input[@class='checkboxcls'])[1]");
		verify_Text_in_a_Table("//table[@class='xcrud-list table table-striped table-hover']",data);
		return this;
	}
	
	
	public NewsLetterManagementPage click_DelteSubscriber(String data)
	{
		clickColumnInATableWithAlert("//table[@class='xcrud-list table table-striped table-hover']","//i[@class='fa fa-times']",data);
		return this;
	}
	
	public NewsLetterManagementPage get_NoEntryConfirmation()
	{
		getTextByXpath("//td[contains(text(),'Entries not found.')]");
		return this;
	}
	
}
