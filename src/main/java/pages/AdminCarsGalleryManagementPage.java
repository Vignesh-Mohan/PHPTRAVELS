package pages;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminCarsGalleryManagementPage  extends PHP_Wrapper 
{
	public AdminCarsGalleryManagementPage(RemoteWebDriver driver, ExtentTest test) 
	{
			this.driver=driver;
			this.test=test;
	}
	
	public AdminCarsGalleryManagementPage clickAddPhoto()
	{
		clickByXpath("//a[@href='#UploadPhotos']");
		System.out.println("Inside Add Photo");
		return this;
	}

	public AdminCarsGalleryManagementPage clickOnDropButton() throws IOException
	{
		System.out.println("Drop Button Click");
		clickByXpath("//span[@class='drop']");
		System.out.println("Drop Button Clicked");
		Runtime.getRuntime().exec("./AutoITScript/UploadCar.exe");
		System.out.println("Auto IT executed......");
		return this;
	}
	////span[@class='drop']
}
