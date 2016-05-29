package week5;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Rightclick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver= new FirefoxDriver();
		driver.get("http://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByLinkText("Droppable").click();
		String pHandle= driver.getWindowHandle();
		System.out.println(pHandle);
		WebElement context = driver.findElementByXPath("//h1[@class='entry-title']");
		Actions builder = new Actions(driver);
		builder.contextClick(context).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		String firstwindow=driver.getWindowHandle();
		System.out.println(firstwindow);
		Set <String> Size = driver.getWindowHandles();
		System.out.println(Size.size());
		System.err.println(driver.getTitle());
		System.out.println(driver.getPageSource());
		driver.close();
		
		}

}
