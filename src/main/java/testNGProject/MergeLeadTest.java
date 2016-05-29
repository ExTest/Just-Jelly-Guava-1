package testNGProject;

import org.testng.annotations.Test;

public class MergeLeadTest extends OpenTapsWrapper{
  @Test(groups="Sanity",dependsOnGroups="Smoke")
  public void mergeLead() {
	  System.out.println("In merge Lead");
	  String FromLeadID = "10050";
		String ToLeadID = "10051";
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

	  
  }
}
