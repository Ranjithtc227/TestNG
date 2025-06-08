package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptExecuter extends Base
{
	@Test
	public void javaScriptExecutor()
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement entermsg=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		js.executeScript("arguments[0].value='Hello';", entermsg); //sendkeys()
		
		WebElement btn=driver.findElement(By.xpath("//button[@id='button-one']"));
		js.executeScript("arguments[0].click();", btn); //click()
		
	}
	@Test
	public void scroll()
	{
		driver.navigate().to("https://www.amazon.in/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)","");
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
	}

}
