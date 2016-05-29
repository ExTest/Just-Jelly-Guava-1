package week5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Amazon{
  @Test
  public void amazonSearch() throws InterruptedException, IOException {
	  FileInputStream fis = new FileInputStream(new File("./data/Amazon Search.xlsx"));
	  XSSFWorkbook wbook = new XSSFWorkbook(fis);
	  XSSFSheet sheet = wbook.getSheetAt(0);
	  XSSFRow row = sheet.getRow(1);
	  XSSFCell cell= row.getCell(0);
	  String search1=cell.getStringCellValue();
	  XSSFCell cell1=row.getCell(1);
	  int index1=(int) cell1.getNumericCellValue();
	  XSSFRow row1 = sheet.getRow(2);
	  XSSFCell cell2= row1.getCell(0);
	  String search2=cell2.getStringCellValue();
	  XSSFCell cell3=row.getCell(1);
	  int index2=(int) cell3.getNumericCellValue();
	 System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	 ChromeDriver Driver = new ChromeDriver();
	 Driver.get("http://www.amazon.in/?tag=googhydrabk-21&ref_=pd_mn_ABKror1112");
	 Driver.manage().window().maximize();
	 Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 Driver.findElementById("twotabsearchtextbox").sendKeys(search1);
	String phandle= Driver.getWindowHandle();
	 Driver.findElementByXPath("//input[@type='submit']").click();
	 Driver.findElementByXPath("//ul[@id='s-results-list-atf']//li["+index2+"]//h2").click();
	 Thread.sleep(5000);
	Driver.switchTo().window(phandle);
	 Driver.findElementById("twotabsearchtextbox").clear();
	 Driver.findElementById("twotabsearchtextbox").sendKeys(search2);
	 Driver.findElementByXPath("//input[@type='submit']").click();
	 Driver.findElementByXPath("//ul[@id='s-results-list-atf']//li["+index1+"]//h2").click();
	 
	 
  }
}
