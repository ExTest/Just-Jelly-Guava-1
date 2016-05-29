package week5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SortablePosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver= new FirefoxDriver();
		driver.get("http://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByLinkText("Sortable").click();
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		WebElement Location5 =driver.findElementByXPath("//ul[@id='sortable']/li[5]");
		System.out.println(Location5.getLocation());
		WebElement item1= driver.findElementByXPath("//ul[@id='sortable']/li[1]");
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(item1, 11, 145).build().perform();

	}

}

