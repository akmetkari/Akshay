package module2;
 
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver;  
public class Assignment1_Firefox
{
	public static void main(String[] args) throws InterruptedException 
	{  
	     // System Property for Gecko Driver   
		System.setProperty("webdriver.gecko.driver","D:\\learning\\drivers\\geckodriver.exe" );  
		          
		          
		    WebDriver driver= new FirefoxDriver();  
		          
		         // Launch Website  
		    driver.get("https://www.google.com");
			driver.manage().window().maximize();
			System.out.println(driver.getCurrentUrl());
			driver.navigate().to("https://www.selenium.dev");
			System.out.println(driver.getCurrentUrl());
			driver.navigate().back();
			System.out.println(driver.getCurrentUrl());
			driver.navigate().forward();
			System.out.println(driver.getCurrentUrl());
			driver.navigate().refresh();
			System.out.println(driver.getCurrentUrl());
			
			driver.close();      
		      
	}
}
