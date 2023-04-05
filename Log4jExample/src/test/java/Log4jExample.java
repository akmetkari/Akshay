import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Log4jExample 
{
	public static void main(String[] args) {
		
		System.setProperty("webdriver.firefox.driver", "D://learning//drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		String Title = driver.getTitle();
		System.out.println("The title of the page"+Title);
		
		Logger logger = Logger.getLogger("Log4jExample");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("hello");
		
		
		
	}
}
