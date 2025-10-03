package ddt_extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetDataIntoExcelFile {

public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	
FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptDataToSet.xlsx");

	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("set1");
	Row rw = sh.createRow(1);
	Cell cell = rw.createCell(0);
	cell.setCellValue("google_");
	
	//save the changes
	FileOutputStream fos = new FileOutputStream("./src/test/resources/TestScriptDataToSet.xlsx");
	wb.write(fos);
	wb.close();	
	
}
}
