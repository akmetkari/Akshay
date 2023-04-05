package module2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1_Chrome 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//#Module 2 - Assignment 2 
		System.setProperty("webdriver.chrome.driver","D:\\learning\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close();
	}
}
