package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FileUploadTest  extends BaseTest {

	@Test
	public void fileUpload() throws InterruptedException {
		
		driver.get("https://the-internet.herokuapp.com/upload");
		
		driver.findElement(By.id("file-upload")).sendKeys("/Users/dragostanta/Cursuri/CursSelenium/file.txt");
		Thread.sleep(3000);
		driver.findElement(By.id("file-submit")).click();
		
		String actualText =  driver.findElement(By.id("uploaded-files")).getText();
		assertEquals(actualText, "file123.txt");
		Thread.sleep(3000);

	}
	
	
}
