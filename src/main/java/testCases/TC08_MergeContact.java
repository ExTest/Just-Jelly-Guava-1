package testCases;

import org.junit.Test;

import wrappers.CommonWrappers;

public class TC08_MergeContact extends CommonWrappers{
	
	@Test
	public void mergeContact(){
		String FromContact = "10025";
		String ToContact = "10026";
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
			clickByLinkText("Find Contacts");
			enterTextByName("id", FromContact);
			clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");
			try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			verifyContainingTextByClassName("x-paging-info","No records to display");
		}
}
	

