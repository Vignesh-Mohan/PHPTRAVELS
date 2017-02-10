package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminEditACarPage extends PHP_Wrapper
{
	public AdminEditACarPage(RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
	}

	public AdminEditACarPage ModifyStar()
	{
		System.out.println("Provide Stars");
		selectVisibleTextByName("carstars", "5");
		System.out.println("Stars Provided");
		return this;
	}
	
	public AdminEditACarPage enterPickUpLocation(String CarPickUpLocation)
	{
			
		clickById("s2id_pickuplocationlist3");
		System.out.println("Add Pick Up Location");
		enterTextByXpathForSmartTextBox("(//input[@class='select2-input' or @class='select2-input select2-focused'])[23]",
				"//ul[@class='select2-results']/li/div/span", 
				CarPickUpLocation);
				
		System.out.println("New Pick Up Location Added successfully");
		
		
		System.out.println("Input stored....");
		
		return this;
	}
	
	public AdminEditACarPage enterDropOffLocation(String DropOffLocation)
	{
		clickById("s2id_dropofflocationlist3");
		System.out.println("Add Drop Off Location");
		enterTextByXpathForSmartTextBox("(//input[@class='select2-input' or @class='select2-input select2-focused'])[23]",
				"//ul[@class='select2-results']/li/div/span",
				DropOffLocation);
				
		System.out.println("New Drop Off Location Added successfully");
		
		//driver.manage().window().maximize();
		System.out.println("Input stored....");
		return this;
	}
	
	public AdminEditACarPage enterPrice(String amount)
	{
		enterByName("locations[3][price]", amount);
		return this;
	}
	
	public AdminEditACarPage updateCarDetails()
	{
		
		clickById("update");
		return this;
	}
	
	public AdminEditACarPage deleteACar()
	{
		System.out.println("Deleting a car");
		acceptAnAlertAfterClickByXpath("//i[@class='fa fa-times']");
		System.out.println("A car deleted successfully....");
		return this;
	}
	
}
