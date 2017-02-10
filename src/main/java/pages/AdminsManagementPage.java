package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.PHP_Wrapper;

public class AdminsManagementPage extends PHP_Wrapper {
	public static String admin =""; 
	public AdminsManagementPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Admins Management")){
			reportStep("This is not admin managemnet page", "FAIL");
		}
		
	}
public AddAdminPage clickAdd()
{
	clickByXpath("//button[@class='btn btn-success']");
	return new AddAdminPage(driver, test);
}
public AdminEditPage clickedit(String adminname)
{
	try{
		WebElement table = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
         
          for(int i = 1;i<rows.size();i++)                      	  
          {
                WebElement text = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr["+i+"]/td[4]"));
                if(text.getText().equalsIgnoreCase(adminname))
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

return new AdminEditPage(driver, test);
}
public AdminsManagementPage clickDelete(String adminname)
{
	try{
			WebElement table = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));
             
              for(int i = 1;i<rows.size();i++)                      	  
              {
                    WebElement text = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr["+i+"]/td[4]"));
                    if(text.getText().equalsIgnoreCase(adminname))
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
public AdminsManagementPage okAlert()
{
	acceptAlert();
	return this;
}
public AdminsManagementPage cancelAlerts()
{
	cancelAlert();
	return this;
}
public AdminsManagementPage clickSearch() 
{
	clickByXpath("//a[@class='xcrud-search-toggle btn btn-default']");
	return this;
}	
public AdminsManagementPage enterSearch(String data)
{
	enterByXpath("//input[@class='xcrud-searchdata xcrud-search-active input-small form-control']", data);
	return this;
}
public AdminsManagementPage selectFields(String Val)
{
	selectVisibleTextByXpath("//select[@class='xcrud-data xcrud-columns-select input-small form-control']", Val);
	return this;
}
public AdminsManagementPage selectActiveType(String Val)
{
	selectVisibleTextByXpath("//select[@class='xcrud-searchdata  input-small form-control xcrud-search-active']", Val);
	return this;
}
public AdminsManagementPage clickGo() throws InterruptedException
{
	
	clickByXpath("//a[@class='xcrud-action btn btn-primary']");
	Thread.sleep(2000);
	return this;
}
public AdminsManagementPage verifyAdmin(String Val)
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
	                	
	                	System.out.println("The searched admin name" +Val+ "is found");
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

