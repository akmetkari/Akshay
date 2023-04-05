package login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationForm 
{
	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  
		  
		  
		  
		driver.get("https://demoqa.com/automation-practice-form");
		driver.findElement(By.id("firstName")).sendKeys("aahsy");
		driver.findElement(By.id("lastName")).sendKeys("metari");
		driver.findElement(By.id("userEmail")).sendKeys("aa5metkari@gmail.com");
		driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]")).click();
		driver.findElement(By.id("userNumber")).sendKeys("91538304789",Keys.TAB);
		
		
		driver.findElement(By.id("dateOfBirthInput")).click();
	       js.executeScript("window.scrollBy(0,1000)");
		
		WebElement yearEle = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
		Select year = new Select(yearEle);
		year.selectByValue("1996");
		
		WebElement monthEle = driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
		Select month = new Select(monthEle);
		monthEle.click();
		month.selectByIndex(8);
		
		 WebElement day = driver.findElement(By.xpath("//div[text()='15']"));
	        day.click();
	    
	        WebElement subjects = driver.findElement(By.id("subjectsInput"));
	        subjects.sendKeys("Maths",Keys.DOWN);
	        Thread.sleep(2000);
	        subjects.sendKeys("",Keys.TAB);
	        js.executeScript("window.scrollBy(0,1000)");
	   
	        WebElement hobbies = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
	        hobbies.click();   
	
	       
	        js.executeScript("window.scrollBy(0,1000)");
	        WebElement state = driver.findElement(By.id("state"));
	        state.click();
	        
	        driver.findElement(By.id("react-select-3-option-0")).click();
	        
	        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	        Thread.sleep(3000);
	        
	        WebElement address = driver.findElement(By.id("currentAddress"));
	        address.sendKeys("Pandharpur");
	      
	        
	        WebElement ele=  driver.findElement(By.xpath("//input[@type='file']"));
	        ele.sendKeys("C:\\Users\\91797\\Desktop\\Nike.jpg");
	      
	        boolean success = false;
	        while(!success) 
	        {
	        	try 
	        	{
	        		 js.executeScript("window.scrollTo(0,1000)");
	     	        driver.findElement(By.id("city")).click();
	     	        Thread.sleep(2000);
	     	       WebElement element =  driver.findElement(By.xpath("//div[@class=' css-1pahdxg-control']/div[1]"));
	     	        js.executeScript("arguments[0].scrollIntoView();", element);
	     	        element.sendKeys("",Keys.ENTER); 
	        		success=false;
		        }
	        	catch(ElementNotInteractableException e) {
	        		
	        	}
	        }
	        
	        driver.findElement(By.id("submit")).click();
	        
	          
	}
}
