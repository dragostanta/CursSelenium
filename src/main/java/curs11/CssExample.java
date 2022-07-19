package curs11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssExample extends BaseTest{
	
	
	@Test
	public void cssExample() throws InterruptedException {
		
		
		
		// xpath-->    //h3[contains(@class, 'sc_title')]
		// xpath select by index -->    (//h3[contains(@class, 'sc_title')])[0]
		
		WebElement theSonBook =  driver.findElement(By.xpath("(//h3[contains(@class, 'sc_title')])[2]"));
		System.out.println(theSonBook.getText());
		//contains  *
		WebElement deepSileneceBook =  driver.findElement(By.cssSelector("a[href*='dee']"));
		System.out.println(deepSileneceBook.getText());
		//starts with ^
		WebElement lifeInGardenBook =  driver.findElement(By.cssSelector("a[href^='life']"));
		System.out.println(lifeInGardenBook.getText());
		//ends with $
		WebElement lifeInGardenBook2 =  driver.findElement(By.cssSelector("a[href$='garden']"));
		System.out.println(lifeInGardenBook2.getText());
		
		//<li class = 'menu_user_login'>
		
		//li[class='menu_user_login']
		// .menu_user_login
		// li.menu_user_login

		// . shortcut pentru class
		// # shortcut pentru id
		
		
		driver.findElement(By.cssSelector(".menu_user_login")).click();
		Thread.sleep(3000);
	}

}
