package testNGProject;

import org.testng.annotations.Test;

public class EditLeadTest extends OpenTapsWrapper{
  @Test(groups="Sanity",dependsOnGroups="Smoke")
  public void editLead() {
	  System.out.println("In Edit Lead");
	  clickByLinkText("Leads");
		clickByLinkText("Find Leads");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		enterTextByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[2]/div/div/div/div/div[2]/div[1]/input","Tanvika");
		clickByXpath("//button[text()='Find Leads']");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[3]/div/a");
		clickByLinkText("Edit");
		selectDropdownByIdAndVisibleText("addDataSourceForm_dataSourceId","Cold Call");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div[2]/form/div/div[2]/table/tbody/tr[2]/td[2]/input");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div[1]/div/form/div/div[2]/table/tbody/tr[12]/td[2]/input");
		
  }
}
