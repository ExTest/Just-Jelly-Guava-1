package testCases;

import org.junit.Test;

import wrappers.CommonWrappers;

public class TC06_EditContact extends CommonWrappers{
	@Test
	public void editContact(){
		String FirstName ="Guava Contact 0029";
		String LastName="Helen";
		launchApp("FireFox", "http://demo1.opentaps.org/");
		enterTextById("username","DemoSalesManager");
		enterTextById("password","crmsfa");
		clickByXpath("//*[@id='login']/p[3]/input");
		clickByXpath("//*[@id='button']/a/img");
		clickByLinkText("Contacts");
		clickByLinkText("Find Contacts");
		enterTextByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[2]/div/div/div/div/div[2]/div[1]/input", "Guava Contact");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[3]/div/a");
		VerifyBrowserTitle("View Contact | opentaps CRM");
		clickByLinkText("Edit");
		selectDropdownByIdAndVisibleText("addMarketingCampaignForm_marketingCampaignId","Road and Track");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div[2]/form/div/div[2]/table/tbody/tr[2]/td[2]/input");
		selectDropdownByIdAndIndex("updateContactForm_preferredCurrencyUomId",4);
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div[1]/div/form/div/div[2]/table/tbody/tr[8]/td[2]/input");
		verifyContainingTextById("viewContact_marketingCampaigns_sp","Road and Track");
		verifyContainingTextById("viewContact_fullName_sp",FirstName+LastName);
		verifyTextById("viewContact_firstName_sp",FirstName);
		verifyTextById("viewContact_lastName_sp",LastName);
		verifyContainingTextById("viewContact_preferredCurrencyUomId_sp","USD - American Dollar");
		
			
		
		
	}

}
