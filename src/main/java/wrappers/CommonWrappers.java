package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonWrappers {
	RemoteWebDriver driver;
	int SnapCounter = 1;
	//String firstwhandle;

	public void launchApp(String BrowserName, String URL) {
		try {
			if (BrowserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (BrowserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(URL);
			//firstwhandle = driver.getWindowHandle();
		} catch (WebDriverException e) {
			System.out.println("Browser not launched successfully");
		}finally{
			snapshot();
		}
	}
	public String FindElementGetText(String Locator, String LocVal) {

		String GetText = null;

		if (Locator.contains("ID")) {
			try {
				GetText = driver.findElementById(LocVal).getText();
			} catch (NoSuchElementException e) {
				System.out.println("The element :" + LocVal + " does not exist");
			}
		} else if (Locator.contains("Name")) {
			try {
				GetText = driver.findElementByName(LocVal).getText();
			} catch (NoSuchElementException e) {
				System.out.println("The element :" + LocVal + " does not exist");
			}
		} else if (Locator.contains("XPath")) {
			try {
				GetText = driver.findElementByXPath(LocVal).getText();
			} catch (NoSuchElementException e) {
				System.out.println("The element :" + LocVal + " does not exist");
			}
		} else if (Locator.contains("ClassName")) {
			try {
				GetText = driver.findElementByClassName(LocVal).getText();
			} catch (NoSuchElementException e) {
				System.out.println("The element :" + LocVal + " does not exist");
			}
		} else if (Locator.contains("LinkText")) {
			try {
				GetText = driver.findElementByLinkText(LocVal).getText();
			} catch (NoSuchElementException e) {
				System.out.println("The element :" + LocVal + " does not exist");
			}
		} else {
			System.out.println(
					"The Locator : " + Locator + "value passed in invalid. Please pass the correct Locator name");
		}
		System.out.println("The Get Text value in the locator" + Locator + " is : " + GetText);
		snapshot();
		return GetText;
	}

	public String getParentWindowHandle() {
String primarywhdl = driver.getWindowHandle();
return primarywhdl;
}

public void switchToLastWindow() {
try {
Set<String> whsset = driver.getWindowHandles();
for (String whset : whsset) {
	driver.switchTo().window(whset);
}
} catch (WebDriverException e) {
// TODO Auto-generated catch block
System.out.print("multiple windows not found");
} finally {
snapshot();
}
}
public void switchToFirstWindow(String firstwhandle) {
	try {
		driver.switchTo().window(firstwhandle);
	} catch (WebDriverException e) {
		System.out.print("Window not found");
	}
}
public void accept_dismiss_alert(String acceptordismiss) {

	try {
		Alert alert1 = driver.switchTo().alert();

		try {
			if (acceptordismiss.equals("accept")) {
				alert1.accept();
			} else if (acceptordismiss.equals("dismiss")) {
				alert1.dismiss();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("incorrect acceptance text");
		}

	} catch (NoAlertPresentException e) {

		System.out.print("no open alert");
	} 
}

public String alert_gettext() {
	String alrttext = null;
	try {
		Alert alert2 = driver.switchTo().alert();
		alrttext = alert2.getText();
	} catch (NoAlertPresentException e) {
		System.out.print("no open alert");
	} finally {
		return alrttext;
	}
}

public void prompt_box(String promptstr, String acceptance) {
	try {
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys(promptstr);
		if (acceptance.equals("accept")) {
			alert3.accept();
		} else if (acceptance.equals("dismiss")) {
			alert3.dismiss();
		}
	} catch (NoAlertPresentException e) {
		// TODO Auto-generated catch block
		System.out.print("no open alert");
	} 
}
public void clickById(String id) {
	try {
		driver.findElementById(id).click();
	} catch (ElementNotVisibleException e) {
		// TODO Auto-generated catch block
		System.out.println("Element couldn't find to click");
	} finally {
		snapshot();
	}

}

public void clickByClass(String classnm) {
	try {
		driver.findElementByClassName(classnm).click();
	} catch (ElementNotVisibleException e) {
		// TODO Auto-generated catch block
		System.out.println("Element couldn't find to click");
	} finally {
		snapshot();
	}

}


public void clickByName(String name) {
	try {
		driver.findElementByName(name).click();
	} catch (ElementNotVisibleException e) {
		// TODO Auto-generated catch block
		System.out.println("Element couldn't find to click");
	} finally {
		snapshot();
	}

}

public void clickByXpath(String xpath) {
	try {
		driver.findElementByXPath(xpath).click();
	} catch (ElementNotVisibleException e) {
		// TODO Auto-generated catch block
		System.out.println("Element couldn't find to click");
	} /*finally {
		snapshot();
	}*/

}

public void clickByLinkText(String linkText) {
	try {
		driver.findElementByLinkText(linkText).click();
	} catch (ElementNotVisibleException e) {
		// TODO Auto-generated catch block
		System.out.println("Element couldn't find to click");
		}
}
public void selectDropdownByIdAndIndex(String id, int index) {
	try {
		Select myDropdown = new Select(driver.findElementById(id));
		myDropdown.selectByIndex(index);
	} catch (WebDriverException e) {
		System.out.println("Cannot select the dropdown");
	} finally {
		snapshot();
	}
}

public void selectDropdownByIdAndValue(String id, String value) {
	try {
		Select myDropdown = new Select(driver.findElementById(id));
		myDropdown.selectByValue(value);
	} catch (WebDriverException e) {
		System.out.println("Cannot select the dropdown");
	} finally {
		snapshot();
	}
}

public void selectDropdownByIdAndVisibleText(String id, String visibleText) {
	try {
		Select myDropdown = new Select(driver.findElementById(id));
		myDropdown.selectByVisibleText(visibleText);
	} catch (WebDriverException e) {
		System.out.println("Cannot select the dropdown");
	} finally {
		snapshot();
	}

}
@SuppressWarnings("finally")
public boolean VerifyBrowserTitle(String expTitle)

{
	boolean returnValue = false;
	try {
		if (driver.getTitle().equals(expTitle)) {
			returnValue = true;
			System.out.println("Browser Title matches successfully");
		} else {
			System.out.println("Browser Title do mot match");
			System.out.println("Expected Title is " + expTitle);
			System.out.println("Actual Title is " + driver.getTitle());

		}
	}

	catch (Exception e) {
		System.out.println("Browser could not be identified to verify the title");
	}

	finally {
		snapshot();
		return (returnValue);
		
	}

}

@SuppressWarnings("finally")
public boolean VerifyCurrentPageURL(String expURL)

{
	boolean returnValue = false;
	try {
		if (driver.getCurrentUrl().equals(expURL)) {
			returnValue = true;
			System.out.println("Browser URL matches successfully");
		} else {
			System.out.println("Browser URL do mot match");
			System.out.println("Expected URL is " + expURL);
			System.out.println("Actual URL is " + driver.getCurrentUrl());

		}
	}

	catch (Exception e) {
		System.out.println("Browser could not be identified to verify the URL");
	}

	finally {
		snapshot();
		return (returnValue);
		
		}

}
public void snapshot() {
	File Snap = driver.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(Snap, new File("./Images/Snap-" + SnapCounter + ".jpeg"));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SnapCounter++;
}

public  void clickButtonByCss(String id)
{
	try {
		driver.findElementByCssSelector(id).click();
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.out.println("no Such element found");
	}finally{
		snapshot();
		
	}
}


public void verifyTextById(String id, String textValue)
{
	      
	if(driver.findElementById(id).getText().equals(textValue))
	{
		System.out.println("The value has been matched ");
	}
	else{
		System.out.println("The value did not matched ");
	}
	snapshot();
}


public void verifyContainingTextById(String id, String textValue)
{
	      
	if(driver.findElementById(id).getText().contains(textValue))
	{
		System.out.println("The value has been matched ");
	}
	else{
		System.out.println("The value did not matched ");
	}
		snapshot();
}
public  void enterTextById(String id, String value)
{
	try {
		driver.findElementById(id).sendKeys(value);
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		System.out.println("Element not found");
	}/*finally{
	snapshot();	
	}*/
	
}

public void enterTextByName(String Name,String TextValue){
	try{
		//driver.findElementByName(Name).clear();
driver.findElementByName(Name).sendKeys(TextValue);
	}catch(NoSuchElementException e){
		System.out.println("Text Element not found by Name");
	}
}
public void enterTextByXpath(String Xpath,String TextValue){
	try{
		driver.findElementByXPath(Xpath).clear();
driver.findElementByXPath(Xpath).sendKeys(TextValue);
	}catch(NoSuchElementException e){
		System.out.println("Text Element not found by Xpath");
	}finally{
		snapshot();
	}
}
public void closeTheWindow(){
	try{
		driver.close();
		}
	catch(Exception e){
		System.out.println("Unable to close the Browser");
	}
			
	}

public void quitBrowser(){
	try{
		driver.quit();
		}
	catch(Exception e){
		System.out.println("Unable to quit the Browser");
	}
		
	}
public void switchToFrameByNameOrID(String Name){

	try{
		driver.switchTo().frame(Name);
		}
	catch(RuntimeException e){
		System.out.println("Frame Not Found Exception");
	}
		finally{
			System.out.println("Switch to frame sucess by Name or ID");
			snapshot();
		}
		
		
}
public void verifyContainingTextByXpath(String Xpath, String textValue)
{
	      
	if(driver.findElementByXPath(Xpath).getText().contains(textValue))
	{
		System.out.println("The value has been matched ");
	}
	else{
		System.out.println("The value did not matched ");
	}
		snapshot();
}
public void verifyContainingTextByClassName(String ClassName, String textValue)
{
	      
	if(driver.findElementByClassName(ClassName).getText().contains(textValue))
	{
		System.out.println("The value has been matched ");
	}
	else{
		System.out.println("The value did not matched ");
	}
		snapshot();
}
public void verifyContainingTextByLinkText(String LinkText, String textValue)
{
	      
	if(driver.findElementByLinkText(LinkText).getText().contains(textValue))
	{
		System.out.println("The value has been matched ");
	}
	else{
		System.out.println("The value did not matched ");
	}
		snapshot();
}

}
