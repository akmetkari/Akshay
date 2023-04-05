package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D://learning//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("facebook",Keys.ENTER);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a//h3[text()='Facebook - log in or sign up']")).click();
		
		
	}
}
