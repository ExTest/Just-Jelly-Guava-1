package testCases;

import org.junit.Test;

import wrappers.CommonWrappers;

public class TC04_MergeLead extends CommonWrappers{
	@Test
	public void mergeLead(){
	String FromLeadID = "10094";
	String ToLeadID = "C";
	String firstwhandle = null;
		launchApp("FireFox", "http://demo1.opentaps.org/");
		enterTextById("username","DemoSalesManager");
		enterTextById("password","crmsfa");
		clickByXpath("//*[@id='login']/p[3]/input");
		clickByXpath("//*[@id='button']/a/img");
		clickByLinkText("Leads");
		clickByLinkText("Merge Leads");
		firstwhandle = getParentWindowHandle();
		clickByXpath("(//img[@src='/images/fieldlookup.gif'])[1]");
		switchToLastWindow();
		enterTextByName("id",FromLeadID);
		clickByXpath("//button[text()='Find Leads']");
		clickByLinkText(FromLeadID);
		
		switchToFirstWindow(firstwhandle);
		clickByXpath("(//img[@src='/images/fieldlookup.gif'])[2]");
		switchToLastWindow();
		enterTextByName("id",ToLeadID);
		clickByXpath("//button[text()='Find Leads']");
		clickByLinkText(ToLeadID);
		switchToFirstWindow(firstwhandle);
		clickByLinkText("Merge");
		accept_dismiss_alert("accept");
		clickByLinkText("Find Leads");
		enterTextByName("id", FromLeadID);
		clickByXpath("//button[text()='Find Leads']");
		try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		verifyContainingTextByClassName("x-paging-info","No records to display");
	}}



