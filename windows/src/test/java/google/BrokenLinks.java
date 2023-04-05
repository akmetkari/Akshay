package google;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks 
{
	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "D://learning//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		
		int resCode= 200;
		int brokenCounter=0;
		
		System.out.println("Total links on page are "+linkList.size());
		
		for(WebElement element: linkList)
		{
			String url = element.getAttribute("href");
			
			try {
				URL urlLink = new URL(url);
				HttpURLConnection huc = (HttpURLConnection) urlLink.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				
				resCode = huc.getResponseCode();
				if (resCode>=400)
				{
					System.out.println(url+"broken link");
					brokenCounter++;
				}
				
				
			}
			catch(MalformedURLException e)
			{
				
			}
			
			
		}
		System.out.println("Total broken links are "+brokenCounter);
		
		
		
		
	}
}
