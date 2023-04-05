package com.inetbanking.testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class BaseClass 
{
	public String baseURL = "https://demo.guru99.com/v4";
	public String userName = "mngr487330";
	public String password = "nUnuzEh";
	public static WebDriver driver;
	public static Logger Logger;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
		driver= new FirefoxDriver();
		
		Logger = org.apache.log4j.Logger.getLogger("BaseClass");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		
	}
}

