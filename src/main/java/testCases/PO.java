package testCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class PO {

	public static String data= "oprah@yopmail.com";
	public static void main(String[] args) throws InterruptedException {
		
	/*	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://phptravels.net/admin/newsletter/");
		
		System.out.println(driver.getTitle());
		
		try {
			List<WebElement> tables= driver.findElements(By.tagName("table"));
			for(WebElement table : tables)
			{
				List<WebElement>rows=driver.findElements(By.tagName("tr"));
				
				for(int i=0;i<rows.size();i++)
				{
					List<WebElement> columns = driver.findElements(By.tagName("td"));
					
					for(int j=0;j<columns.size();j++)
					{
						if(columns.get(j).getText().equalsIgnoreCase(data))
						{
							System.out.println("The entered Text "+data+"matches with "+columns.get(j).getText()+"PASS");
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("The entered Text "+data+" does not match"+"FAIL");
		}

	}*/
		
		DateFormat dateformat = new SimpleDateFormat("dd//MM//yyyy");
		Date date = new Date();
		String currentdate = dateformat.format(date);
		System.out.println(currentdate);
		String pdate =currentdate.substring(0, 2);
		System.out.println(pdate);
		int ipdate = Integer.parseInt(pdate);
		
		int ipickupdate = ipdate +2;
		int ipickoffdate = ipdate +6;
		
		System.out.println(ipickupdate);
		System.out.println(ipickoffdate);
		
		String pickupdate = String.valueOf(ipickupdate);
		
		String pickoffdate = String.valueOf(ipickoffdate);
		
	}		

}
