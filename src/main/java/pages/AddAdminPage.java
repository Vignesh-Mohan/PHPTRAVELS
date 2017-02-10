package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class AddAdminPage extends PHP_Wrapper {
	public AddAdminPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Add Admin")){
			reportStep("This is not Add Admin page", "FAIL");
		}
		
	}
public AddAdminPage enterFirstName(String data)
{
	enterByName("fname",data);
	return this;	
}
public AddAdminPage enterLastName(String data)
{
	enterByName("lname",data);
	return this;	
}
public AddAdminPage enterEmailID(String data)
{
	enterByName("email",data);
	return this;	
}
public AddAdminPage enterPassword(String data)
{
	enterByName("password",data);
	return this;	
}
public AddAdminPage enterMobile(String data)
{
	enterByName("mobile",data);
	return this;	
}
public AddAdminPage selectCountry(String data) throws InterruptedException
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
public AddAdminPage enterAddress1(String data)
{
	enterByName("address1", data);
	return this;
}
public AddAdminPage enterAddress2(String data)
{
	enterByName("address2", data);
	return this;
}
public AddAdminPage selectStatus(String Val)
{
	selectVisibleTextByXpath("//select[@name='status']", Val);
	return this;
}
public AddAdminPage emailNewsLetterSubscriber()
{
	clickByXpath("//div[@class='icheckbox_square-grey']//ins");
	return this;
}
public AddAdminPage selectAddModules(String data) throws InterruptedException
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
public AddAdminPage selectEditModules(String data) throws InterruptedException
{
	try{
		WebElement table = driver.findElement(By.xpath("(//ul[@class='list-unstyled'])[2]"));
        List<WebElement> rows = table.findElements(By.tagName("li"));
        if(data.equals("All"))
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
public AddAdminPage selectRemoveModules(String data) throws InterruptedException
{
	try{
		WebElement table = driver.findElement(By.xpath("(//ul[@class='list-unstyled'])[3]"));
        List<WebElement> rows = table.findElements(By.tagName("li"));
        if(data.equals("All"))
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


