package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class AdminCustomerManagementPage extends PHP_Wrapper {
	public AdminCustomerManagementPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Customers Management")){
			reportStep("This is not customers management page", "FAIL");
		}
		
	}
public AdminAddCustomerPage clickAdd()
{
	clickByXpath("//button[@class='btn btn-success']");
	return new AdminAddCustomerPage(driver, test);
}
public  AdminCustomerEditPage clickedit(String Customername)
{
	try{
		WebElement table = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
         
          for(int i = 1;i<rows.size();i++)                      	  
          {
                WebElement text = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr["+i+"]/td[3]"));
                if(text.getText().equalsIgnoreCase(Customername))
                {
                	driver.findElementByXPath("(//a[@class='btn btn-default btn-xcrud btn btn-warning'])["+i+"]/i").click();
                	break;
                }
                 
          }           
    }catch(StaleElementReferenceException e)
    {
          e.printStackTrace();
          System.out.println("Stale element reference exception");
    }

return new AdminCustomerEditPage(driver, test);
}
public AdminCustomerManagementPage clickDelete(String Customername)
{
	try{
			WebElement table = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));
             
              for(int i = 1;i<rows.size();i++)                      	  
              {
                    WebElement text = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr["+i+"]/td[3]"));
                    if(text.getText().equalsIgnoreCase(Customername))
                    {
                    	driver.findElementByXPath("(//a[@class='btn btn-default btn-xcrud btn-danger'])["+i+"]/i").click();
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
public AdminCustomerManagementPage okAlert()
{
	acceptAlert();
	return this;
}
public AdminCustomerManagementPage cancelAlerts()
{
	cancelAlert();
	return this;
}
public AdminCustomerManagementPage clickSearch() 
{
	clickByXpath("//a[@class='xcrud-search-toggle btn btn-default']");
	return this;
}	
public AdminCustomerManagementPage enterSearch(String data)
{
	enterByXpath("//input[@class='xcrud-searchdata xcrud-search-active input-small form-control']", data);
	return this;
}
public AdminCustomerManagementPage selectFields(String Val)
{
	selectVisibleTextByXpath("//select[@class='xcrud-data xcrud-columns-select input-small form-control']", Val);
	return this;
}
public AdminCustomerManagementPage selectActiveType(String Val)
{
	selectVisibleTextByXpath("//select[@class='xcrud-searchdata  input-small form-control xcrud-search-active']", Val);
	return this;
}
public AdminCustomerManagementPage clickGo() throws InterruptedException
{
	
	clickByXpath("//a[@class='xcrud-action btn btn-primary']");
	Thread.sleep(2000);
	return this;
}
public AdminCustomerManagementPage verifyCustomer(String Val)
{
	try{
		
		   WebElement table = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']"));
	       List<WebElement> rows = table.findElements(By.tagName("tr"));        
	       WebElement notext = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr/td"));
	 	   String noResult = notext.getText();
	 	   if(noResult.equals("Entries not found."))
	 	   {
	 		  System.out.println(noResult);
	 	   }
	 	   else if(driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr[1]/td[4]")).isDisplayed()){
	 		   
	 		   for(int i = 1;i<rows.size();i++)                      	  
	 	   
	          {
	               WebElement text = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr["+i+"]/td[3]"));
	               String test = text.getText();
	               

	                if(test.equalsIgnoreCase(Val))
	                {
	                	
	                	System.out.println("The searched customer name" +Val+ "is found");
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


}

