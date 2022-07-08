package curs8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumLocators {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {	
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://keybooks.ro/");
	}
	
	@Test
	public void login() throws InterruptedException {
		
		driver.findElement(By.className("menu_user_login")).click();
		driver.findElement(By.id("log")).sendKeys("TestUser");
		
		
		Thread.sleep(4000);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
