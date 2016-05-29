package testCases;

import org.junit.Test;

import wrappers.CommonWrappers;

public class TC05_CreateContact extends CommonWrappers
{
	@Test
	public void createContact(){
		String FirstName ="Guava Contact 0029";
		String LastName="Helen";
		String PhoneNumber = "9952928115";
		String Email = "helen@g.com";
		String State ="Iowa";
		launchApp("FireFox", "http://demo1.opentaps.org/");
		enterTextById("username","DemoSalesManager");
		enterTextById("password","crmsfa");
		clickByXpath("//*[@id='login']/p[3]/input");
		clickByXpath("//*[@id='button']/a/img");
		clickByLinkText("Create Contact");
		enterTextById("firstNameField",FirstName);
		enterTextById("lastNameField",LastName);
		enterTextById("createContactForm_primaryPhoneNumber",PhoneNumber);
		enterTextById("createContactForm_primaryEmail", Email);
		selectDropdownByIdAndVisibleText("createContactForm_generalStateProvinceGeoId", State);
		clickByName("submitButton");
		//verifyContainingTextById("viewContact_fullName_sp",FirstName+LastName);
		verifyTextById("viewContact_firstName_sp",FirstName);
		verifyTextById("viewContact_lastName_sp",LastName);
		verifyContainingTextByXpath("/html/body/div[6]/div/div[2]/div[2]/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div/a",Email);
		verifyContainingTextByXpath("/html/body/div[6]/div/div[2]/div[2]/div[3]/div/div[2]/table/tbody/tr[3]/td[2]/div",PhoneNumber);
		FindElementGetText("ID", "viewContact_fullName_sp");
}
		
	}


