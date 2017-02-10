package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class AdminEditPage extends PHP_Wrapper {
	public AdminEditPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Update Admin")){
			reportStep("This is not Update Admin page", "FAIL");
		}
		
	}
	public AdminEditPage enterFirstName(String data)
	{
		enterByName("fname",data);
		return this;	
	}
	public AdminEditPage enterLastName(String data)
	{
		enterByName("lname",data);
		return this;	
	}
	public AdminEditPage enterEmailID(String data)
	{
		enterByName("email",data);
		return this;	
	}
	public AdminEditPage enterPassword(String data)
	{
		enterByName("password",data);
		return this;	
	}
	public AdminEditPage enterMobile(String data)
	{
		enterByName("mobile",data);
		return this;	
	}
	public AdminEditPage selectCountry(String data) throws InterruptedException
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
	public AdminEditPage enterAddress1(String data)
	{
		enterByName("address1", data);
		return this;
	}
	public AdminEditPage enterAddress2(String data)
	{
		enterByName("address2", data);
		return this;
	}
	public AdminEditPage selectStatus(String Val)
	{
		selectVisibleTextByXpath("//select[@name='status']", Val);
		return this;
	}
	public AdminEditPage emailNewsLetterSubscriber()
	{
		clickByXpath("//div[@class='col-md-12']//label//div");
		return this;
	}
	public AdminEditPage selectAddModules(String data) throws InterruptedException
	{
		try{
			WebElement table = driver.findElement(By.xpath("//ul[@class='list-unstyled']"));
	        List<WebElement> rows = table.findElements(By.tagName("li"));
	        if(data.equals("All"))
	        {
	        for(int i = 1;i<=rows.size();i++)
	        	{
	        	driver.findElementByXPath("(//ul[@class='list-unstyled']//li//div)["+i+"]").click();
	        	}
	        }
	        else
	        {        
	          for(int i = 1;i<rows.size();i++)                      	  
	          {
	                WebElement text = driver.findElement(By.xpath("(//ul[@class='list-unstyled']//li//label)["+i+"]"));
	                if(text.getText().equalsIgnoreCase(data))
	                {
	                	driver.findElementByXPath("(//ul[@class='list-unstyled']//li//div)["+i+"]").click();
	                	break;
	                }
	                 
	          }
	        }
	    }catch(StaleElementReferenceException e)
	    {
	          e.printStackTrace();
	          System.out.println("Stale element reference exception");
	    }

	return this;

	}
	public AdminEditPage selectEditModules(String data) throws InterruptedException
	{
		try{
			WebElement table = driver.findElement(By.xpath("(//ul[@class='list-unstyled'])[2]"));
	        List<WebElement> rows = table.findElements(By.tagName("li"));
	        if(data.equalsIgnoreCase("All"))
	        {
	        for(int i = 1;i<=rows.size();i++)
	        {
	        	driver.findElementByXPath("((//ul[@class='list-unstyled'])[2]//li//div)["+i+"]").click();       	
	        }
	        }
	        else
	        {
	        
	          for(int i = 1;i<=rows.size();i++)                      	  
	          {
	                WebElement text = driver.findElement(By.xpath("((//ul[@class='list-unstyled'])[2]//li//label)["+i+"]"));
	                if(text.getText().equalsIgnoreCase(data))
	                {
	                	driver.findElementByXPath("((//ul[@class='list-unstyled'])[2]//li//div)["+i+"]").click();
	                	break;
	                }
	                 
	          } 
	        }
	    }catch(StaleElementReferenceException e)
	    {
	          e.printStackTrace();
	          System.out.println("Stale element reference exception");
	    }

	return this;
	}
	public AdminEditPage selectRemoveModules(String data) throws InterruptedException
	{
		try{
			WebElement table = driver.findElement(By.xpath("(//ul[@class='list-unstyled'])[3]"));
	        List<WebElement> rows = table.findElements(By.tagName("li"));
	        if(data.equalsIgnoreCase("All"))
	        {
	        for(int i = 1;i<=rows.size();i++)
	        {
	        	driver.findElementByXPath("((//ul[@class='list-unstyled'])[3]//li//div)["+i+"]").click();       	
	        }
	        }
	        else
	        {
	        
	          for(int i = 1;i<=rows.size();i++)                      	  
	          {
	                WebElement text = driver.findElement(By.xpath("((//ul[@class='list-unstyled'])[3]//li//label)["+i+"]"));
	                if(text.getText().equalsIgnoreCase(data))
	                {
	                	driver.findElementByXPath("((//ul[@class='list-unstyled'])[3]//li//div)["+i+"]").click();
	                	break;
	                }
	                 
	          } 
	        }
	    }catch(StaleElementReferenceException e)
	    {
	          e.printStackTrace();
	          System.out.println("Stale element reference exception");
	    }

	return this;	
	}
	public AdminsManagementPage  clickSubmit()
	{
		clickByXpath("//button[@class='btn btn-primary']");
		return new AdminsManagementPage(driver, test);
	}
}


