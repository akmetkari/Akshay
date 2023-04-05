package basics;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import jxl.Sheet;


import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Assign1 {
	
	static WebDriver driver;
	
	@Test(priority=1)
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D://learning//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test(priority=2)
	public void Login() throws InterruptedException, BiffException, IOException
	{
		
		driver.get("https://www.saucedemo.com/");
		FileInputStream fis = new FileInputStream("D:\\Learning\\LoginData.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet(0); 
		String userName = sh.getCell(0,1).getContents();
		String password = sh.getCell(1,1).getContents();
		System.out.println(userName);
		System.out.println(password);
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.id("login-button")).click();
		
	}
	
	@AfterMethod
	@Test(priority=3)
	public void tearDown()
	{
		driver.close();
	}
	
}
