package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.ExtentTest;

import basket.Reporter;

public class GenericWrapper extends Reporter implements Wrappers 

{
	
	public GenericWrapper(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
	}
	
	//Variables
	public RemoteWebDriver driver;
	
	public String URL;
	public static Properties prop;
	
	public GenericWrapper()
	{
		prop = new Properties();
		
		try 
		{
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

}
	
	//Invoking the browser with the URL
	public void invokeApp(String browser, String LoginAs)  
	{
		try
		{
			LoginAs=LoginAs.toLowerCase();
			
			if(LoginAs.equals("admin"))
				URL=prop.getProperty("Admin_URL");
			else if(LoginAs.equals("user"))
				URL=prop.getProperty("UserURL");
			else
				URL=prop.getProperty("paytmURL");
				//Browser Launch
			
			browser=browser.toLowerCase();
			
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equals("firefox"))
			{
				System.setProperty("webdriver.firefox.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equals("ie"))
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/internetexplorerdriver.exe");
				driver = new InternetExplorerDriver();
			}
			//Maximizing the browser
			driver.manage().window().maximize();
			
			//Implicit wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Launching the URL to the browser
			driver.get(URL);
			
			reportStep("The browser:" + browser + " launched successfully", "PASS");

			
		}
		catch(WebDriverException e)
		{
			reportStep("The browser:" + browser + " could not be launched successfully", "FAIL");

			reportStep("Browser launch failed -->"+e.getMessage(),"FAIL");
		}
		
		
	}

	public void enterById(String ID, String data) {
		
		try
		{
			driver.findElement(By.id(ID)).sendKeys(data);
			reportStep("The data: "+data+" entered successfully in field :"+ID, "PASS");
			
		}
		catch(ElementNotFoundException e)
		{
			reportStep("The element "+ ID +" not Found","FAIL");
		}
		catch(ElementNotVisibleException e)
		{
			reportStep("The element "+ ID +" not Visible","FAIL");
		}
		catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
	}

	public void enterByName(String Name, String data) {
		try
		{
			driver.findElement(By.name(Name)).sendKeys(data);
			reportStep("The data: "+data+" entered successfully in field :"+Name, "PASS");
		}
		catch(ElementNotFoundException e)
		{
			reportStep("The element "+ Name +" not Found","FAIL");
		}
		catch(ElementNotVisibleException e)
		{
			reportStep("The element "+ Name +" not Visible","FAIL");
		}
		catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
		
	}

	public void enterByClass(String ClassName, String data) {
		try
		{
			driver.findElement(By.className(ClassName)).sendKeys(data);
			reportStep("The data: "+data+" entered successfully in field :"+ClassName, "PASS");
		}
		catch(ElementNotFoundException e)
		{
			reportStep("The element "+ ClassName +" not Found","FAIL");
		}
		catch(ElementNotVisibleException e)
		{
			reportStep("The element "+ ClassName +" not Visible","FAIL");
		}
		catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
		
	}

	public void enterByXpath(String XpathVal, String data) {
		try
		{
			driver.findElement(By.xpath(XpathVal)).clear();
			driver.findElement(By.xpath(XpathVal)).sendKeys(data);
			reportStep("The data: "+data+" entered successfully in field :"+XpathVal, "PASS");
		}
		catch(ElementNotFoundException e)
		{
			reportStep("The element "+ XpathVal +" not Found","FAIL");
		}
		catch(ElementNotVisibleException e)
		{
			reportStep("The element "+ XpathVal +" not Visible","FAIL");
		}
		catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
	}

	public void clickById(String id) {
		try
		{
			driver.findElement(By.id(id)).click();
			reportStep("The element: "+id+" was clicked successfully", "PASS");
		}
		catch(ElementNotFoundException e)
		{
			reportStep("The element "+ id +" not Found","FAIL");
		}
		catch(ElementNotVisibleException e)
		{
			reportStep("The element "+ id +" not Visible","FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
		
	}

	public void clickByClassName(String classVal) {
		try
		{
			driver.findElement(By.className(classVal)).click();
			reportStep("The element: "+classVal+" was clicked successfully", "PASS");
		}
		catch(ElementNotFoundException e)
		{
			reportStep("The element "+ classVal +" not Found","FAIL");
		}
		catch(ElementNotVisibleException e)
		{
			reportStep("The element "+ classVal +" not Visible","FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
		
	}

	public void clickByName(String name) {
		try
		{
			driver.findElement(By.name(name)).click();
			reportStep("The element: "+name+" was clicked successfully", "PASS");
		}
		catch(ElementNotFoundException e)
		{
			reportStep("The element "+ name +" not Found","FAIL");
		}
		catch(ElementNotVisibleException e)
		{
			reportStep("The element "+ name +" not Visible","FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error,The element "+ name +" not Found","FAIL");
			}
		
	}

	public void clickByLink(String linkName) {
		try
		{
			driver.findElement(By.linkText(linkName)).click();
			reportStep("The element: "+linkName+" was clicked successfully", "PASS");
		}
		catch(ElementNotFoundException e)
		{
			reportStep("The element "+ linkName +" not Found","FAIL");
		}
		catch(ElementNotVisibleException e)
		{
			reportStep("The element "+ linkName +" not Visible","FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
		
		
	}

	public void clickByXpath(String XpathVal) {
		try
		{
			driver.findElement(By.xpath(XpathVal)).click();
			reportStep("The element: "+XpathVal+" was clicked successfully", "PASS");
		}
		catch(ElementNotFoundException e)
		{
			reportStep("The element "+ XpathVal +" not Found","FAIL");
		}
		catch(ElementNotVisibleException e)
		{
			reportStep("The element "+ XpathVal +" not Visible","FAIL");
		}catch (Exception e) {
			
			reportStep("The element "+ XpathVal +" not Found","FAIL");
			}
		
	}
	/*
	 * This method will select the drop down Visible Text using "ID" as locator.
	 * @param ID - "id" locator of the drop down. 
	 * @param Val - Value to be selected from the drop down list(Visible Text).
	 * @author SatheeshKanth.Paramasivam
	 */
	public void selectVisibleTextById(String ID, String Val)  {
		try {
			WebElement dropdown = driver.findElement(By.id(ID));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected text: "+Val+" was selected successfully", "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected text: "+Val+" was not found on the Webpage", "FAIL");
		}
		catch (ElementNotVisibleException e) {
			reportStep("Expected text: "+Val+" is not visible on the Webpage", "FAIL");
		}catch (Exception e) {
			
			reportStep("Expected text: "+Val+" was not found on the Webpage", "FAIL");
			}
	}

	/*
	 * This method will select the drop down Visible Text using "Name" as locator. 
	 * @param Name - "Name" locator of the drop down. 
	 * @param Val - Value to be selected from the drop down list(Visible Text).
	 * @author SatheeshKanth.Paramasivam
	 */
	public void selectVisibleTextByName(String Name, String Val)  {
		try {
			WebElement dropdown = driver.findElement(By.name(Name));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected text: "+Val+" was selected successfully", "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected text: "+Val+" was not found on the Webpage", "FAIL");
		}
		catch (ElementNotVisibleException e) {
			reportStep("Expected text: "+Val+" is not visible on the Webpage", "FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
	}

	/*
	 * This method will select the drop down Visible Text using "Class" as locator. 
	 * @param Name - "Class" locator of the drop down. 
	 * @param Val - Value to be selected from the drop down list(Visible Text).
	 * @author SatheeshKanth.Paramasivam
	 */
	public void selectVisibleTextByClass(String Class, String Val)  {
		try {
						
			WebElement dropdown = driver.findElement(By.className(Class));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected text: "+Val+" was selected successfully", "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected text: "+Val+" was not found on the Webpage", "FAIL");
		}
		catch (ElementNotVisibleException e) {
			reportStep("Expected text: "+Val+" is not visible on the Webpage", "FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}	}

	/*
	 * This method will select the drop down Visible Text using "XpathVal" as locator. 
	 * @param XpathVal - "XpathVal" locator of the drop down. 
	 * @param Val - Value to be selected from the drop down list(Visible Text).
	 * @author SatheeshKanth.Paramasivam
	 */
	public void selectVisibleByXpath(String XpathVal, String Val)  {
		try {
			WebElement dropdown = driver.findElement(By.className(XpathVal));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected text: "+Val+" was selected successfully", "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected text: "+Val+" was not found on the Webpage", "FAIL");
		}
		catch (ElementNotVisibleException e) {
			reportStep("Expected text: "+Val+" is not visible on the Webpage", "FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
	}

	/*
	 * This method will select the value from the drop down using Index as "ID" locator. 
	 * @param ID - "ID" locator of the drop down. 
	 * @param Val - Value to be selected from the drop down.
	 * @author SatheeshKanth.Paramasivam
	 */
	public void selectIndexById(String ID, String Val)  {
		try {
			WebElement dropdown = driver.findElement(By.className(ID));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected text: "+Val+" was selected successfully", "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected text: "+Val+" was not found on the Webpage", "FAIL");
		}
		catch (ElementNotVisibleException e) {
			reportStep("Expected text: "+Val+" is not visible on the Webpage", "FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
	}

	/*
	 * This method will select the drop down using Index as "Name" locator. 
	 * @param Name - "Name" locator of the drop down. 
	 * @param Val - Value to be selected from thedrop down.
	 * @author SatheeshKanth.Paramasivam
	 */
	public void selectIndextByName(String Name, String Val)  {
		try {
			WebElement dropdown = driver.findElement(By.name(Name));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected value: "+Val+" was selected successfully based on the index given", "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected value: "+Val+" was not found on the Webpage for the provided index", "FAIL");
		}catch (ElementNotVisibleException e) {
			reportStep("Expected value: "+Val+" is not visible on the Webpage for the provided index", "FAIL");
			}catch (Exception e) {
				reportStep("OOPS! Unknown Expection error ","FAIL");
				}
		}

	/*
	 * This method will select the drop down using Index as "Class" locator.
	 * @param Class - "Class" locator of the drop down. 
	 * @param Val - Value to be selected from the drop down.
	 * @author SatheeshKanth.Paramasivam
	 */
	public void selectIndextByClass(String Class, String Val) {
		try {
			WebElement dropdown = driver.findElement(By.className(Class));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected value: "+Val+" was selected successfully based on the index given", "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected value: "+Val+" was not found on the Webpage for the provided index", "FAIL");
		}catch (ElementNotVisibleException e) {
			reportStep("Expected value: "+Val+" is not visible on the Webpage for the provided index", "FAIL");
			}catch (Exception e) {
				
				reportStep("OOPS! Unknown Expection error ","FAIL");
				}
	}

	/*
	 * This method will select the drop down using Index as "XpathVal" locator.
	 * @param XpathVal - "XpathVal" locator of the drop down. 
	 * @param Val - Value to be selected from the drop down.
	 * @author SatheeshKanth.Paramasivam
	 */
	public void selectIndexpath(String XpathVal, String Val)  {
		try {
			WebElement dropdown = driver.findElement(By.className(XpathVal));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected value: "+Val+" was selected successfully based on the index given", "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected value: "+Val+" was not found on the Webpage for the provided index", "FAIL");
		}catch (ElementNotVisibleException e) {
			reportStep("Expected value: "+Val+" is not visible on the Webpage for the provided index", "FAIL");
			}catch (Exception e) {
				
				reportStep("OOPS! Unknown Expection error ","FAIL");
				}
	}

	/*
	 * This method will get the text of the element using "ID" as locator. 
	 * @param ID - "ID" locator of the element.
	 * @author SatheeshKanth.Paramasivam
	 */
	public String getTextById(String IDVal)  {
		String gText = driver.findElement(By.id(IDVal)).getText();
		try {
			reportStep("Text: "+gText+" was incurred successfully from the web page","PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Text: "+gText+" you are looking is not available on the Web page", "FAIL");
		}catch (ElementNotVisibleException e) {
			reportStep("Text: "+gText+" you are looking is not visible on the Web page", "FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
		return gText;
	}

	/*
	 * This method will get the text of the element using "Name" as locator.
	 * @param Name - "Name" locator of the element.
	 * @author SatheeshKanth.Paramasivam
	 */
	public String getTextByName(String Name)  {
		String gText = driver.findElement(By.name(Name)).getText();
		try {
			reportStep("Text: "+gText+" was incurred successfully from the web page","PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Text: "+gText+" you are looking is not available on the Web page", "FAIL");
		}catch (ElementNotVisibleException e) {
			reportStep("Text: "+gText+" you are looking is not visible on the Web page", "FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
		return gText;
	}

	/*
	 * This method will get the text of the element using "Class" as locator.
	 * @param Class - "Class" locator of the element.
	 * @author SatheeshKanth.Paramasivam
	 */
	public String getTextByClass(String Class)  {
		String gText = driver.findElement(By.className(Class)).getText();
		try {
			reportStep("Text: "+gText+" was incurred successfully from the web page","PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Text: "+gText+" you are looking is not available on the Web page", "FAIL");
		}catch (ElementNotVisibleException e) {
			reportStep("Text: "+gText+" you are looking is not visible on the Web page", "FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
		return gText;
	}

	/*
	 * This method will get the text of the element using "LinkText" as locator.
	 * @param LinkText - "LinkText" locator of the element.
	 * @author SatheeshKanth.Paramasivam
	 */
	public String getTextByLinkText(String LinkText)  {
		String gText = driver.findElement(By.linkText(LinkText)).getText();
		try {
			reportStep("Text: "+gText+" was incurred successfully from the web page","PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Text: "+gText+" you are looking is not available on the Web page", "FAIL");
		}catch (ElementNotVisibleException e) {
			reportStep("Text: "+gText+" you are looking is not visible on the Web page", "FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
		return gText;
	}

	/*
	 * This method will get the text of the element using "XpathVal" as locator.
	 * @param XpathVal - "XpathVal" locator of the element.
	 * @author SatheeshKanth.Paramasivam
	 */
	public String getTextByXpath(String XpathVal)  {
		String gText = driver.findElement(By.xpath(XpathVal)).getText();
		try {
			reportStep("Text: "+gText+" was incurred successfully from the web page","PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Text: "+gText+" you are looking is not available on the Web page", "FAIL");
		}catch (ElementNotVisibleException e) {
			reportStep("Text: "+gText+" you are looking is not visible on the Web page" , "FAIL");
		}catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error ","FAIL");
			}
		return gText;
	}

	/*
	 * This method will verify the tile of the browser. 
	 * @param title - "title" as displayed in browser.
	 * @author SatheeshKanth.Paramasivam
	 */
	public boolean verifyTitle(String title)  {
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			}else
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");

		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}
	/**
	 * This method will verify the Text using the attribute ID and return the boolean value
	 * @param id- ID of the element
	 * @param text- Text to be verified
	 * @author Vignesh.mohan
	 */
	public void verifyTextById(String id, String text) {
		
	try {
		String vtext =	driver.findElement(By.id(id)).getText();
		if(vtext.equalsIgnoreCase(text))
		{
			reportStep("The text "+vtext+" matches with the expected text value : "+text,"PASS");
		}
		else
		{
			reportStep("The text "+vtext+" does not matches with the expected text value: "+text,"FAIL");
		}
	} catch (Exception e) {
		
		reportStep("OOPS! Unknown Expection error occured while verifying the Title","FAIL");
		}
	}

	/**
	 * This method will verify the Text using the attribute Xpath and return the boolean value
	 * @param xpath- xpath of the element
	 * @param text- Text to be verified
	 * @author Vignesh.mohan
	 */
	public void verifyTextByXpath(String xpath, String text) {
		try {
			String vtext =	driver.findElement(By.id(xpath)).getText();
			if(vtext.equalsIgnoreCase(text))
			{
				reportStep("The text "+vtext+" matches with the expected text value : "+text,"PASS");
			}
			else
			{
				reportStep("The text "+vtext+" does not matches with the expected text value: "+text,"FAIL");
			}
		} catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error occured while verifying the Title","FAIL");
			}
		}

	/**
	 * This method will verify if the given text is available in the element using attribute XPath
	 * @param xpath- xpath of the element
	 * @param text- Text to be verified
	 * @author Vignesh.mohan
	 */
	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String vtext =	driver.findElement(By.id(xpath)).getText();
			if(vtext.contains(text))
			{
				reportStep("The text "+vtext+" contains the value : "+text,"PASS");
			}
			else
			{
				reportStep("The text "+vtext+" does not contains the  value: "+text,"FAIL");
			}
		} catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error occured while verifying the Title","FAIL");
			}
		
	}

	/**
	 * This method will verify if the given text is available in the element using attribute id
	 * @param id- id of the element
	 * @param text- Text to be verified
	 * @author Vignesh.mohan
	 */
	public void verifyTextContainsById(String id, String text) {
		try {
			String vtext =	driver.findElement(By.id(id)).getText();
			if(vtext.contains(text))
			{
				reportStep("The text "+vtext+" contains the value : "+text,"PASS");
			}
			else
			{
				reportStep("The text "+vtext+" does not contains the  value: "+text,"FAIL");
			}
		} catch (Exception e) {
			
			reportStep("OOPS! Unknown Expection error occured while verifying the Title","FAIL");
			}
		
	}
	
	/**
	 * This method will switch the control to Alert and accept the alert.
	 * @author Vignesh.mohan
	 */
	public void acceptAlert() {
		
		try {
			driver.switchTo().alert().accept();
			reportStep("The alert is accepted","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("OOPS! Alert is not handled","FAIL");
		}catch (Exception e) {
			reportStep("OOPS! Alert is not accepted","FAIL");
		}
	}

	/**
	 * This method will switch the control to Alert and Dismiss the alert.
	 * @author Vignesh.mohan
	 */
	public void cancelAlert() {
	
		try {
			driver.switchTo().alert().dismiss();
			reportStep("The alert is Dismissed","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("OOPS! Alert is not handled","FAIL");
		}catch (Exception e) {
			reportStep("OOPS! Alert is not Dismissed","FAIL");
		}
	}

	
	/**
	 * This method will switch the control to the Parent Window
	 * @author Vignesh.mohan
	 */

	public void switchToParentWindow() {
		
		try {
			Set<String>winHandles=driver.getWindowHandles();
			for(String wHandle : winHandles)
			{
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			reportStep("OOPS! The control didnot switched to the First/ParentWindow","FAIL");
		}
	}

	/**
	 * This method will switch the control to the Last Window
	 * @author Vignesh.mohan
	 */
	public void switchToLastWindow() {
		try {
			Set<String>winHandles=driver.getWindowHandles();
			for(String wHandle : winHandles)
			{
				driver.switchTo().window(wHandle);
				
			}
		} catch (Exception e) {
			reportStep("OOPS! The control didnot switched to the LastWindow","FAIL");
		}
	}
		
	/**
	 * This method will close all the browsers
	 * @author Vignesh.mohan
	 */

	public void closeBrowser() {
		
		try {
			driver.close();
		} catch (Exception e) {
			
			reportStep("The browser: "+ driver.getCapabilities().getBrowserName()+" could not be closed","FAIL");
		}
		
	}

	/**
	 * This method will close all the browsers
	 * @author Vignesh.mohan
	 */
	public void quitBrowser() {
		
		try {
			driver.quit();
		} catch (Exception e) {
			reportStep("The browser: "+ driver.getCapabilities().getBrowserName()+" could not be closed","FAIL");
		}
	}

	/**
	 * This method will pick the date in the datepicker using xpath
	 * @author Vignesh.mohan
	 */
	public void daysPicker_UsingXpath(String XpathVal,String dateVal)
	{
        try {
			WebElement day = driver.findElement(By.xpath(XpathVal));
			
			List<WebElement> rows = day.findElements(By.tagName("tr"));
			for(int i = 0;i<rows.size();i++)
			{
			       List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			       for(int j = 0;j<cols.size();j++)
			       {
			             if(cols.get(j).getText().equals(dateVal))
			             {
			                    cols.get(j).click();
			                    break;
			             }
			       }
			}
			reportStep("Date Selected ","Pass");
		}catch (StaleElementReferenceException e) {
			reportStep("Stale Element Exception ","INFO");
		} catch (Exception e) {
			reportStep("Date Not  Selected ","Fail");
		}
	}
	
	
	/**
	 * This method will move the element from position 1 to position 2
	 * XpathValP1 - xpathvalue of the element from position1
	 * 
	 * @author Vignesh.mohan
	 */

	public void action_moveElement(String XpathValP1)
	{
		Actions action = new Actions(driver);
		WebElement pos1 = driver.findElement(By.xpath(XpathValP1));
		action.clickAndHold(pos1)
			  .moveToElement(pos1, 150, 962)
			  .click()
			  .release()
			  .build()
			  .perform();
	}
	
	
	@Override
	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			reportStep("The browser has been closed.", "FAIL");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "WARN");
		}
		return number;
	}

}
