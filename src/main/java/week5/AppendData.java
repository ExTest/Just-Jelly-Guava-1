package week5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class AppendData {
  @Test
  public void append() throws IOException {
	  FileInputStream fis=new FileInputStream(new File("./data/Report.xlsx" ));
	  XSSFWorkbook Wbook = new XSSFWorkbook(fis);
	  XSSFSheet sheet = Wbook.getSheet("Report");
	  int rowCount= sheet.getLastRowNum();
	  XSSFRow row = sheet.createRow(rowCount+1);
	  int Tcount = rowCount+1;
	  XSSFCell cell= row.createCell(0);
	  cell.setCellValue("Test Case Name:: "+Tcount);
	  XSSFCell cell1 =row.createCell(1);
	  cell1.setCellValue("PASS");
	  FileOutputStream fos = new FileOutputStream(new File("./data/Report.xlsx" ));
	  Wbook.write(fos);
	  
	  
	  }
}
