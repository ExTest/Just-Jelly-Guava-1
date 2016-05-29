package testngExamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateContactN{
	 
	  @Test()
	  public void clickCreateContact() {
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


