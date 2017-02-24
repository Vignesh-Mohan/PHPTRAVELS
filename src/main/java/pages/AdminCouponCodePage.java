package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.PHP_Wrapper;
public class AdminCouponCodePage extends PHP_Wrapper {
	public static String code =""; 
	public AdminCouponCodePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Coupon Codes Management")){
			reportStep("This is not Coupon Codes Management page", "FAIL");
		}
		
	}
public AdminCouponCodePage clickSearch() throws InterruptedException 
{
	Thread.sleep(3000);
	clickByXpath("//a[@class='xcrud-search-toggle btn btn-default']");
	return this;
}
	
public AdminCouponCodePage enterSearch(String codename)
{
	enterByXpath("//input[@class='xcrud-searchdata xcrud-search-active input-small form-control']", codename);
	return this;
}
public AdminCouponCodePage enterSearchByCode()
{
	enterByXpath("//input[@class='xcrud-searchdata xcrud-search-active input-small form-control']", code);
	return this;
}
public AdminCouponCodePage enterSearchByCodeName(String val)
{
	enterByXpath("//input[@class='xcrud-searchdata xcrud-search-active input-small form-control']", val);
	return this;
}


public AdminCouponCodePage selectFields(String Val)
{
	selectVisibleTextByXpath("//select[@class='xcrud-data xcrud-columns-select input-small form-control']", Val);
	return this;
}
public AdminCouponCodePage selectEnableType(String Val)
{
	selectVisibleTextByXpath("//select[@class='xcrud-searchdata  input-small form-control xcrud-search-active']", Val);
	return this;
}
public AdminCouponCodePage clickGo() throws InterruptedException
{
	
	clickByXpath("//a[@class='xcrud-action btn btn-primary']");
	Thread.sleep(2000);
	return this;
}
public AdminCouponCodePage noCoupon() throws InterruptedException
{
	clickByXpath("//button[@class='btn btn-primary submitcoupon']");
	verifyTextByXpath("//div[@class='alert alert-danger']//p", "The Coupon Code field is required.");
	return this;
}
public AdminCouponCodePage clickEdit()
{
	try{
			WebElement table = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));
             
              for(int i = 1;i<rows.size();i++)                      	  
              {
                    WebElement text = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr["+i+"]/td[4]"));
                    if(text.getText().equalsIgnoreCase(code))
                    {
                    	System.out.println("Code Matched");
                    	driver.findElementByXPath("(//a[@class='btn btn-default btn-xcrud btn btn-warning'])[1]/i").click();
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
public AdminCouponCodePage clickView(String coupon)
{
	try{
			WebElement table = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));
             
              for(int i = 1;i<rows.size();i++)                      	  
              {
                    WebElement text = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr["+i+"]/td[4]"));
                    if(text.getText().equalsIgnoreCase(coupon))
                    {
                    	driver.findElementByXPath("(//a[@class='xcrud-action btn btn-info btn-xcrud'])["+i+"]/i").click();
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
public AdminCouponCodePage clickDelete()
{
	try{
			WebElement table = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));
             
              for(int i = 1;i<rows.size();i++)                      	  
              {
                    WebElement text = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr["+i+"]/td[4]"));
                    if(text.getText().equalsIgnoreCase(code))
                    {
                    	driver.findElementByXPath("(//a[@class='xcrud-action btn btn-danger btn-xcrud'])["+i+"]/i").click();
                    	driver.switchTo().alert().accept();
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
public AdminCouponCodePage okAlert() 
{	
	acceptAlert();
	return this;
}
public AdminCouponCodePage cancelAlerts()
{
	cancelAlert();
	return this;
}
public AdminCouponCodePage clickAdd() throws InterruptedException
{
	clickByXpath("//button[@class='btn btn-success']");
	Thread.sleep(2000);
	return this;
}
public AdminCouponCodePage enterPercentage(String data)
{
	enterById("rate", data);
	return this;
}
public AdminCouponCodePage enterEditPercentage(String data) throws InterruptedException
{
	Thread.sleep(5000);
	//enterByXpath("//form[@id='editcoupon13']//label[contains(.,'Percentage')]/following-sibling::div/input", data);
	reportStep("Potential Failure","ERROR");
	return this;
}
public AdminCouponCodePage enterMaxVal(String data)
{
	enterByName("max", data);
	return this;
}
public AdminCouponCodePage selectStatus(String Val)
{
	selectVisibleTextByXpath("//div[@class='col-md-8']/select", Val);
	return this;
}
public AdminCouponCodePage selectEditStatus(String Val) throws InterruptedException
{
	Thread.sleep(1000);
	selectVisibleTextByXpath("(//select[@id='#'])[6]", Val);
	return this;
}
public AdminCouponCodePage selectStartDate(String dateVal)
{
	
clickByXpath("//input[@name='startdate']");	
//driver.findElementByXPath("(//div[@class='datepicker-days'])[1]//table//tbody//td[@class='day  active']").click();	
daysPickerUsingXpath("(//div[@class='datepicker-days'])[1]", dateVal);
	return this;
}
public AdminCouponCodePage selectEnddate(String dateVal)
{
	//driver.findElementByXPath("(//div[@class='datepicker-days'])[6]//table//tbody//td[@class='day ']").click();
daysPickerUsingXpath("(//div[@class='datepicker-days'])[6]", dateVal);
    return this;	
}
public AdminCouponCodePage clickAllHotels()
{
	clickByXpath("(//div[@class='panel-body'])[2]//div[@class='icheckbox_square-grey'][1]");
	return this;
}
public AdminCouponCodePage clickAllTours()
{
	clickByXpath("(//div[@class='panel-body'])[2]//div[@class='icheckbox_square-grey'][2]");
	return this;
}
public AdminCouponCodePage clickAllCars()
{
	clickByXpath("(//div[@class='panel-body'])[2]//div[@class='icheckbox_square-grey'][3]");
	return this;
}
public AdminCouponCodePage clickGenerate() throws InterruptedException
{
	
	clickByXpath("//button[@class='btn btn-primary btn-lg generate']");
	Thread.sleep(1000);
	code = driver.findElement(By.xpath("//input[@name='code']")).getAttribute("value");
	System.out.println(code);
    return this;
}
public AdminCouponCodePage enterCouponCode(String data)
{
	enterByXpath("//input[@name='code']", data);
	return this;
}
public AdminCouponCodePage clickUpdate()
{
	clickByXpath("//button[@class='btn btn-primary editcoupon']");
	return this;
}
public AdminCouponCodePage clickEditUpdate()
{
	
	clickByXpath("(//button[@class='btn btn-primary editcoupon'])[5]");
	return this;
}
public AdminCouponCodePage assignToTours(String Val)
{
	selectVisibleTextByXpath("//select[@class='chosen-multi-select select2-offscreen']", Val);
	return this;
     
}           

public AdminCouponCodePage assignToCars(String Val)
{
selectVisibleTextByXpath("(//select[@class='chosen-multi-select select2-offscreen'])[2]", Val);
return this;
}

public AdminCouponCodePage clickSubmit() throws InterruptedException
{
	clickByXpath("//button[@class='btn btn-primary submitcoupon']");
	Thread.sleep(3000);
	return this;
}
public AdminCouponCodePage verifyCouponCode()
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
               WebElement text = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr["+i+"]/td[4]"));
               String test = text.getText();
               

                if(test.equalsIgnoreCase(code))
                {
                	
                	System.out.println("The searched" +code+ "is found");
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
public AdminCouponCodePage verifyCouponCodewithName(String codename)
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
               WebElement text = driver.findElement(By.xpath("//table[@class='xcrud-list table table-striped table-hover']/tbody/tr["+i+"]/td[4]"));
               String test = text.getText();
               

                if(test.equalsIgnoreCase(codename))
                {
                	
                	System.out.println("The searched" +codename+ "is found");
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
public AdminCouponCodePage editCouponCodeValue(String Val,String data)
{
	selectVisibleTextByXpath("(//div[@class='col-md-8']/select)[6]", Val);
	enterByXpath("(//div[@class='col-md-6']/input[@placeholder='Maximum Uses'])[5]", data);
	return this;
}
public AdminCouponCodePage close()
{
	clickByClassName("close");
	return this;
}

public AdminCouponCodePage sortCouponCode()
{
	clickByXpath("//th[@class='xcrud-column xcrud-action xcrud-current xcrud-desc' or @class='xcrud-column xcrud-action xcrud-current xcrud-asc']");
	return this;
}




}
