import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class hello {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\learning\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize();
		
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		String mainText = driver.findElement(By.xpath("//h1[@data-uniqid='data']")).getText();
		System.out.println(mainText);

		driver.findElement(By.xpath("//input[@id='bmwradio']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='hondaradio']")).click();
		
		WebElement element = driver.findElement(By.xpath("//select[@id='carselect']"));
		Select s = new Select(element);
		s.selectByValue("benz");
		
		driver.findElement(By.xpath("//input[@id='hondacheck']")).click();
		
		
	}
	
}
