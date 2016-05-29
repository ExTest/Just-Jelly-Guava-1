package testngExamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateLeadN {
	@Test(dataProvider = "Details")
	public void clickCreateLead(String A, String B,String C,String D,String E) {
		System.out.println("Click Create Lead");
		System.out.println("Value is" + A +B +C + D+E);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Login to Browser");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Logout from Browser");
	}

	@DataProvider(name="Details")
	public Object[][] getdetails() {
		Object [][] D= new Object [2][5];
		D[0][0]="Demo1";
		D[0][1]="Password1";
				D[0][2]="FN1";
				D[0][3]="LN1";
				D[0][4]="CN1";
				D[1][0]="Demo2";
				D[1][1]="Password2";
				D[1][2]="FN2";
				D[1][3]="LN2";
				D[1][4]="CN2";

						return D;
	}

	@BeforeClass
	@Parameters("Browser")
	public void beforeClass(String BName) {
		System.out.println("Launch Browser " + BName);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("Close Browser");
	}

}
