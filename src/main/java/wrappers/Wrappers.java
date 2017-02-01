package wrappers;

import org.openqa.selenium.WebElement;

public interface Wrappers 
{
	public void invokeApp(String browser, String LoginAs);
	public void enterById(String ID, String data);
	public void enterByName(String Name, String data);
	public void enterByClass(String ClassName, String data);
	public void enterByXpath(String XpathVal, String data);
	public void clickById(String id);
	public void clickByClassName(String classVal);
	public void clickByName(String name);
	public void clickByLink(String linkName);
	public void clickByXpath(String XpathVal);
	public void selectVisibleTextById(String ID, String Val);
	public void selectVisibleTextByName(String Name, String Val) ;
	public void selectVisibleTextByClass(String Class, String Val) ;
	public void selectVisibleByXpath(String XpathVal, String Val) ;
	public void selectIndexById(String ID, String Val) ;
	public void selectIndextByName(String Name, String Val) ;
	public void selectIndextByClass(String Class, String Val); 
	public void selectIndexpath(String XpathVal, String Val) ;
	public String getTextById(String IDVal) ;
	public String getTextByName(String Name) ;
	public String getTextByClass(String Class) ;
	public String getTextByLinkText(String LinkText) ;
	public String getTextByXpath(String XpathVal) ;
	public boolean verifyTitle(String title) ;
	


	public void verifyTextById(String id, String text);
	/**
	 * This method will verify the Text using the attribute ID and return the boolean value
	 * @param id- ID of the element
	 * @param text- Text to be verified
	 * @author Vignesh.mohan
	 */
	
	public void verifyTextByXpath(String xpath, String text);
	/**
	 * This method will verify the Text using the attribute Xpath and return the boolean value
	 * @param xpath- xpath of the element
	 * @param text- Text to be verified
	 * @author Vignesh.mohan
	 */
	
	public void verifyTextContainsByXpath(String xpath, String text);
	/**
	 * This method will verify if the given text is available in the element using attribute XPath
	 * @param xpath- xpath of the element
	 * @param text- Text to be verified
	 * @author Vignesh.mohan
	 */
	
	public void verifyTextContainsById(String id, String text);
	/**
	 * This method will verify if the given text is available in the element using attribute id
	 * @param id- id of the element
	 * @param text- Text to be verified
	 * @author Vignesh.mohan
	 */
	
	public void acceptAlert();
	/**
	 * This method will switch the control to Alert and accept the alert.
	 * @author Vignesh.mohan
	 */
	
	public void cancelAlert();
	/**
	 * This method will switch the control to Alert and Dismiss the alert.
	 * @author Vignesh.mohan
	 */
	
	public void switchToParentWindow();
	/**
	 * This method will switch the control to the Parent Window
	 * @author Vignesh.mohan
	 */
	
	public void switchToLastWindow();
	/**
	 * This method will switch the control to the Last Window
	 * @author Vignesh.mohan
	 */
	
	public void closeBrowser();
	/**
	 * This method will close all the browsers
	 * @author Vignesh.mohan
	 */
	
	public void quitBrowser();
	/**
	 * This method will close all the browsers
	 * @author Vignesh.mohan
	 */
	
	public void daysPicker_UsingXpath(String XpathVal,String dateVal);
	/**
	 * This method will pick the date in the datepicker using xpath
	 * @author Vignesh.mohan
	 */
	
	public void action_MoveElement_UsingXpath(String xpathval,int x,int y);
	/**
	 * This method will move the element from position 1 to position 2
	 * XpathValP1 - xpathvalue of the element from position1
	 * @author Vignesh.mohan
	 */
	
	

	public void action_MoveElement_Usingid(String id,int x,int y);
	/**
	 * This method will move the element from position 1 to position 2
	 * Id - Id of the element from position1
	 * 
	 * @author Vignesh.mohan
	 */
	
	public void expectedWait_ElementToBeVisible(WebElement element);
	/**
	 * This method will wait until element is visible
	 * @author Vignesh.mohan
	 */
	
	public void switch_ToFrame(String xpathval);
	/**
	 * This method will switch the focus to the frame
	 * @author Vignesh.mohan
	 */
	
	public void switch_To_DefaultContent();
	/**
	 * This method will switch the focus to the Default Content
	 * @author Vignesh.mohan
	 */
}
