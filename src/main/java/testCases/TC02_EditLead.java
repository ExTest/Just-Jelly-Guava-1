package testCases;

import org.junit.Test;

import wrappers.CommonWrappers;

public class TC02_EditLead extends CommonWrappers{
	@Test
	public void editLead(){
		launchApp("Firefox", "http://demo1.opentaps.org/");
		enterTextById("username","DemoSalesManager");
		enterTextById("password","crmsfa");
		clickByXpath("//*[@id='login']/p[3]/input");
		clickByXpath("//*[@id='button']/a/img");
		clickByLinkText("Leads");
		clickByLinkText("Find Leads");
		enterTextByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[2]/div/div/div/div/div[2]/div[1]/input","Tanvika");
		clickByXpath("//button[text()='Find Leads']");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[3]/div/a");
		VerifyBrowserTitle("View Lead | opentaps CRM");
		clickByLinkText("Edit");
		selectDropdownByIdAndVisibleText("addDataSourceForm_dataSourceId","Cold Call");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div[2]/form/div/div[2]/table/tbody/tr[2]/td[2]/input");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div[3]/table/tbody/tr[2]/td[2]/a");
		selectDropdownByIdAndVisibleText("addMarketingCampaignForm_marketingCampaignId","Road and Track");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div[3]/form/div/div[2]/table/tbody/tr[2]/td[2]/input");
		/*clickByLinkText("Find Leads");
		enterTextByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[2]/div/div/div/div/div[2]/div[1]/input","Tanvika");
		clickByXpath("//button[text()='Find Leads']");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[3]/div/a");
		verifyContainingTextById("viewLead_dataSources_sp","Cold Call");
		verifyContainingTextById("viewLead_marketingCampaigns_sp","Road and Track");
		
		
	*/
	}

}