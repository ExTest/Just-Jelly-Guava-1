package testNGProject;

import org.testng.annotations.Test;

public class MergeContactTest extends OpenTapsWrapper{
  @Test(groups="Sanity",dependsOnGroups="Smoke")
  public void mergeContact() {
	  System.out.println("In merge contact");
	  String FromContact = "10064";
		String ToContact = "10068";
		String firstwhandle = null;
			launchApp("FireFox", "http://demo1.opentaps.org/");
			enterTextById("username","DemoSalesManager");
			enterTextById("password","crmsfa");
			clickByXpath("//*[@id='login']/p[3]/input");
			clickByXpath("//*[@id='button']/a/img");
			clickByLinkText("Contacts");
			clickByLinkText("Merge Contacts");
			firstwhandle = getParentWindowHandle();
			clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/form/table/tbody/tr[1]/td[2]/a/img");
			switchToLastWindow();
			enterTextByName("id",FromContact);
			clickByXpath("/html/body/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");
			clickByLinkText(FromContact);
			switchToFirstWindow(firstwhandle);
			clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/form/table/tbody/tr[2]/td[2]/a/img");
			switchToLastWindow();
			enterTextByName("id",ToContact);
			clickByXpath("/html/body/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");
			clickByLinkText(ToContact);
			switchToFirstWindow(firstwhandle);
			clickByLinkText("Merge");
			accept_dismiss_alert("accept");
		
  }
}
