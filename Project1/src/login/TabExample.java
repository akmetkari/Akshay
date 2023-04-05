package login;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabExample 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
		
		driver.get("https://courses.letskodeit.com/practice");
		
		driver.manage().window().maximize();
		String parentWindowHanle = driver.getWindowHandle();
		
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[@id='opentab']")).click();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(handles))
			{
				driver.switchTo().window(handle);
				Thread.sleep(2000);
			}
		}
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentWindowHanle);
		System.out.println(driver.getTitle());
		
	}
}
