package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class UserMyProfilePage extends PHP_Wrapper {

	public UserMyProfilePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if (!verifyTitle("My Account")) {
			reportStep("This is not My Account page", "FAIL");
		}
	}

	// Enter "Phone number"
	public UserMyProfilePage enterPhone(String data) {
		enterByName("phone", data);
		return this;
	}

	// Enter "Email"
	public UserMyProfilePage enterEmail(String data) {
		enterByName("email", data);
		return this;
	}

	// Enter "Password"
	public UserMyProfilePage enterPassword(String data) {
		enterByName("password", data);
		return this;
	}

	// Enter "Confirm Password"
	public UserMyProfilePage enterConfirmPassword(String data) {
		enterByName("confirmpassword", data);
		return this;
	}

	// Enter "Address"
	public UserMyProfilePage enterAddress(String data) {
		enterByName("address1", data);
		return this;
	}

	// Enter "Address 2"
	public UserMyProfilePage enterAddress2(String data) {
		enterByName("address2", data);
		return this;
	}

	// Enter "City"
	public UserMyProfilePage enterCity(String data) {
		enterByName("city", data);
		return this;
	}

	// Enter "State/Region"
	public UserMyProfilePage StateOrRegion(String data) {
		enterByName("state", data);
		return this;
	}

	// Enter "Postal/Zip Code"
	public UserMyProfilePage PostalOrZipCode(String data) {
		enterByName("Postal/Zip Code", data);
		return this;
	}

	// Select "Country"
	public UserMyProfilePage Country(String data) {
		selectVisibleTextByName("country", data);
		return this;
	}

	// Click "Submit" button
	public UserMyProfilePage clickSubmit(String data) {
		clickByLink("Submit");
		return this;
	}
}