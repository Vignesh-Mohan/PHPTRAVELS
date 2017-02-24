package testCases;

import org.testng.annotations.Test;

import pages.AdminLoginPage;




import org.testng.annotations.BeforeClass;

import wrappers.PHP_Wrapper;


public class TC075 extends PHP_Wrapper {


	@BeforeClass
	public void TC075Data()
	{
		browserName = "chrome";
		LoginAS="admin";
		testCaseName = "TC075";
		testDescription = "To view verify the bgcolour of the booking status.";
		category = "P2";
		authors = "Vignesh Mohan";
	//	dataSheetName = "";
	}
	
	
	@Test(groups="P2")
	public void runTC075() throws Throwable 
	{
		/*String bgcolor="rgba(251, 180, 80, 1)";
		System.out.println("bg color: "+bgcolor);
		
		String partialRGB = bgcolor.substring(bgcolor.indexOf("(") + 1, bgcolor.indexOf(")"));;
		System.out.println("bg color: substringed  "+partialRGB);
		
 		partialRGB=partialRGB.replace(",","");
 		System.out.println("bg color: replaced  "+partialRGB);
 		
 		partialRGB=partialRGB.replace(" ","");
 		System.out.println("bg color: whitespace removed  "+partialRGB);
 		
 		int RBG_Number=Integer.valueOf(partialRGB);
        System.out.println("RGBNumber: "+RBG_Number);*/
		
		
		new AdminLoginPage(driver, test)
		.enterUsername("admin@phptravels.com")
		.enterPassowrd("demoadmin")
		.clickLogin()
		.clickOnBookingMenu()
		.clickSearchButton()
		.searchWithParticulars("4185")
		.checkBgColorofStatus("4185");
		
	
		
			
		
	}

}
