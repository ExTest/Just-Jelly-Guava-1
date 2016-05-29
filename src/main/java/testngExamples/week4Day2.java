package testngExamples;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class week4Day2 {
  @Test(dataProvider = "dp",invocationCount=2)
  public void clickCreateLead(Integer n, String s) {
	  System.out.println("Click Create Lead");
  }
  @Test(dataProvider = "dp")
  public void clickFindLead(Integer n, String s) {
	  System.out.println("Click Find Lead");
  }
  @Test(dataProvider = "dp",dependsOnMethods="clickCreateLead")
  public void clickCreateContact(Integer n, String s) {
	  System.out.println("Click Create Contact");
  }
  @BeforeMethod
  public void beforeMethod(){
	  System.out.println("Login to Browser");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Logout from Browser");
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  @Parameters("Browser")
  public void beforeClass(String BName) {
	  System.out.println("Launch Browser "+ BName);
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  System.out.println("Close Browser");
  }

}
