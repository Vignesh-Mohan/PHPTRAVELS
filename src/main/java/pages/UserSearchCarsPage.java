package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class UserSearchCarsPage extends PHP_Wrapper{
	public static String getPickUpLocation;
	public static String getDropOffLocation;
	public static String getPickUpDate;
	public static String getPickUpTime;
	public static String getDropOffDate;
	public static String getDropOffTime;
	public UserSearchCarsPage (RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Cars Listings"))
		{
			reportStep("This is not Cars Listing Page", "FAIL");
		
		}
	}

	public UserSearchCarsPage clickStarGrade()
	{
		System.out.println("In CarListing Page");
		clickByXpath("(//div[@class='iradio_square-grey'])[3]");
		return this;
	}
		
	
	public UserSearchCarsPage click_Pick_UP_Location()
	{
		
		clickByLink("Pick up Location");
		return this;
	}
	
	public UserSearchCarsPage select_Pick_UP_Location()
	{
		clickByXpath("//div[contains(text(),'Nile Egypt')]");
		return this;
	}
	
	public UserSearchCarsPage click_Drop_Off_Location()
	{
		clickByLink("Drop off Location");
		return this;
	}
	
	public UserSearchCarsPage click_Pick_Up_Date() throws InterruptedException
	{
		Thread.sleep(1000);
		clickByName("pickupDate");
		return this;
	}
	
	public UserSearchCarsPage select_Pick_Up_Date(String dateVal)
	{
		daysPickerUsingXpath("(//div[@class='datepicker-days']/table)", dateVal);
		return this;
	}
	
	public UserSearchCarsPage  click_Drop_Off_Date()
	{
		clickByName("dropoffDate");
		return this;
	}
	
	
	
	public UserSearchCarsPage select_Dop_Off_Date(String dateVal)
	{
		// for selecting month
		
		daysPickerUsingXpath("(//div[@class='datepicker-days']/table)[2]", dateVal);
		return this;
	
	}
	
	public UserSearchCarsPage select_Drop_Off_Time()
	{
		selectIndextByName("dropoffTime", "07:00");
		return this;
	}
	public UserSearchCarsPage click_Quick_Search()
	{
		clickByXpath("(//button[contains(text(),'Search')])[1]");
		return this;
	}
	
	public UserSearchCarsPage click_Price_Range()
	{
		actionMoveElementUsingXpath("(//div[@class='slider-handle round'])[2]", -131, 962);
		return this;
		
	}
	
	public UserSearchCarsPage click_Car_Type()
	{
		clickByXpath("(//div[@class='iradio_square-grey'])[10]");
		return this;
		
	}
	
	public UserSearchCarsPage click_Airport_Pickup(String Val)
	{
		selectVisibleTextByName("pickup", Val);
		return this;
	}
	
	public UserSearchCarsPage click_Filter_Search()
	{
		clickById("searchform");
		return this;
	}



	public UserViewCarsDetailsPage viewACar()
	{
		
		//userSelection();
		
		System.out.println("Step 3 : View Car Details");
		
		//Selecting pick up location
		//clickByLink("Pick up Location");
		//clickByXpath("//div[contains(text(),'Nile Egypt')]");
		
		//selecting drop off location
		//clickByXpath("(//a[@class='select2-choice'])[2]");
		//clickByXpath("//div[contains(text(),'Nile Egypt')]");
		
		
		//getPickUpLocation=getTextByXpath("//span[@class='select2-chosen']");
		//getDropOffLocation=getTextByXpath("(//span[@class='select2-chosen'])[2]");
		
		getPickUpLocation=getTextByXpath("//span[@class='select2-chosen']");
		getDropOffLocation=getTextByXpath("(//span[@class='select2-chosen'])[2]");
		
		//getPickUpLocation=getTextById("s2id_carlocations");
		//getDropOffLocation=getTextById("s2id_autogen2");
		
		
		getPickUpLocation=getPickUpLocation.toLowerCase();
		getDropOffLocation=getDropOffLocation.toLowerCase();
		
		getPickUpDate=driver.findElement(By.id("departcar")).getAttribute("value");
		
		getPickUpTime=driver.findElement(By.name("pickupTime")).getAttribute("value");
		
		System.out.println("In view car page pick up location: "+getPickUpLocation);
		System.out.println("In view car page drop off location : "+getDropOffLocation);
		System.out.println("In view car page pick up date: "+getPickUpDate);
		System.out.println("In view car page pick up time : "+getPickUpTime);
		
		getDropOffDate=driver.findElement(By.id("returncar")).getAttribute("value");
		getDropOffTime=driver.findElement(By.name("dropoffTime")).getAttribute("value");
		
		
		
		
		
		
		clickByXpath("//button[contains(text(),'Details')]");
		
		return new UserViewCarsDetailsPage(driver,test);
	}
	
	//Getting cars selection details
	public void userSelection()
	{
		System.out.println("Step 3 : View Car Details");
		
		
		//getPickUpLocation=getTextByXpath("//span[@class='select2-chosen']");
		//getDropOffLocation=getTextByXpath("(//span[@class='select2-chosen'])[2]");
		
		getPickUpLocation=getTextByXpath("//span[@class='select2-chosen']");
		getDropOffLocation=getTextByXpath("(//span[@class='select2-chosen'])[2]");
		
		//getPickUpLocation=getTextById("s2id_carlocations");
		//getDropOffLocation=getTextById("s2id_autogen2");
		
		
		getPickUpLocation=getPickUpLocation.toLowerCase();
		getDropOffLocation=getDropOffLocation.toLowerCase();
		
		getPickUpDate=driver.findElement(By.id("departcar")).getAttribute("value");
		
		getPickUpTime=driver.findElement(By.name("pickupTime")).getAttribute("value");
		
		System.out.println("In view car page pick up location: "+getPickUpLocation);
		System.out.println("In view car page drop off location : "+getDropOffLocation);
		System.out.println("In view car page pick up date: "+getPickUpDate);
		System.out.println("In view car page pick up time : "+getPickUpTime);
		
		getDropOffDate=driver.findElement(By.id("returncar")).getAttribute("value");
		getDropOffTime=driver.findElement(By.name("dropoffTime")).getAttribute("value");
		
	}
	
	//Optional Search
	
	
	
	
	

}
