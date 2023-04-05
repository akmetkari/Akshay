package module3;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Assignment2 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D://learning//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().window().maximize();
		String Title = driver.getTitle();
		System.out.println(Title);
		
		driver.switchTo().frame("login_page");
		driver.findElement(By.linkText("Know More...")).click();
		
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		
		System.out.print(driver.getTitle());
		driver.close();
		
		Thread.sleep(3000);
		driver.switchTo().window(list.get(0));
		System.out.println("  ");
		System.out.println(driver.getTitle());
		driver.close();
	
	}
}
