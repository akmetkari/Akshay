package module2;

import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver;  
public class Assignment3 
{
	public static void main(String[] args) throws InterruptedException 
	{  
	     // System Property for Gecko Driver   
		System.setProperty("webdriver.gecko.driver","D:\\learning\\drivers\\geckodriver.exe" );  
		          
		          
		    WebDriver driver= new FirefoxDriver();  
		          
		         // Launch Website  
		    driver.get("https://www.google.com");
			Thread.sleep(5000);
			
			String title = driver.getTitle();
			System.out.println(title);
			
			driver.close();
			
			  
	}
}
