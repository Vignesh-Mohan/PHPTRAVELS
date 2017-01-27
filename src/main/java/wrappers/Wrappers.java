package wrappers;

public interface Wrappers 
{
		public void invokeApp(String browser,String LoginAs);	
		
		//Sending data to the text boxes
		public void enterById(String ID, String data);
		
		public void enterByName(String Name, String data);
		
		public void enterByClass(String ClassName, String data);
		
		public void enterByXpath(String XpathVal, String data);
		
		//Click an element
		public void clickById(String id);
		
		public void clickByClassName(String classVal);
		
		public void clickByName(String name);
		
		public void clickByLink(String linkName);
		
		public void clickByXpath(String XpathVal);
		
		//Select an item from drop down
		public void selectVisibleTextById(String ID, String Val);
		
		public void selectVisibleTextByName(String Name, String Val);
		
		public void selectVisibleTextByClass(String Class, String Val);
		
		public void selectVisibleTextByXpath(String XpathVal, String Val);
		
		
		
		public void selectIndexById(String id, String value);
		
		//Get the text from an element
		public String getTextById(String ID);
		
		public String getTextByName(String Name);
		
		public String getTextByClass(String Class);
		
		public String getTextByLinkText(String LinkText);
		
		public String getTextByXpath(String Xpath);
		
		//Verifying Web page title
		public void verifyTitle(String title);
		
		public void verifyTextById(String id, String text);
		
		public void verifyTextByXpath(String xpath, String text);
		
		public void verifyTextContainsByXpath(String xpath, String text);
		
		public void verifyTextContainsById(String id, String text);
		
		//Alert Handling
		public void acceptAlert();
		
		public void cancelAlert();
				
		//Window handling
		public void switchToParentWindow();
			
		public void switchToLastWindow();
		
		//Closing the opened browser
		public void closeBrowser();
		
		//Quit the browser
		public void quitBrowser();
	
	
	
}
