package module2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment1_Edge 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.edge.driver", "D://learning//drivers//msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.google.com");
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		
		
		
	}
}
