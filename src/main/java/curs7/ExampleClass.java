package curs7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExampleClass {
	
	@Test
	public void testCeva() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.out.println("Print test!");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.google.com");
		driver.close();
		
	}
	
	

}
