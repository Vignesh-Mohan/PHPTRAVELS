package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class UserWhishlistPage extends PHP_Wrapper{

	public UserWhishlistPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("My Account")){
			reportStep("This is not My Account page", "FAIL");
		}
	}
	//Click "Remove" button in Whishlist page
	public UserWhishlistPage clickRemoveButton(){
		clickByXpath("//span[@class='btn btn-sm btn-block btn-danger removewish remove_btn']");
		//driver.switchTo().alert().accept();		
		return this;
	}
	//Click "OK" in the Alert displayed
		public UserWhishlistPage clicOKInALert(){
			driver.switchTo().alert().accept();
			return this;
		}
}