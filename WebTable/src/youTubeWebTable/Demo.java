package youTubeWebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo 
{
	@Test
	public void searchProduct() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "D://learning//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/Admin/Product/List");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[@id='products-grid_next']")).click();
		
			Thread.sleep(3000);
			for(int j=1;j<=15;j++)
			{
				String t = driver.findElement(By.xpath("//tr[" +j+ "]/td[3]")).getText();
				System.out.println(t);
			}
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

		driver.findElement(By.xpath("//li[@id='products-grid_next']")).click();
		
		Thread.sleep(3000);
		for(int j=1;j<=15;j++)
		{
			String t = driver.findElement(By.xpath("//tr[" +j+ "]/td[3]")).getText();
			System.out.println(t);
		}
	Thread.sleep(2000);
	JavascriptExecutor jsa = (JavascriptExecutor) driver;
	jsa.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	
		
	}
}
