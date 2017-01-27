package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.ExtentTest;

import basket.Reporter;

public class GenericWrapper extends Reporter implements Wrappers 

{
	//Variables
	public RemoteWebDriver driver;
	public ExtentTest test;
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
	
	public GenericWrapper(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
	}
	
	//

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

			System.out.println("Browser launch failed -->"+e.getMessage());
		}
		
		
	}

	public void enterById(String ID, String data) {
		
		try
		{
			driver.findElement(By.id(ID)).sendKeys(data);
			
		}
		catch(ElementNotFoundException e)
		{
			System.out.println("The element "+ ID +" not Found");
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("The element "+ ID +" not Visible");
		}
	}

	public void enterByName(String Name, String data) {
		try
		{
			driver.findElement(By.name(Name)).sendKeys(data);
		}
		catch(ElementNotFoundException e)
		{
			System.out.println("The element "+ Name +" not Found");
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("The element "+ Name +" not Visible");
		}
		
	}

	public void enterByClass(String ClassName, String data) {
		try
		{
			driver.findElement(By.className(ClassName)).sendKeys(data);
		}
		catch(ElementNotFoundException e)
		{
			System.out.println("The element "+ ClassName +" not Found");
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("The element "+ ClassName +" not Visible");
		}
		
	}

	public void enterByXpath(String XpathVal, String data) {
		try
		{
			driver.findElement(By.xpath(XpathVal)).sendKeys(data);
		}
		catch(ElementNotFoundException e)
		{
			System.out.println("The element "+ XpathVal +" not Found");
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("The element "+ XpathVal +" not Visible");
		}
	}

	public void clickById(String id) {
		try
		{
			driver.findElement(By.id(id)).click();
		}
		catch(ElementNotFoundException e)
		{
			System.out.println("The element "+ id +" not Found");
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("The element "+ id +" not Visible");
		}
		
	}

	public void clickByClassName(String classVal) {
		try
		{
			driver.findElement(By.className(classVal)).click();
		}
		catch(ElementNotFoundException e)
		{
			System.out.println("The element "+ classVal +" not Found");
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("The element "+ classVal +" not Visible");
		}
		
	}

	public void clickByName(String name) {
		try
		{
			driver.findElement(By.name(name)).click();
		}
		catch(ElementNotFoundException e)
		{
			System.out.println("The element "+ name +" not Found");
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("The element "+ name +" not Visible");
		}
		
	}

	public void clickByLink(String linkName) {
		try
		{
			driver.findElement(By.linkText(linkName)).click();
		}
		catch(ElementNotFoundException e)
		{
			System.out.println("The element "+ linkName +" not Found");
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("The element "+ linkName +" not Visible");
		}
		
		
	}

	public void clickByXpath(String XpathVal) {
		try
		{
			driver.findElement(By.xpath(XpathVal)).click();
		}
		catch(ElementNotFoundException e)
		{
			System.out.println("The element "+ XpathVal +" not Found");
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("The element "+ XpathVal +" not Visible");
		}
		
	}

	public void selectVisibileTextById(String ID, String Val) {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown = driver.findElement(By.id(ID));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected text was successfully Selected" , "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected text was not found on the Web page" , "FAIL");
		}
	}

	public void selectIndexById(String ID, String Val) {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown = driver.findElement(By.className(ID));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected value was successfully selected based on the index given" , "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected value was not found on the Webpage for the provided index" , "FAIL");
		}
		
	}

	public String getTextById(String idVal) {
		
		try{
			return  driver.findElementById(idVal).getText();
			
		} catch (Exception e) {
			reportStep("The element with id: "+idVal+" could not be found.", "FAIL");
		}
			
		return null;
	}


	public String getTextByName(String Name) {
		// TODO Auto-generated method stub
		try{
		return driver.findElement(By.name(Name)).getText();
		} catch (Exception e) {
			reportStep("The element with name: "+Name+" could not be found.", "FAIL");
		}
			
		return null;
	}

	public String getTextByClass(String Class) {
		// TODO Auto-generated method stub
		try{
		return driver.findElement(By.className(Class)).getText();
		} catch (Exception e) {
			reportStep("The element with name: "+Class+" could not be found.", "FAIL");
		}
			
		return null;
	}

	public String getTextByLinkText(String LinkText) {
		// TODO Auto-generated method stub
		try{
		return driver.findElement(By.linkText(LinkText)).getText();
		} catch (Exception e) {
			reportStep("The element with name: "+LinkText+" could not be found.", "FAIL");
		}
			
		return null;
	}
	
	public String getTextByXpath(String XpathVal) {
		// TODO Auto-generated method stub
		try{
		return driver.findElement(By.xpath(XpathVal)).getText();
		} catch (Exception e) {
			reportStep("The element with name: "+XpathVal+" could not be found.", "FAIL");
		}
			
		return null;
	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		try {
			String vTitle = driver.getTitle();
			vTitle.equals(title);
			reportStep("Title was same" , "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Title mismatches" , "FAIL");
		}
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

	public void selectVisibleTextById(String ID, String Val) {
		try {
			WebElement dropdown = driver.findElement(By.id(ID));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected text was successfully Selected" , "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected text was not found on the Webpage" , "FAIL");
		}
		
	}

	public void selectVisibleTextByXpath(String XpathVal, String Val) {
		try {
			WebElement dropdown = driver.findElement(By.xpath(XpathVal));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected text was successfully Selected" , "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected text was not found on the Webpage" , "FAIL");
		}
		
	}

	public void selectVisibleTextByName(String Name, String Val) {
		
		
		try {
			WebElement dropdown = driver.findElement(By.name(Name));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected text was successfully Selected" , "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected text was not found on the Webpage" , "FAIL");
		}
	}

	public void selectVisibleTextByClass(String Class, String Val) {
		// TODO Auto-generated method stub
		
		try {
			WebElement dropdown = driver.findElement(By.className(Class));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected text was successfully Selected" , "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected text was not found on the Webpage" , "FAIL");
		}
		
	}

	public void selectVisibleByXpath(String XpathVal, String Val) {
		// TODO Auto-generated method stub
		
		try {
			WebElement dropdown = driver.findElement(By.className(XpathVal));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected text was successfully Selected" , "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected text was not found on the Webpage" , "FAIL");
		}
		
	}

	public void selectIndexByName(String Name, String Val) {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown = driver.findElement(By.className(Name));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected value was successfully selected based on the index given" , "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected value was not found on the Webpage for the provided index" , "FAIL");
		}
	}

	public void selectIndextByClass(String Class, String Val) {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown = driver.findElement(By.className(Class));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected value was successfully selected based on the index given" , "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected value was not found on the Webpage for the provided index" , "FAIL");
		}
	}

	public void selectIndexpath(String XpathVal, String Val) {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown = driver.findElement(By.className(XpathVal));
			Select dd = new Select(dropdown);
			dd.selectByVisibleText(Val);
			reportStep("Expected value was successfully selected based on the index given" , "PASS");
		} catch (ElementNotFoundException e) {
			reportStep("Expected value was not found on the Webpage for the provided index" , "FAIL");
		}
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
