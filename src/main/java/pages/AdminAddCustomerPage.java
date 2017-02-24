package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class AdminAddCustomerPage extends PHP_Wrapper {
	public AdminAddCustomerPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Add Customer")){
			reportStep("This is not Add Customer page", "FAIL");
		}
		
	}
public AdminAddCustomerPage enterFirstName(String data)
{
	enterByName("fname",data);
	return this;	
}
public AdminAddCustomerPage enterLastName(String data)
{
	enterByName("lname",data);
	return this;	
}
public AdminAddCustomerPage enterEmailID(String data)
{
	enterByName("email",data);
	return this;	
}
public AdminAddCustomerPage enterPassword(String data)
{
	enterByName("password",data);
	return this;	
}
public AdminAddCustomerPage enterMobile(String data)
{
	enterByName("mobile",data);
	return this;	
}
public AdminAddCustomerPage selectCountry(String data) throws InterruptedException
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
public AdminAddCustomerPage enterAddress1(String data)
{
	enterByName("address1", data);
	return this;
}
public AdminAddCustomerPage enterAddress2(String data)
{
	enterByName("address2", data);
	return this;
}
public AdminAddCustomerPage selectStatus(String Val)
{
	selectVisibleTextByXpath("//select[@name='status']", Val);
	return this;
}
public AdminAddCustomerPage emailNewsLetterSubscriber()
{
	clickByXpath("//div[@class='icheckbox_square-grey']//ins");
	return this;
}
public AdminAddCustomerPage clickInavlidSubmit() throws InterruptedException
{
	clickByXpath("//button[@class='btn btn-primary']");
	Thread.sleep(6000);
	getTextByXpath("//div[@class='alert alert-danger']//p");
	return this;
}
public AdminCustomerManagementPage clickSubmit()
{
	clickByXpath("//button[@class='btn btn-primary']");
	return new AdminCustomerManagementPage(driver, test);
}
}


