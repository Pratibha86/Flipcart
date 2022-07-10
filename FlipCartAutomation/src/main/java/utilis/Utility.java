package utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	
	public static void captureScreen(WebDriver driver, int testID) throws IOException, InterruptedException {
		
		Calendar cal = Calendar.getInstance();
		Date time=cal.getTime();
	    String timestamp = time.toString().replace(" ", "-").replace(":", "-");
		File start=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File end=new File("test-output\\Screenshots\\test-"+testID+timestamp+".jpeg");
		FileHandler.copy(start, end);
		Thread.sleep(2000);
		}
	
	
public static  String getDataFromExcel(String sheet,int cell,int row) throws EncryptedDocumentException, IOException {
	
	
	String data=null;
	String path = "src\\main\\resources\\TestData\\testingdata.xlsx";
	FileInputStream file = new FileInputStream(path);
	Workbook book = WorkbookFactory.create(file);
	
	try {
		
		String userName1 = book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		data=userName1;
		
		}
	catch(Exception e) {
		double userName1 = book.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		String str=Long.toString((long) userName1);
		data=str;
		}
	
	
	return data;
	
}
}

