package week5;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Droppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeDriver Driver = new ChromeDriver();
		Driver.get("http://jqueryui.com/droppable/");
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Driver.switchTo().frame(Driver.findElementByClassName("demo-frame"));
		WebElement Droppable = Driver.findElementById("draggable");
		WebElement Destination = Driver.findElementById("droppable");
		System.out.println(Droppable.getLocation());
		Actions builder= new Actions(Driver);
		builder.dragAndDrop(Droppable, Destination).build().perform();
		Set <String> WH1= Driver.getWindowHandles();
		System.out.println(WH1.size());
		for (String FW : WH1)
		{
			Driver.switchTo().window(FW);
		}
Driver.close();
	}

}
