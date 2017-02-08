package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class PO {

	public static String data= "oprah@yopmail.com";
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
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

	}

}
