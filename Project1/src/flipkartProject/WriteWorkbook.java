package flipkartProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteWorkbook 
{
	public static void main(String[] args) throws IOException 	
	{
		File src = new File("D:\\Learning\\Demo.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		XSSFRow row = sheet1.getRow(0); // get the row
		if (row == null) { // check if the row is null
		  row = sheet1.createRow(0); // create a new row if null
		}
		
		Cell cell = row.getCell(0); // get the cell

		cell.setCellValue("akshay"); // set the cell value
		
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
		
		
	}
}
