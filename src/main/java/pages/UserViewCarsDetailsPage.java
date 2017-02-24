package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class UserViewCarsDetailsPage extends PHP_Wrapper {
	public static String Amount;
	public UserViewCarsDetailsPage(RemoteWebDriver driver, ExtentTest test){
		
		this.driver = driver;
		this.test = test;
		
	}
	
	public UserViewCarsDetailsPage confirmBooking()
	{
		//User Selected Pick Up and Drop Off
		String userSelected_PickUpLocation=UserSearchCarsPage.getPickUpLocation;
		String userSelected_DropOffLocation=UserSearchCarsPage.getDropOffLocation;
		
		
		//Confirm Booking Page matching criteria
		String confirmPage_PickUpLocation=getTextByXpath("(//span[@class='select2-chosen'])[3]");
		String confirmPage_DropOffLocation=getTextByXpath("(//span[@class='select2-chosen'])[4]");
		
		confirmPage_PickUpLocation=confirmPage_PickUpLocation.toLowerCase();
		confirmPage_DropOffLocation=confirmPage_DropOffLocation.toLowerCase();
		
		String confirmPage_PickUpDate=driver.findElement(By.id("departcar2")).getAttribute("value");//returncar2
		String confirmPage_PickUpTime=driver.findElement(By.xpath("//select[@name='pickupTime']")).getAttribute("value");
		
		String confirmPage_DropOffDate=driver.findElement(By.id("returncar2")).getAttribute("value");
		String confirmPage_DropOffTime=driver.findElement(By.name("dropoffTime")).getAttribute("value");
		
		System.out.println("Step 4 : Comparing the Pick Up & Drop Off locations are as such the User Selected ");
		if(!userSelected_PickUpLocation.equals(confirmPage_PickUpLocation))
		{
			System.out.println("Warning: The Pick Up Location is varying, Pls Check!");
			System.out.println("User Selected Pick Up Location is "+userSelected_PickUpLocation +" but changed to "+ confirmPage_PickUpLocation);
		}
		else if(!userSelected_DropOffLocation.equals(confirmPage_DropOffLocation))
		{
			System.out.println("Warning: The Drop Off Location is varying, Pls Check!");
			System.out.println("User Selected Drop Off Location is "+userSelected_DropOffLocation+" but changed to "+ confirmPage_DropOffLocation);
		}
		else if(!UserSearchCarsPage.getPickUpDate.equals(confirmPage_PickUpDate))
		{
			System.out.println("Warning: The Pick Up Date is varying, Pls Check!");
			System.out.println("User Selected Pick Up Date is "+UserSearchCarsPage.getPickUpDate+" but changed to "+ confirmPage_PickUpDate);
		}
		else if(!UserSearchCarsPage.getPickUpTime.equals(confirmPage_PickUpTime))
		{
			System.out.println("Warning: The Pick Up Time is varying, Pls Check!");
			System.out.println("User Selected Pick Up Time is "+UserSearchCarsPage.getPickUpTime+" but changed to "+ confirmPage_PickUpTime);
		}
		else if(!UserSearchCarsPage.getDropOffDate.equals(confirmPage_DropOffDate))
		{
			System.out.println("Warning: The Drop Off Date is varying, Pls Check!");
			System.out.println("User Selected Drop Off Date is "+UserSearchCarsPage.getDropOffDate+" but changed to "+ confirmPage_DropOffDate);
		}
		else if(!UserSearchCarsPage.getDropOffTime.equals(confirmPage_DropOffTime))
		{
			System.out.println("Warning: The Drop Off Time is varying, Pls Check!");
			System.out.println("User Selected Drop Off Time is "+UserSearchCarsPage.getDropOffTime+" but changed to "+ confirmPage_DropOffTime);
		}
		
		else
		{
			System.out.println("  User Selected Locations : "+userSelected_PickUpLocation.toUpperCase() +", "
					+ userSelected_DropOffLocation.toUpperCase() 
					+"\n  Locations in the Confirm booking page locations are:  "
					+ confirmPage_PickUpLocation.toUpperCase() +", "
					+ confirmPage_DropOffLocation.toUpperCase());
			System.out.println("User Selected Pick Up Date: "+ UserSearchCarsPage.getPickUpDate +" Confirm Booking Pick Up Date: "+confirmPage_PickUpDate);
			System.out.println("User Selected Pick Up Time: "+ UserSearchCarsPage.getPickUpTime +" Confirm Booking Pick Up Time: "+confirmPage_PickUpTime);
			System.out.println("User Selected Drop Off Date: "+ UserSearchCarsPage.getDropOffDate +" Confirm Booking Drop Off Date: "+confirmPage_DropOffDate);
			System.out.println("User Selected Drop Off Time: "+ UserSearchCarsPage.getDropOffTime +" Confirm Booking Drop Off Time: "+confirmPage_DropOffTime);
		}
		
		return this;
	}

	
	
	public UserViewCarsDetailsPage addToWishList()
	{
		String getWishListText=getTextByXpath("//span[@class='wishtext' and contains(.,' Add to wishlist')]");
		System.out.println("Wishlist Text: " +getWishListText);
		
		if(getWishListText.equals("Add to wishlist"))
		{
			System.out.println("Step 5 : Add to Wishlist");
			acceptAnAlertAfterClickByXpath("//span[contains(text(),' Add to wishlist')]");
		}
		else
		{
			clickByXpath("//span[contains(text(),' Add to wishlist')]");
			System.out.println("This can't be added to Wishlist, this item is already added to wishlist");
			dismissAnAlertAfterClickByXpath("//span[contains(text(),' Add to wishlist')]");
		}
		return this;
		
	}
	
	public UserPersonalInfoConfirmationPage bookNow()
	{
		Amount=getTextByClass("grandTotal");
		System.out.println("Amount in Book now: " +Amount);
		clickByXpath("//button[contains(text(),'Book Now')]");
		
		return new UserPersonalInfoConfirmationPage(driver,test);
		
	}
	public UserViewCarsDetailsPage  editPickUPLocation(int index)
	{
		selectIndexByName("pickupLocation", index);
		return this;
	}
	
	public UserViewCarsDetailsPage editDropOffLocation(int index)
	{
		selectIndexByName("dropoffLocation", index);
		return this;
	}
	public UserViewCarsDetailsPage editPickUpDate(String pickupdate)
	{
		enterByName("pickupDate", pickupdate);
		return this;
	}
	
	public UserViewCarsDetailsPage editDropOffDate(String dropoffdate)
	{
		enterByName("dropoffDate", dropoffdate);
		return this;
	}
	public UserViewCarsDetailsPage geteditedTotalCost()
	{
		getTextByXpath("//div[@class='col-xs-12 well well-sm text-center']");
		return this;
	}
	public UserPersonalInfoConfirmationPage clickeditedBookNow()
	{
		clickByXpath("//button[@class='btn btn-block btn-action btn-lg']");
		return new UserPersonalInfoConfirmationPage(driver,test);
	}
	//Clicking the logged-in user
	public UserViewCarsDetailsPage clickLoggedInUser()
    {
	clickByXpath("(//a[@class='dropdown-toggle'])[2]");
	return this;
    }
	//Clicking the link "Account"
	public UserAccountPage clickAccount()
    {
	clickByXpath("//a[contains(text(),'Account')]");
	return new UserAccountPage(driver, test);
    }
	public UserViewCarsDetailsPage verifyTextAfterAddingCarToWhislist()
	{
		verifyTextByXpath("//span[@class='wishtext']", "Remove from wishlist");
		return this;
	}
	public UserViewCarsDetailsPage verifyErrorForDate()
	{
		//verifyTextByXpath("//span[contains(text(),'Invalid Date Format')]","Invalid Date Format");
		reportStep("Potential Failure - Invalid PickupDate","ERROR");
		return this;
	}
	
	public UserViewCarsDetailsPage enterPickUpDate(String data) throws InterruptedException
	{
		Thread.sleep(3000);
		enterByName("pickupDate", data);
		Thread.sleep(3000);
		driver.findElement(By.name("pickupDate")).sendKeys(Keys.ENTER);
		return this;
	}
	public UserViewCarsDetailsPage enterdropOffDate(String data) throws InterruptedException
	{
		Thread.sleep(3000);
		enterByName("dropoffDate", data);
		Thread.sleep(3000);
		return this;
	}
}
