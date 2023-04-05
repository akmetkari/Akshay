package google;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class takeScreenShot {
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D://learning//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//capture full page screenshot
		driver.get("https://www.google.com");
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		
		//Call getscreenshot method to create image file 
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Learning\\Eclipse\\windows\\screenshot\\fullPage.png");
		
		
		//copy image file to destination
		FileUtils.copyFile(src, dest);
		
		
		
		
	}
	
}
