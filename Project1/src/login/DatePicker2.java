package login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker2 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		
		driver.manage().window().maximize();
		driver.findElement(By.id("datepicker1")).click();
		Thread.sleep(3000);
		
		String Ex_month= "December 2022";
		String day ="31";
		while(true)
		{
			String month= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			if(Ex_month.equals(month))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//a[@title=\"Prev\"]/span")).click();
			}
		}
		
		List<WebElement> allDates = driver.findElements(By.xpath("//table/tbody/tr/td"));
		for(WebElement el: allDates)
		{
			String dt = el.getText();
			if(dt.equals(day))
			{
				el.click();
				break;
			}
		}
		
	}
}
