package week5;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resizable {
	WebDriver driver;

	@Test
	public void testToResizeElement() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.navigate().to("http://jqueryui.com/resizable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement resize = driver.findElement(By.cssSelector(".ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"));
		resize(resize, 200, 200);
	}
	public void resize(WebElement elementToResize, int xOffset, int yOffset) {
			Actions action = new Actions(driver);
			action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
		}
		}
