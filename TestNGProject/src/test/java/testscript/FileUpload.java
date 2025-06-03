package testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileUpload extends Base
{
@Test	
 public void fileUploadUsingSendKeys()
 {
	 driver.navigate().to("https://the-internet.herokuapp.com/upload");
	 WebElement choosefile=driver.findElement(By.id("file-upload"));  
	 choosefile.sendKeys("C:\\Users\\ranji\\Downloads\\SecAsst.pdf");
	 WebElement upload=driver.findElement(By.id("file-submit"));  
	 
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.elementToBeClickable(upload));
	 
	 upload.click();
}
 @Test
 public void fileUploadUsingRobotClass() throws AWTException
 {
	 driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
	 WebElement uploadfile=driver.findElement(By.xpath("//span[text()='Select PDF file']"));  
	 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			 .withTimeout(Duration.ofSeconds(30))
			 .pollingEvery(Duration.ofSeconds(5))
			 .ignoring(NoSuchElementException.class);
			 fluentWait.until(ExpectedConditions.elementToBeClickable(uploadfile));
			 uploadfile.click();
	 
	 StringSelection sc=new StringSelection("C:\\Users\\ranji\\Downloads\\SecAsst.pdf");
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sc, null);
	 Robot rob=new Robot();
	 rob.delay(2500);
	 rob.keyPress(KeyEvent.VK_CONTROL);
	 rob.keyPress(KeyEvent.VK_V);
	 rob.keyRelease(KeyEvent.VK_CONTROL);
	 rob.keyRelease(KeyEvent.VK_V);
	 rob.keyPress(KeyEvent.VK_ENTER);
	 rob.keyRelease(KeyEvent.VK_ENTER);
 }


}
