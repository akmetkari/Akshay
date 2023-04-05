package youTubeWebTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SecondWebTable 
{
	@Test
	public void searchProduct() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "D://learning//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/Admin/Product/List");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button")).click();
		boolean flag= true;
		
		
		for (int i=2;i<=4;i++)
		{
			
			Thread.sleep(3000);
			for(int j=1;j<=15 && flag;j++)
			{
				String t = driver.findElement(By.xpath("//tr[" +j+ "]/td[3]")).getText();
				System.out.println(t);
				if (t.equalsIgnoreCase("windows 8 pro"))
				{
					String price = driver.findElement(By.xpath("//tr[" +j+ "]/td[5]")).getText();
					System.out.println("The price of said article is "+price);
					flag=false;
				}
				
			}
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		
		if (i<4)
		driver.findElement(By.xpath("//a[normalize-space()=" +i+ "]")).click();
		
		
		}
		
	}
}
