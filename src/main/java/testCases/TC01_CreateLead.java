package testCases;

import org.junit.Test;

import wrappers.CommonWrappers;

public class TC01_CreateLead extends CommonWrappers{
	@Test
	public void createLead(){
		String companyName ="Guava0102209";
		launchApp("FireFox", "http://demo1.opentaps.org/");
		enterTextById("username","DemoSalesManager");
		enterTextById("password","crmsfa");
		clickByXpath("//*[@id='login']/p[3]/input");
		clickByXpath("//*[@id='button']/a/img");
		clickByLinkText("Create Lead");
		enterTextById("createLeadForm_companyName",companyName);
		enterTextById("createLeadForm_firstName","Tanvika");
		enterTextById("createLeadForm_lastName", "Jose");
		selectDropdownByIdAndVisibleText("createLeadForm_dataSourceId","Partner");
		selectDropdownByIdAndVisibleText("createLeadForm_marketingCampaignId","Automobile");
		enterTextById("createLeadForm_primaryEmail","J@K.com");
		enterTextById("createLeadForm_primaryPhoneNumber","9952928114");
		clickByName("submitButton");
		verifyContainingTextById("viewLead_companyName_sp",companyName);
		verifyTextById("viewLead_firstName_sp", "Tanvika");
		verifyTextById("viewLead_lastName_sp", "Jose");
		verifyTextById("viewLead_dataSources_sp","Partner");
		verifyTextById("viewLead_marketingCampaigns_sp","Automobile");
		verifyContainingTextByLinkText("J@K.com","J@K.com" );
		verifyContainingTextByXpath("//b[text()='Phone Number']/following::div","9952928114");
		String outputvalue= FindElementGetText("ID", "viewLead_companyName_sp");
		String LeadID = outputvalue.substring(companyName.length()+2,outputvalue.length()-1);
		System.out.println(LeadID);
}
	}

