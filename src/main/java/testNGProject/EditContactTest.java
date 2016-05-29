package testNGProject;

import org.testng.annotations.Test;

public class EditContactTest extends OpenTapsWrapper{
  @Test(groups="Sanity",dependsOnGroups="Smoke")
  public void editContact() {
	  System.out.println("In edit Contact");
	  clickByLinkText("Contacts");
		clickByLinkText("Find Contacts");
		enterTextByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[2]/div/div/div/div/div[2]/div[1]/input", "Guava Contact");
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[3]/div/a");
		clickByLinkText("Edit");
		selectDropdownByIdAndIndex("updateContactForm_preferredCurrencyUomId",4);
		clickByXpath("/html/body/div[6]/div/div[2]/div[2]/div[1]/div/form/div/div[2]/table/tbody/tr[8]/td[2]/input");
		
  }
}
