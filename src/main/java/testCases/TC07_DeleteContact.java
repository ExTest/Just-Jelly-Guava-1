package testCases;

import org.junit.Test;

import wrappers.CommonWrappers;

public class TC07_DeleteContact extends CommonWrappers {
	
	@Test
	public void deleteContact(){
			launchApp("FireFox", "http://demo1.opentaps.org/");
			enterTextById("username","DemoSalesManager");
			enterTextById("password","crmsfa");
			clickByXpath("//*[@id='login']/p[3]/input");
			clickByXpath("//*[@id='button']/a/img");
			clickByLinkText("Contacts");
			clickByLinkText("Find Contacts");
			clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[1]/div[1]/ul/li[2]/a[2]/em/span/span");
			enterTextByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[2]/div/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr/td[3]/div/div/div/input","9952928114");
			clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td");
			clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[3]/div");
			clickByLinkText("Deactivate Contact");
			accept_dismiss_alert("accept");
	}}
			