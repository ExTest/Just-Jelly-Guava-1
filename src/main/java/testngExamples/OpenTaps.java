package testngExamples;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class OpenTaps extends TestngAnnotations{
	RemoteWebDriver Driver;
  @Test
  public void f() {
	  Driver.findElementByLinkText("Leads").click();
	  Driver.findElementByLinkText("Create Lead").click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  Driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		Driver.findElement(By.id("password")).sendKeys("crmsfa");
		Driver.findElement(By.xpath("//*[@id='login']/p[3]/input")).click();
		Driver.findElementByXPath("//*[@id='button']/a/img").click();
  }

  @BeforeClass
  public void beforeClass() {
	  Driver =new FirefoxDriver();
		Driver.get("http://demo1.opentaps.org/opentaps/control/main");
		Driver.manage().window().maximize();
		
  }@Test
  public void g() {
	  Driver.findElementByLinkText("Leads").click();
	  Driver.findElementByLinkText("Find Leads").click();
  }
  @Test
  public void h() {
	  Driver.findElementByLinkText("Contacts").click();
	  Driver.findElementByLinkText("Create Contact").click();
  }

  @AfterClass
  public void afterClass() {
	  Driver.close();
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Test");
  }

}
