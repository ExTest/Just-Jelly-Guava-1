package testNGProject;

import org.testng.annotations.Test;

public class CreateContactTest extends OpenTapsWrapper{
	@Test(groups="Smoke")
	public void createContact() {
		 System.out.println("In create contact");
		 String FirstName ="Guava Contact 00998";
			String LastName="Helen";
			String PhoneNumber = "9952928114";
			String Email = "helen@g.com";
			clickByLinkText("Create Contact");
			enterTextById("firstNameField",FirstName);
			enterTextById("lastNameField",LastName);
			enterTextById("createContactForm_primaryPhoneNumber",PhoneNumber);
			enterTextById("createContactForm_primaryEmail", Email);
			clickByName("submitButton");
			
	}
}
