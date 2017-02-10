package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class AdminCustomerEditPage extends PHP_Wrapper {
	public AdminCustomerEditPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Update Customer")){
			reportStep("This is not update customer page", "FAIL");
		}
		
	}
	public AdminCustomerEditPage enterFirstName(String data)
	{
		enterByName("fname",data);
		return this;	
	}
	public AdminCustomerEditPage enterLastName(String data)
	{
		enterByName("lname",data);
		return this;	
	}
	public AdminCustomerEditPage enterEmailID(String data)
	{
		enterByName("email",data);
		return this;	
	}
	public AdminCustomerEditPage enterPassword(String data)
	{
		enterByName("password",data);
		return this;	
	}
	public AdminCustomerEditPage enterMobile(String data)
	{
		enterByName("mobile",data);
		return this;	
	}
	public AdminCustomerEditPage selectCountry(String data) throws InterruptedException
	{
		clickByXpath("//a[@class='select2-choice']");
		try{
			WebElement table = driver.findElement(By.xpath("//ul[@class='select2-results']"));
	        List<WebElement> rows = table.findElements(By.tagName("li"));
	         
	          for(int i = 1;i<rows.size();i++)                      	  
	          {
	                WebElement text = driver.findElement(By.xpath("(//li[@class='select2-results-dept-0 select2-result select2-result-selectable'])["+i+"]"));
	                if(text.getText().equalsIgnoreCase(data))
	                {
	                	driver.findElementByXPath("(//li[@class='select2-results-dept-0 select2-result select2-result-selectable'])["+i+"]").click();
	                	break;
	                }
	                 
	          }           
	    }catch(StaleElementReferenceException e)
	    {
	          e.printStackTrace();
	          System.out.println("Stale element reference exception");
	    }

	return this;
	}
	public AdminCustomerEditPage enterAddress1(String data)
	{
		enterByName("address1", data);
		return this;
	}
	public AdminCustomerEditPage enterAddress2(String data)
	{
		enterByName("address2", data);
		return this;
	}
	public AdminCustomerEditPage selectStatus(String Val)
	{
		selectVisibleTextByXpath("//select[@name='status']", Val);
		return this;
	}
	public AdminCustomerEditPage emailNewsLetterSubscriber()
	{
		
		clickByXpath("//div[@class='col-md-12']//label//div");
		return this;
	}
	public AdminCustomerManagementPage clickSubmit()
	{
		clickByXpath("//button[@class='btn btn-primary']");
		return new AdminCustomerManagementPage(driver, test);
	}
}


