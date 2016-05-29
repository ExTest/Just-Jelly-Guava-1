package testNGProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import wrappers.CommonWrappers;

public class OpenTapsWrapper extends CommonWrappers{
 
  @BeforeMethod(groups={"Smoke,Sanity"})
 @Parameters("Browser")
  public void Login(String BrowserName){
	  launchApp(BrowserName, "http://demo1.opentaps.org/");
		enterTextById("username","DemoSalesManager");
		enterTextById("password","crmsfa");
		clickByXpath("//*[@id='login']/p[3]/input");
		clickByXpath("//*[@id='button']/a/img");		  
  }
  @AfterMethod(alwaysRun=true,description ="close Browser",groups={"Smoke,Sanity"})
  public void CloseBrowser1(){
	  closeTheWindow();
  }
}

