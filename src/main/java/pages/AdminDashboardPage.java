package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminDashboardPage extends PHP_Wrapper {
	public AdminDashboardPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
			if(!verifyTitle("Dashboard")){
				reportStep("This is not admin dashboard page", "FAIL");
		}
		
	}
	public AdminCouponCodePage clickCoupons()
	{
		clickByXpath("//i[@class='fa fa-asterisk']");;
		return new AdminCouponCodePage(driver, test);
	}
	public AdminDashboardPage clickAccounts()
	{
		clickByXpath("//a[@href='#ACCOUNTS']");
		return this;
	}
	public AdminsManagementPage clickAdmins()
	{
		clickByLink("Admins");
		return new AdminsManagementPage(driver, test);
	}
	public AdminCustomerManagementPage clickCustomers()
	{
		clickByLink("Customers");
		return new AdminCustomerManagementPage(driver, test);
	}
public AdminDashboardPage clickOnCarsMenu()
	{
		clickByXpath("//span[contains(.,'Cars')]");
		return this;
	}
	
	public AdminCarsManagementPage clickOnSubCarMenu()
	{
		clickByXpath("(//a[contains(.,'Cars')])[2]");
		return new AdminCarsManagementPage(driver,test);
	}
	
	
	
	public AdminBookingManagementPage clickOnBookingMenu()
	{
		System.out.println("Click on Bookings Menu");
		clickByXpath("//span[contains(.,'Bookings')]");
		return new AdminBookingManagementPage(driver,test);
	}
	public AdminNewsLetterManagementPage click_Newsletter_Tab()
	{
		clickByLink("Newsletter");
		return new AdminNewsLetterManagementPage(driver,test);
	}
	
	
	public AdminDashboardPage click_CarsTab() 
	{
		clickByXpath("( //i[@class='fa arrow'])[4]");
		return this;
	}
	
	public AdminCarsManagementPage click_Cars()
	{
		clickByXpath(" (//a[contains(text(),'Cars')])[1]");
		return new AdminCarsManagementPage(driver,test);
	}
	
	
}