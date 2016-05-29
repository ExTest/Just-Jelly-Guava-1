package testCases;

import org.junit.Test;

import wrappers.CommonWrappers;

public class TC03_DeleteLead extends CommonWrappers {
	@Test
	public void deleteLead(){
			launchApp("Chrome", "http://demo1.opentaps.org/");
			enterTextById("username","DemoSalesManager");
			enterTextById("password","crmsfa");
			clickByXpath("//*[@id='login']/p[3]/input");
			clickByXpath("//*[@id='button']/a/img");
			clickByLinkText("Leads");
			clickByLinkText("Find Leads");
			clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[1]/div[1]/ul/li[2]/a[2]/em/span/span");
			enterTextByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[2]/div/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr/td[3]/div/div/div/input","9952928114");
			clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");
			String leadID= FindElementGetText("Xpath","/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div/table/tbody/tr[1]/td[1]/div/a[1]");
			clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div/table/tbody/tr[1]/td[1]/div/a");
			clickByLinkText("Delete");
			clickByLinkText("Find Leads");
			enterTextByName("id", leadID);
			clickByXpath("//button[text()='Find Leads']");
			try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			verifyContainingTextByClassName("x-paging-info","No records to display");

			
			
	}
	}


