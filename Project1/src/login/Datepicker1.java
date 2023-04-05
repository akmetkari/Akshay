package login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker1 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		
		driver.manage().window().maximize();
		driver.findElement(By.id("datepicker2")).click();
		Thread.sleep(3000);
		
		WebElement month_drp = driver.findElement(By.xpath("//select[@title='Change the month']"));
		
		month_drp.click();
		Select s1 = new Select(month_drp);
		s1.selectByVisibleText("August");
		Thread.sleep(3000);
		
		
		WebElement year_drp = driver.findElement(By.xpath("//select[@title='Change the year']"));
		year_drp.click();
		Select s = new Select(year_drp);
		Thread.sleep(3000);
		s.selectByVisibleText("2013");
		
		
		
		//date selection
		String date= "31";
		List<WebElement>allDates = driver.findElements(By.xpath("//table/tbody/tr/td"));
		
		for(WebElement ele:allDates)
		{
			String dt = ele.getText();
			if(dt.equals(date))
			{
				ele.click();
				break;
			}
			
		}
	
	}
	
}
