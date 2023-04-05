package flipkartProject;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyProduct 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String parentWindow = driver.getWindowHandle();
		//driver.findElement(By.xpath("//div[@class='IiD88i _351hSN']/input")).sendKeys("9158204767",Keys.ENTER);
		//User action is required here to enter the OTP
		//Thread.sleep(5000);
		
//		String actualLogin= driver.findElement(By.className("exehdJ")).getText();;
//		String expectedLogin="akshay";
//		Assert.assertEquals(actualLogin,expectedLogin);
	//	Thread.sleep(5000);
		
		driver.findElement(By.name("q")).sendKeys("Apple iphone 14 pro",Keys.ENTER);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NotFoundException.class);
        
		List<WebElement>MobileName = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
		for(WebElement e: MobileName)
		{
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase("APPLE iPhone 14 Pro Max (Silver, 128 GB)"))
			{	
				
				e.click();
				Thread.sleep(2000);
				Set<String> allWindows = driver.getWindowHandles();
				 for (String childWindow : allWindows) 
				 {
			            if (!childWindow.equals(parentWindow)) 
			            {
			                driver.switchTo().window(childWindow);
			              
			                driver.findElement(By.xpath("//ul[@class='row']/li[1]/button")).click();
			                Thread.sleep(3000);
			                String actualText = "Place Order";
			                //Click on add to cart button 
			                String place_order =driver.findElement(By.className("_2KpZ6l _2ObVJD _3AWRsL")).getText();
			                Assert.assertEquals(actualText, place_order, "Text does not match");
			                
			                String pageItem = driver.findElement(By.className("_2Kn22P gBNbID")).getText();
			                String status = driver.findElement(By.className("_1tBBEs")).getText();
			                
			                
			                
			                driver.close();
			            }
			        }
				
				break;
			}
			
	//	}
		
	}
}
}
