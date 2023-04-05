package module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;

public class Assignment1 
{
	public static void main(String[] args) 

	{
		System.setProperty("webdriver.gecko.driver", "D:\\Learning\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.opencart.com/index.php?route=account/register");

		WebElement element = driver.findElement(By.id("input-country"));
		Select dropdown = new Select(element);
		List<WebElement> allDropDownOptions = dropdown.getOptions();
		System.out.println(allDropDownOptions.size());

		for (WebElement el: allDropDownOptions )
		{
			System.out.println(el.getText());
		}
		
		
	}
}
