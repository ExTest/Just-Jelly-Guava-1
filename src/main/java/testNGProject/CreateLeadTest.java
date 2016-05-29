package testNGProject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLeadTest extends OpenTapsWrapper{
  @Test(dataProvider="Details",groups="Smoke")
  public void createLead(String CN ,String FN,String LN) {
	  clickByLinkText("Create Lead");
		enterTextById("createLeadForm_companyName",CN);
		enterTextById("createLeadForm_firstName",FN);
		enterTextById("createLeadForm_lastName",LN);
		selectDropdownByIdAndVisibleText("createLeadForm_dataSourceId","Partner");
		selectDropdownByIdAndVisibleText("createLeadForm_marketingCampaignId","Automobile");
		enterTextById("createLeadForm_primaryEmail","J@K.com");
		enterTextById("createLeadForm_primaryPhoneNumber","9952928114");
		clickByName("submitButton");
		String outputvalue= FindElementGetText("ID", "viewLead_companyName_sp");
		String LeadID = outputvalue.substring(CN.length()+2,outputvalue.length()-1);
		System.out.println(LeadID);


  }
  @DataProvider(name="Details")
	  public Object[][] getDetails(){
	  Object [][] D= new Object[2][3];
			  D[0][0]="Guava01019";
			  D[0][1]="Tanvika";
			  D[0][2]="Jose";
			  D[1][0]="Guava01020";
			  D[1][1]="Helen";
			  D[1][2]="Jayasingh";
	  
	  return D;
  }
}
