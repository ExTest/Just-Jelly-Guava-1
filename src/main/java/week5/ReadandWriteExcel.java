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
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadandWriteExcel {
  
	@Test
	public void readExcel() throws IOException
	{
		boolean flag=false;
		try {
			FileInputStream fis=new FileInputStream(new File("./data/Login.xlsx"));
			XSSFWorkbook rbook=new XSSFWorkbook(fis);
			XSSFSheet rsheet=rbook.getSheetAt(0);
			int rowcount=rsheet.getLastRowNum();

			for (int i = 1; i <= rowcount; i++) {
				XSSFRow rrow = rsheet.getRow(i);
				XSSFCell rcell = rrow.getCell(0);
				String uname = rcell.getStringCellValue();
				System.out.println(uname);
				XSSFCell rcell1 = rrow.getCell(1);
				String password = rcell1.getStringCellValue();
				System.out.println(password);
				FirefoxDriver Driver =new FirefoxDriver();
				Driver.get("http://demo1.opentaps.org/opentaps/control/main");
				Driver.manage().window().maximize();
				Driver.findElement(By.id("username")).sendKeys(uname);
				Driver.findElement(By.id("password")).sendKeys(password);
				Driver.findElement(By.xpath("//*[@id='login']/p[3]/input")).click();
				Driver.findElementByXPath("//*[@id='button']/a/img").click();

				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			FileOutputStream Fos = new FileOutputStream(new File("./data/Report.xlsx"));
			XSSFWorkbook Wbook = new XSSFWorkbook();
			XSSFSheet Sheet = Wbook.createSheet("Report");
			XSSFRow Row= Sheet.createRow(0);
			XSSFCell Cell = Row.createCell(0);
			Cell.setCellValue("Test Case Name");
			XSSFCell Cell1 = Row.createCell(1);
			Cell1.setCellValue("Status");
			XSSFRow Row1= Sheet.createRow(1);
			XSSFCell Cell2 = Row1.createCell(0);
			Cell2.setCellValue("Login To Open Taps");
			if(flag==true){
				System.out.println("Passed");
			
			XSSFCell Cell3 = Row1.createCell(1);
			Cell3.setCellValue("PASS");}
			else{
				XSSFCell Cell3 = Row1.createCell(1);
				Cell3.setCellValue("FAIL");}	
			Wbook.write(Fos);	
			


		}
	}

}