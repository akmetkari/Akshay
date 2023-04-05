package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage 
{
	WebDriver driver;
	
	public GoogleSearchPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By searchBox = By.xpath("//input[@name='q']");
	
	By facebook_Link = By.xpath("//a//h3[text()='Facebook - log in or sign up']");
	
	public void searchGoogle(String searchInput)
	{
		try 
		{
			driver.findElement(searchBox).sendKeys(searchInput,Keys.ENTER);
			Thread.sleep(3000); 
		} 
		catch (Exception e) 
		{
			System.out.println("Exception caught "+e.getMessage());
		}
		
	}
	
	public void clickFacebook() 
	{
		try {
			driver.findElement(facebook_Link).click();
		
		}
		catch (Exception e)
		{
			System.out.println("Exception caught "+e.getMessage());	
		}
		
	
	}
	
}
