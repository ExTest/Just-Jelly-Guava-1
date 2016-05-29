package week5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginDataproviderAndExcel {
	

	
WebDriver driver;
	@Test(dataProvider="empLogin")
	public void verifyLogin(String userName, String password) {
		driver=new FirefoxDriver();
		driver.get("http://demo1.opentaps.org/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='login']/p[3]/input")).click();
		driver.findElement(By.xpath("//*[@id='button']/a/img")).click();
	}
	/*
	@DataProvider(name="empLogin")
	public Object[][] loginData() throws IOException {
		Object[][] arrayObject = getExcelData("./data/Login.xlsx","Sheet1");
		return arrayObject;
	}*/
	@DataProvider(name="empLogin")
	public Object[][] getExcelData() throws IOException {
		
	
			FileInputStream fs = new FileInputStream(new File("./data/Login.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheetAt(0);

			int totalNoOfRows = sh.getLastRowNum();
			int totalNoOfCols = sh.getRow(0).getLastCellNum();
			Object[][] D= new Object[totalNoOfRows][totalNoOfCols];
			for (int i = 1; i <= totalNoOfRows; i++) {
				XSSFRow rrow = sh.getRow(i);
				for (int j=0;j<totalNoOfCols;j++){ 
				D[i-1][j] = rrow.getCell(j).getStringCellValue();
				
				System.out.println(D[i-1][j]);
			}}
			return D;
		}}