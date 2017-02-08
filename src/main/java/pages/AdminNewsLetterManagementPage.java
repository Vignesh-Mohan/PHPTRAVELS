package pages;


import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminNewsLetterManagementPage extends PHP_Wrapper{
	public AdminNewsLetterManagementPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Newsletter Management"))
		{
			reportStep("This is not NewsLetter Management Page", "FAIL");
		
		}
	}

	public AdminNewsLetterManagementPage click_Newsletter_Tab()
	{
		clickByLink("Newsletter");
		return new AdminNewsLetterManagementPage(driver,test);
	}
	
	public AdminSendNewsLetterPage click_Send_NewsLetter_Button()
	{
		clickByXpath("//button[@class='btn btn-success']");
		return new AdminSendNewsLetterPage(driver,test);
	}
	
	public AdminNewsLetterManagementPage click_checkbox()
	{
		clickByXpath("(//ins[@class='iCheck-helper'])[2]");
		return this;
	}
	
	public AdminNewsLetterManagementPage click_editIcon()
	{
		clickByXpath("(//i[@class='fa fa-edit'])[1]");
		return this;
	}
	
	public AdminNewsLetterManagementPage edit_Subscriber(String data)
	{
		enterByXpath("(//*[@class='xcrud-input form-control'])[1]", data);
		return this;
	}
	
	public AdminNewsLetterManagementPage select_Type(String Val)
	{
		selectVisibleByXpath("(//*[@class='xcrud-input form-control'])[2]", Val);
		return this;
	}
	
	public AdminNewsLetterManagementPage select_enable(String Val)
	{
		selectVisibleByXpath("(//*[@class='xcrud-input form-control'])[3]", Val);
		return this;
	}
	
	public AdminNewsLetterManagementPage get_Executiontime_MemoryUsage()
	{
		getTextByClass("xcrud-benchmark");
		return this;
	}
	
	public AdminNewsLetterManagementPage click_SaveReturn()
	{
		clickByLink("Save & Return");
		return this;
	}
	
	public AdminNewsLetterManagementPage click_View_NewsLetterSubscriber()
	{
		clickByXpath("(//*[@class='fa fa-search'])[2]");
		return this;
	}
	
	public AdminNewsLetterManagementPage get_NewsLetterSubscriber()
	{
		getTextByClass("panel-body");
		return this;
	}

	public AdminNewsLetterManagementPage click_returnToNewsLettepage()
	{
		clickByLink("Return");
		return this;
	}
	
	public AdminNewsLetterManagementPage click_SearchSubscribers()
	{
		clickByLink("Search");
		return this;
	}
	
	public AdminNewsLetterManagementPage enter_SubscriberToSearch(String data) throws InterruptedException
	{
		enterByXpath("(//input[@name='phrase'])", data);
		clickByLink("Go");
		Thread.sleep(2000);
		clickByXpath("(//input[@class='checkboxcls'])[1]");
		verifyTextInATable(data);//"//table[@class='xcrud-list table table-striped table-hover']"
		return this;
	}
	
	
	public AdminNewsLetterManagementPage click_DelteSubscriber(String data)
	{
		clickColumnInATableWithAlert("//i[@class='fa fa-times']",data);//table[@class='xcrud-list table table-striped table-hover']",
		return this;
	}
	
	public AdminNewsLetterManagementPage get_NoEntryConfirmation()
	{
		getTextByXpath("//td[contains(text(),'Entries not found.')]");
		return this;
	}
	
}
