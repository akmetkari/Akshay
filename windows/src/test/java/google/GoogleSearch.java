package google;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch 
{
		public static void main(String[] args) 
		{
			
			System.setProperty("webdriver.chrome.driver", "D:\\learning\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			driver.manage().window().maximize();
			driver.findElement(By.id("inputUsername")).sendKeys("rahul");

			driver.findElement(By.name("inputPassword")).sendKeys("hello123");

			driver.findElement(By.className("signInBtn")).click();

			System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

			driver.findElement(By.linkText("Forgot your password?")).click();


			
			
		}
}
