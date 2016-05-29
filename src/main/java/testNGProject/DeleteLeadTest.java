package testNGProject;

import org.testng.annotations.Test;

public class DeleteLeadTest extends OpenTapsWrapper{
  @Test(groups="Sanity",dependsOnGroups="Smoke")
  public void deleteLead() {
	  System.out.println("In delete Lead");
	  clickByLinkText("Leads");
		clickByLinkText("Find Leads");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[1]/div[1]/ul/li[2]/a[2]/em/span/span");
		enterTextByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[2]/div/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr/td[3]/div/div/div/input","9952928114");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div/table/tbody/tr[1]/td[1]/div/a");
		clickByLinkText("Delete");
		 }
}
