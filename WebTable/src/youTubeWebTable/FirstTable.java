package youTubeWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTable 
{
	@Test
	public void tableInfo()
	{
		System.setProperty("webdriver.chrome.driver", "D://learning//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();
		
		String s = driver.findElement(By.xpath("//table[contains(@id,'table1')]//td[2]")).getText();
		System.out.println("string is "+s);
		
		
		List<WebElement>list = driver.findElements(By.xpath("//table[contains(@id,'table1')]//tr"));
			
		System.out.println(list.size());
		for (int i=1;i<list.size();i++)
		{	
			if (driver.findElement(By.xpath("//table[contains(@id,'table1')]//tr[" +i +"]//td[2]"))
				.getText().equals("John"))
			{
				String lastName= driver.findElement(By.xpath("//table[contains(@id,'table1')]//tr[" +i +"]//td[1]")).getText();
				System.out.println(lastName);
				
				String email= driver.findElement(By.xpath("//table[contains(@id,'table1')]//tr[" +i +"]//td[3]")).getText();
				System.out.println(email);
				
				String due= driver.findElement(By.xpath("//table[contains(@id,'table1')]//tr[" +i +"]//td[4]")).getText();
				System.out.println(due);
				
				String website= driver.findElement(By.xpath("//table[contains(@id,'table1')]//tr[" +i +"]//td[5]")).getText();
				System.out.println(website);
				
				driver.findElement(By.xpath("//table[contains(@id,'table1')]//tr[\" +i +\"]//td[6]//a[2]")).click();
				System.out.println(driver.getCurrentUrl());
			}
		
		
		}
		
	}
}
