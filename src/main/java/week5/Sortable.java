package week5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver Driver = new FirefoxDriver();
		Driver.get("http://jqueryui.com/droppable/");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Driver.findElementByLinkText("Sortable").click();
		Driver.switchTo().frame(Driver.findElementByClassName("demo-frame"));
		WebElement sortable = Driver.findElementByXPath("//ul[@id='sortable']/li[1]");
		Actions builder= new Actions(Driver);
		builder.contextClick(sortable).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	}

}
