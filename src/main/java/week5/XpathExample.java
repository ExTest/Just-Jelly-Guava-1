package week5;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class XpathExample {
	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		WebElement shopBy = driver.findElementByXPath("//span[@class='nav-line-1']");
		builder.moveToElement(shopBy).build().perform();
		WebElement Books = driver.findElementByXPath("//div[@id='nav-flyout-shopAll']//span[3]");
		builder.moveToElement(Books).moveToElement(driver.findElementByXPath("//map[@id='nav_imgmap_nav-sa-books']//following::span[3]")).pause(30).click().build().perform();
		List <WebElement> Genressize= driver.findElementsByXPath("//div[@id='FGContainer_563dea328ffecc154766eea040a470d9']//a//p[1]//following-sibling::img");
		System.out.println("Genres size is :"+ Genressize.size() );
		driver.findElementByXPath("//img[@alt='Textbooks']").click();

		List <WebElement> CSBooks = driver.findElementsByXPath("//div[@id='ns_0RR0F0K34DWRN3MXACNP_3214_r0ItemRow']//img");
		System.out.println("Computer Science Book List:" + CSBooks.size());
		driver.findElementByXPath("//img[@alt='Programming Languages']");
		List <WebElement> listdislayed = driver.findElementsByXPath("//ul[@id='s-results-list-atf']//a//img");
		System.out.println("List Displayed :" + listdislayed.size());
	
		
		
	}

}
