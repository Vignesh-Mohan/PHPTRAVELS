package wrappers;

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
	public void selectVisibleTextById(String ID, String Val) throws Exception;
	public void selectVisibleTextByName(String Name, String Val) throws Exception;
	public void selectVisibleTextByClass(String Class, String Val) throws Exception;
	public void selectVisibleByXpath(String XpathVal, String Val) throws Exception;
	public void selectIndexById(String ID, String Val) throws Exception;
	public void selectIndextByName(String Name, String Val) throws Exception;
	public void selectIndextByClass(String Class, String Val); 
	public void selectIndexpath(String XpathVal, String Val) throws Exception;
	public String getTextById(String IDVal) throws Exception;
	public String getTextByName(String Name) throws Exception;
	public String getTextByClass(String Class) throws Exception;
	public String getTextByLinkText(String LinkText) throws Exception;
	public String getTextByXpath(String XpathVal) throws Exception;
	public boolean verifyTitle(String title) throws Exception;
	


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
	
}
