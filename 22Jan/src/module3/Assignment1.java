package module3;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D://learning//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("the title is "+title);
		
		Thread.sleep(2000);
		//driver.findElement(By.linkText("Know More...")).click();
		WebElement frame = driver.findElement(By.xpath("//frame[@name='login_page']"));
		driver.switchTo().frame(frame);
		//driver.findElement(By.xpath("//*[@id=\"nortonimg1\"]/div[2]/span[2]/a")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Know More')]")).click();
		driver.findElement(By.linkText("Know More...")).click();
		
		ArrayList<String>list = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(list.get(1));
		
		String titleNew = driver.getTitle();
		System.out.println(titleNew);
		
		driver.switchTo().window(list.get(0));
		driver.quit();
		
		
	}
}
