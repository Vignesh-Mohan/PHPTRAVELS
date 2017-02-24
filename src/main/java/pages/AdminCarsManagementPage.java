package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminCarsManagementPage extends PHP_Wrapper 
{
	public AdminCarsManagementPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;		
		if(!verifyTitle("Cars Management")){
			reportStep("This is not Cars Management page", "FAIL");
		}
	}
	
	public AdminEditACarPage editACar()
	{
		clickByXpath("//i[@class='fa fa-edit']");
		System.out.println("Edit button clicked");
		return new AdminEditACarPage(driver,test);
	}
	
	public AdminCarsManagementPage clickSearchButton()
	{
		scrollDown();
		System.out.println("scrolled down");
		System.out.println("Click on Search button");
		clickByXpath("//a[contains(.,'Search')]");
		
		return this;
	}
	
	public AdminCarsManagementPage searchWithParticulars(String SearchKey)
	{
		System.out.println("Search with search key");
		enterByName("phrase", SearchKey);
		clickByXpath("//a[contains(.,'Go')]");
		return this;
	}
	public AdminAddCarPage click_AddCar()
	{
		clickByXpath("(//button[contains(text(),'Add')])");
		return new AdminAddCarPage(driver,test);
	}
	public AdminCarsManagementPage deleteCars(String Val)
	{
		try{
	        List<WebElement> tables = driver.findElements(By.tagName("table"));
	        
	        for(WebElement table : tables)
	        {
	              List<WebElement> rows = table.findElements(By.tagName("tr"));
	              
	              for(int i = 0;i<rows.size();i++)
	              {
	            	 
	                     List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
	                     
	                     for(int j = 0;j<columns.size();j++)
	                     {
	                    	 String noResult =columns.get(j).getText();
	                            if(noResult.equals(Val))
	                            {                       
	                            	driver.findElementByXPath("(//a[@class='btn btn-default btn-xcrud btn-danger'])["+i+"]/i").click();
	                            	acceptAlert();
	                            	break;
	                            }
	                            
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
	public AdminCarsManagementPage verifyNewlyAddedCarPresent(String data)
	{
		verifyTextInATable(data);
		return this;
	}

	public AdminCarsGalleryManagementPage clickOnUploadLinkBasedOnCarName() throws InterruptedException
	{
		clickByXpath("//a[contains(.,'Upload (1)')]");
		return new AdminCarsGalleryManagementPage(driver, test);
	}
	

}
