package test_Scenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.GoogleSearchPage;

public class TestGoogleSearch 
{
	WebDriver driver;
	GoogleSearchPage objRepo;
	
	@BeforeTest
	public void beforeTest()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicit wait of 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com");
	}

	@Test
	public void searchOperation()
	{
		GoogleSearchPage page = new GoogleSearchPage(driver);
		page.searchGoogle("Facebook");
		
	}
	
	@Test
	public void verifyandAccessFacebook() 
	{
		objRepo = new GoogleSearchPage(driver);
		objRepo.clickFacebook();
	
	}	
	@AfterTest
	public void afterTest()
	{
		//driver.quit();
		
	}

}
