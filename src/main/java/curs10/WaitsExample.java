package curs10;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.BaseTest;

public class WaitsExample extends BaseTest{
	
	
	//@Test
	public void waitExample() throws InterruptedException {
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.tagName("button")).click();
		//Thread.sleep(6000);
		WebElement finish =  driver.findElement(By.id("finish"));

		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(finish, "Hello World!"));
		
		assertEquals(finish.getText(), "Hello World!");	
		
	}
	
	@Test
	public void waitExample2() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		
		driver.findElement(By.tagName("button")).click();
		WebElement finish =  driver.findElement(By.id("finish"));
		assertEquals(finish.getText(), "Hello World!");	
	}
	

}
