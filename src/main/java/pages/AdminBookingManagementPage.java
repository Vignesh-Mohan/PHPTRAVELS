package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;

public class AdminBookingManagementPage extends PHP_Wrapper
{
	public AdminBookingManagementPage(RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
	}
	
	public AdminBookingManagementPage viewInvoice()
	{
		switchToParentWindow();
		clickByXpath("//i[@class='fa fa-search-plus']");
		
		switchToLastWindow();
		return this;
	}
	
	public AdminBookingManagementPage getTotalAmount()
	{
		String TotalInvoiceAmount=getTextByXpath("//td[contains(.,'Total Amount')]/following-sibling::td");
		System.out.println("Total Invoice amount: " +TotalInvoiceAmount);
		
		return this;
	}
	
	public AdminBookingManagementPage verifyStatus()
	{
		clickByClassName("btn btn-xs btn-success");
		return this;
	}
	
	
	
	public AdminEditBookingPage editABooking()
	{
		
		clickByXpath("//i[@class='fa fa-edit']");
		return  new AdminEditBookingPage(driver, test);
	}
	
	public AdminBookingManagementPage clickOnUploadBasedUponCarName(String carName)
	{
		String CarNameXpath="\"//a[contains(.,'" + carName + "')]\"";
		String getCarName=getTextByXpath(CarNameXpath);
		if(getCarName.equals(carName))
		{
			System.out.println("The Car: "+carName+" taken for photo upload");
			
		}
		return this;
	}
	public AdminBookingManagementPage uploadImage()
	{
		
		return this;
	}
	public AdminBookingManagementPage clickSearchButton()
	{
		scrollDown();
		System.out.println("scrolled down");
		System.out.println("Click on Search button");
		clickByXpath("//a[contains(.,'Search')]");
		
		return this;
	}
	
	public AdminBookingManagementPage searchWithParticulars(String SearchKey)
	{
		System.out.println("Search with search key");
		enterByName("phrase", SearchKey);
		clickByXpath("//a[contains(.,'Go')]");
		return this;
	}
	
	public AdminBookingManagementPage searchWithAllFields()
	{
		System.out.println("Search with all fields");
		clickByXpath("//a[contains(.,'Go')]");
		return this;
	}
	public AdminBookingManagementPage checkBgColorofStatus(String Val)
	{
	String bgcolour ="";
	try {
					
					
					List<WebElement> tables = driver.findElements(By.tagName("table"));
		             for(WebElement table : tables)
		           {
		                       

					List<WebElement> rows = table.findElements(By.tagName("tr"));
					for(int i = 0;i<rows.size();i++)
					{
					       List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
					       for(int j = 0;j<cols.size();j++)
					       {
					             if(cols.get(j).getText().equalsIgnoreCase(Val))
					             {
					                    System.out.println("Match found");
					                    
					               bgcolour =   cols.get(j+7).findElement(By.tagName("span")).getCssValue("backgroundcolour");
	                               String str=bgcolour;
			
			                       String partialRGB = str.substring(str.indexOf("(") + 1, str.indexOf(")"));;
			                       partialRGB=partialRGB.replace(",", "");
			                       partialRGB=partialRGB.replace(",", "");
			int RBG_Number=Integer.valueOf(partialRGB);
	switch(RBG_Number)
	{
	case 251180801: 
					System.out.println("The background color is Orange  and the car  Status is RESERVED");
					reportStep("The background color is Orange and the car is reserved", "PASS");
					break;

	case 98196981: 
					System.out.println("The background color is Orange  and the car Status is PAID");
					reportStep("The background color is Green and the car Status is PAID", "PASS");
					break;
	case 911922221: 
					System.out.println("The background color is Orange  and the car Status is UNPAID");
					reportStep("The background color is Blue and the car Status is UNPAID", "PASS");
					break;
	case 23895911: 
					System.out.println("The background color is Orange  and the car Status is CANCELLED");
					reportStep("The background color is Red and the car Status is CANCELLED", "PASS");
					break;

	default:			System.out.println(" The Background color does not match");
					reportStep(" The background color does not match with any criteria","FAIL");
					break;
	}

					                  
					                    break;
					             }
					       }
					}
					reportStep("","PASS");
				}
				}
	                                
	                catch(StaleElementReferenceException e)
	                {
	                      e.printStackTrace();
	                      System.out.println("Stale element reference exception");
	                }
	return this;
	}
	public AdminBookingManagementPage deleteBooking(String val)
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
	                            if(noResult.equals(val))
	                            {                       
	                            	driver.findElementByXPath("(//a[@class='btn btn-default btn-xcrud btn-danger'])[1]/i").click();
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
	
	
	
}
