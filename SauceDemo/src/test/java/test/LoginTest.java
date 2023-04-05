package test;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import page.LoginPage;

public class LoginTest 
{
	WebDriver driver;
	Properties props;
	FileReader reader;
	
	
	@BeforeClass
	public void initilize() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		props=new Properties();
		reader=new FileReader("D:\\Learning\\Eclipse\\SauceDemo\\config.properties");
		props.load(reader);
	
	}
	
	@Test
	public void Login()
	{
		
		driver.get(props.getProperty("url"));
		driver.manage().window().maximize();
		LoginPage p = new LoginPage(driver);
		String uname=props.getProperty("user");
		String pass=props.getProperty("pass");
		p.enterDetails(uname,pass);
		p.clickLogin();
		String expected_text = "Products";
		String Actual_text = driver.findElement(By.xpath("//span[@class='title']")).getText();
		
		Assert.assertEquals(expected_text,Actual_text );
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("aftermethod");
		//driver.close();
	}
	
	
	
}
