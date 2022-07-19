package curs11;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JsAlertExample extends BaseTest{
	
	
	@Test(priority =0)
	public void simpleJsAlertTest() throws InterruptedException {
		
		WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		button.click();
		Thread.sleep(3000);
		Alert jsAlert =  driver.switchTo().alert();
		jsAlert.accept();

		String result =  driver.findElement(By.xpath("//p[@id='result']")).getText();
		assertEquals(result, "You successfully clicked an alert");
		Thread.sleep(3000);

	}
	
	@Test(priority = 1)
	public void confirmationJsAlertTest() throws InterruptedException {
		
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		
		String result =  driver.findElement(By.xpath("//p[@id='result']")).getText();
		assertEquals(result, "You clicked: Cancel");
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 2)
	public void promptJsAlertTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Prompt' )]")).click();
		Thread.sleep(3000);
		Alert promtJSAlert = driver.switchTo().alert();
		promtJSAlert.sendKeys("Test");
		promtJSAlert.accept();
		
		String result =  driver.findElement(By.xpath("//p[@id='result']")).getText();
		assertEquals(result, "You entered: Test");
		Thread.sleep(3000);
	}
	
	
	
	

}
