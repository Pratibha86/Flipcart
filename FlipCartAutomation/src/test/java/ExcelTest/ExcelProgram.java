package ExcelTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelProgram {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String path="C:\\Users\\Admin\\Desktop\\Java Program.xlsx"; 
		FileInputStream file= new FileInputStream(path);
	    Workbook book=WorkbookFactory.create(file);
	    Sheet sheet=book.getSheet("Pratibha");
	   
        //int lastrownum=sheet.getLastRowNum();

	     for(int i=0;i<sheet.getLastRowNum();i++) {
	    	 Row row=sheet.getRow(i);
	    	 System.out.println();
	     for(int c=0;c<row.getLastCellNum();c++){
	    	 
         String value=row.getCell(c).getStringCellValue();
	     System.out.print(value+",");
                                   }
                                   }	
	}
	

}
