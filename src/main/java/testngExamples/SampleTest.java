package testngExamples;

import org.junit.BeforeClass;
import org.testng.DependencyMap;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wrappers.CommonWrappers;

public class SampleTest extends CommonWrappers {
 @Test(dependsOnMethods="CreateLead" ,description ="Contact Created Sucessfully")
  public void CreateContact(){
	  clickByLinkText("Create Contact");
		enterTextById("firstNameField","GuavaContact12");
		enterTextById("lastNameField","J");
		enterTextById("createContactForm_primaryPhoneNumber","9952928114");
		clickByName("submitButton");  
  }
 // @Test(invocationCount=2,threadPoolSize=2,description ="Lead Created Sucessfully")

  @Test(description ="Lead Created Sucessfully")
  public void CreateLead(){
	  clickByLinkText("Create Lead");
		enterTextById("createLeadForm_companyName","Guava0102209");
		enterTextById("createLeadForm_firstName","Tanvika");
		enterTextById("createLeadForm_lastName", "Jose");
		selectDropdownByIdAndVisibleText("createLeadForm_dataSourceId","Partner");
		selectDropdownByIdAndVisibleText("createLeadForm_marketingCampaignId","Automobile");
		enterTextById("createLeadForm_primaryEmail","J@K.com");
		enterTextById("createLeadForm_primaryPhoneNumber","9952928114");
		clickByName("submitButton");
  }
  
  
  @Test(enabled=false)
  public void FindLead(){
	  System.out.println("inside lead");
  }

  
  @BeforeMethod()
  public void Login(){
	  launchApp("FireFox", "http://demo1.opentaps.org/");
		enterTextById("username","DemoSalesManager");
		enterTextById("password","crmsfa");
		clickByXpath("//*[@id='login']/p[3]/input");
		clickByXpath("//*[@id='button']/a/img");		  
  }
  @AfterMethod(alwaysRun=true,description ="close Browser")
  public void CloseBrowser1(){
	  closeTheWindow();
  }
}
