package login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractiveActions 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/horizontal_slider");
		// Automate slider action 
		WebElement slider = driver.findElement(By.xpath("//input"));
		 new Actions(driver).moveToElement(slider).perform();
		System.out.println(driver.findElement(By.xpath("//span[@id=\"range\"]")).getText());
		
		for (int i=1;i<=3;i++) 
		{	
		Thread.sleep(500);
		slider.sendKeys(Keys.ARROW_RIGHT);
		}
		System.out.println(driver.findElement(By.xpath("//span[@id=\"range\"]")).getText());
	
		//drag and drop-start
		driver.get("https://demoqa.com/droppable/");
		driver.manage().window().maximize();
		
		WebElement from = driver.findElement(By.id("draggable"));
		 
		WebElement to = driver.findElement(By.id("droppable"));	 
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(from, to).perform();
		//drag and drop-end 
		
		//resizable start
		driver.get("https://demoqa.com/resizable");
		var element = driver.findElement(By.xpath("//div[@id=\"resizableBoxWithRestriction\"]/span"));
		builder.clickAndHold(element).moveByOffset(500, 300).perform();  
		//resizalbe end 
		
		//selectable start
		driver.get("https://demoqa.com/selectable");
		driver.findElement(By.xpath("//ul[@id=\"verticalListContainer\"]/li[1]")).click();
		driver.findElement(By.xpath("//ul[@id=\"verticalListContainer\"]/li[2]")).click();
		driver.findElement(By.xpath("//ul[@id=\"verticalListContainer\"]/li[3]")).click();
		driver.findElement(By.xpath("//ul[@id=\"verticalListContainer\"]/li[4]")).click();
		//selectable end
		
		
	}	
}
