package pages;



import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminAddCarPage extends PHP_Wrapper{
	public AdminAddCarPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Add Car"))
		{
			reportStep("This is not Add Car Page", "FAIL");
		
		}
	}

	public AdminAddCarPage click_AddCar()
	{
		clickByXpath("(//button[contains(text(),'Add')])");
		return new AdminAddCarPage(driver,test);
	}
	
	
	public AdminAddCarPage enter_CarName(String data) 
	{
		enterByName("carname", data);
		
		return this;
	}
	
	public AdminAddCarPage enter_CarDescription(String data) throws InterruptedException
	{
		switchToFrame("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]");
		enterByXpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']", data);
		switchToDefaultContent();
		Thread.sleep(3000);
		return this;
	}
	
	public AdminAddCarPage select_Num_CarStars()
	{
		selectVisibleTextByName("carstars", "5");
		return this;
	}
	
	
	public AdminAddCarPage select_Num_Passengers()
	{
		selectVisibleTextByName("passangers", "6");
		return this;
	}
	
	public AdminAddCarPage  select_Num_Doors()
	{
		selectVisibleTextByName("doors", "4");
		return this;
	}
	
	public AdminAddCarPage  select_TransmissionType()
	{
		selectVisibleTextByName("transmission", "Auto");
		return this;
	}
	
	public AdminAddCarPage  select_Baggage()
	{
		selectVisibleTextByName("baggage", "x5");
		return this;
	}
	
	public AdminAddCarPage  select_AirportPickup()
	{
		selectVisibleTextByName("airportpickup", "Yes");
		return this;
	}
	
	public AdminAddCarPage select_CarType()
	{
		clickByXpath("//div[@class='select2-container form-control chosen-select']");
		clickByXpath("//div[contains(text(),'Luxury')]");
		return this;
	}
	
	public AdminAddCarPage selectPickupLocation1 ()
	{
		clickByXpath("(//span[contains(text(),'Enter Location')])[1]");
		enterTextByXpathForSmartTextBox("(//input[@class='select2-input' or @class='select2-input select2-focused'])[23]", "(//ul[@class='select2-results'])[23]//li", "Lon");
		return this;
		
		
	}
	
	

	public AdminAddCarPage selectDropOffLocation1 ()
	{
		clickByXpath("(//span[contains(text(),'Enter Location')])[1]");
		enterTextByXpathForSmartTextBox("(//input[@class='select2-input' or @class='select2-input select2-focused'])[23]", "(//ul[@class='select2-results'])[23]//li", "Lon");
		return this;
	}
	
	public AdminAddCarPage enterPrice()
	{
		enterByName("locations[1][price]", "45,000");
		return this;
	}
	
	public AdminAddCarPage select_RelatedCars()
	{
		clickByXpath("(//ul[@class='select2-choices'])[1]");
		clickByXpath("//div[contains(text(),'Kia Pacanto 2014')]");
		return this;
	}
	
	
	public AdminAddCarPage click_PolicyTab()
	{
		clickByXpath("//ul[@class='nav nav-tabs nav-justified']//li[3]//a");
		return this;
	}
	
	public AdminAddCarPage select_PaymentOptions()
	{
		clickByXpath("(//ul[@class='select2-choices'])[2]");
		selectVisibleTextByName("carpayments[]", "Cash");
		selectVisibleTextByName("carpayments[]", "Pay on Arrival");
		selectVisibleTextByName("carpayments[]", "Credit Card");
		selectVisibleTextByName("carpayments[]", "Wire Transfer");
		return this;
		
	}
	
	public AdminAddCarPage enter_PolicyAndTerms()
	{
		enterByName("carpolicy", "We do not follow any policy!! :) ");
		return this;
	}
	
	public AdminAddCarPage click_GeneralTab()
	{
		clickByXpath("//ul[@class='nav nav-tabs nav-justified']//li[1]//a");
		return this;
	}
	
	public AdminAddCarPage verify_addedCar(String data) throws InterruptedException
	{
		
		clickByXpath("//a[@class='xcrud-search-toggle btn btn-default']");
		enterByXpath("//input[@class='xcrud-searchdata xcrud-search-active input-small form-control']", data);
		clickByXpath("//a[@class='xcrud-action btn btn-primary']");
		Thread.sleep(2000);
	//	clickByXpath("(//input[@class='iCheck-helper'])[1]");
		verifyTextInATable( data);
		return this;
	}
	public AdminAddCarPage clickSubmitCarwithemptyCarName()
	{
		clickById("add");
		verifyTextByXpath("//p[contains(text(),'The Car Name field is required.')]", "The Car Name field is required.");
		return this;
	}
	public AdminCarsManagementPage click_SubmitCar() throws InterruptedException
	{
		clickById("add");
		Thread.sleep(4000);
		return new AdminCarsManagementPage(driver, test);
	}
	
	
}
