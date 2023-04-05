package flipkartProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;
import java.util.ListIterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Login 
{
	public static void main(String[] args) throws BiffException, IOException, InterruptedException 
	{
		WebDriverManager.firefoxdriver().setup();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new FirefoxDriver();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream fis = new FileInputStream("D:\\Learning\\FlipkartLoginData.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet(0); 
		String URL = sh.getCell(1,0).getContents();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
	
		driver.findElement(By.name("q")).sendKeys("mobile phones",Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement>MobileName = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
		File src = new File("D:\\Learning\\Demo.xlsx");
		FileInputStream fis1 = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis1);
		XSSFSheet sheet1 = workbook.getSheetAt(0);
	
		for(WebElement e: MobileName)
		{
			System.out.println(e.getText());
		}
		XSSFWorkbook w= new XSSFWorkbook();
		XSSFSheet s=w.createSheet("project4output");
		XSSFRow r=s.createRow(0);
		r.createCell(0).setCellValue("items");
		r.createCell(1).setCellValue("price");
		
		

//		for(WebElement e: MobileName)
//		{	int i=0;
//			System.out.println(e.getText());
//			XSSFRow row = sheet1.getRow(i);
//			if (row==null)
//			{
//				row = sheet1.createRow(i);
//			}
//			Cell cell = row.getCell(i); // get the cell
//			if(cell==null)
//			{
//				cell = row.createCell(i);
//			}
//			cell.setCellValue(e.getText()); // set the cell value
//
//			i++;
//		}
		
		
		
		List<WebElement>price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		for(WebElement el:price)
		{
			System.out.println(el.getText());
				
		}
		

		for(int i=0;i<=MobileName.size()-1;i++)
		{
			XSSFRow r1=s.createRow(i+1);
			r1.createCell(0).setCellValue(MobileName.get(i).getText());
			r1.createCell(1).setCellValue(price.get(i).getText());
		}
		
		FileOutputStream fop=new FileOutputStream(src);
		try {
			w.write(fop);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			//label = new Label(0, i + 1, String.valueOf(i + 1));
			  //sheet.addCell(label);
			  //label = new Label(1, i + 1, results[i]);
			  //sheet.addCell(label);
			
			
		
	
	}
}
