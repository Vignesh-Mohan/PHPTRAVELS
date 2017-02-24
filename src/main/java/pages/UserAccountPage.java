package pages;


import org.openqa.selenium.remote.RemoteWebDriver;


import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class UserAccountPage extends PHP_Wrapper{

	public UserAccountPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("My Account")){
			reportStep("This is not My Account page", "FAIL");
		}
	}
	//Clicks "Bookings" tab in Account Page
	public UserAccountPage clickBookings(){
		clickByClassName("bookings-icon");
		return this;
	}
	//Clicks "My Profile" tab in Account Page
	public UserAccountPage clickMyProfile(){
		clickByClassName("profile-icon");
		return this;
	}
	//Clicks "Whishlist" tab in Account Page
	public UserAccountPage clickWhishlist(){
		clickByClassName("wishlist-icon");
		return this;
	}
	//Clicks "Cars" link and it launches the "Cars Listings" page
	public UserSearchCarsPage clickCars() throws InterruptedException{
		
		clickByLink("Cars");
		return new UserSearchCarsPage(driver, test);
		}
	
	public UserAccountPage addNewsLetterSubscriber(String data)
	{
		enterById("exampleInputEmail1", data);
		actionClickElementUsingXpath("(//button[@type='submit'])[1]");
	
		return this;
	}
	
	public UserAccountPage invalidAddNewsLetterSubscriber(String data)
	{
		enterById("exampleInputEmail1", data);
		actionClickElementUsingXpath("(//button[@type='submit'])[1]");
		System.out.println("Before Javascript");
		//js.executeScript("document.getElementsByClassName('subscriberesponse')").style.display="block";
		
		//	javascript.executeScript("document.getElementsByClassName('subscriberesponse')".style.display="block");
		verifyTextByXpath("//div[@class='subscriberesponse']//p", "Kindly Enter a Valid Email Address.");
		return this;
	}
	
	//Click "Remove" button in Whishlist page
		public UserAccountPage clickRemoveButton(){
			clickByXpathWithAlert("//span[@class='btn btn-sm btn-block btn-danger removewish remove_btn']");
			//driver.switchTo().alert().accept();		
			return this;
			}
	
		public UserAccountPage checkUserName()
		{
			String UserName=getTextByXpath("//h3[@class='RTL']");
			System.out.println("USer Name: "+UserName);
			String SignUpUserName="Hi, "+SignUpPage.UserFirstName+" "+SignUpPage.UserLastName;
			if(SignUpUserName.toLowerCase().equals(UserName.toLowerCase()))
				System.out.println("User Name: "+ SignUpUserName +" is displayed as expected");
			else
				System.out.println("User Name: "+ SignUpUserName +" is not displayed as expected");
			return this;
		}
		 public UserAccountPage clickUserName()
		 {
			 clickByXpath("//i[@class='icon_set_2_icon-105']");
			 return this;
		 }
		
		public UserLoginPage logOut()
		 {
			 clickByLink("Logout");
			 return new UserLoginPage(driver,test);
		 }
	}