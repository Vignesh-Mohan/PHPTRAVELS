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
	public UserSearchCarsPage clickCars(){
		clickByLink("Cars");
		return new UserSearchCarsPage(driver, test);
		}
	}