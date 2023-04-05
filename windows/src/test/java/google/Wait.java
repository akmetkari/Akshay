package google;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wait 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D://learning//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		//implicit wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.className("gLFyf")).sendKeys("hello");
		driver.findElement(By.className("gNO89b")).sendKeys(Keys.ENTER);
		
		
		
		
		
		
	}
}
