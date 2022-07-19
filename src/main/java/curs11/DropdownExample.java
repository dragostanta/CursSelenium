package curs11;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utils.BaseTest;

public class DropdownExample extends BaseTest{

	
	@Test(priority=0)
	public void selectByValueExample() throws InterruptedException {
		
		driver.findElement(By.linkText("BOOKS")).click();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='orderby']"));
		
		Select dropdownMenu =  new Select(dropdown);
		dropdownMenu.selectByValue("price-desc");
		Thread.sleep(3000);
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@class='orderby']"));
		Select dropdownMenu2 =  new Select(dropdown2);
		assertEquals(dropdownMenu2.getFirstSelectedOption().getText(), "Sort by price: high to low");
		
	}
	
	@Test(priority = 1)
	public void selectByIndexExample() throws InterruptedException {
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='orderby']"));
		Select dropdownMenu =  new Select(dropdown);
		dropdownMenu.selectByIndex(2);
		Thread.sleep(3000);
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/?orderby=rating");
		
		
	}
	
	@Test(priority = 2)
	public void selectByVisibleTextExample() throws InterruptedException {
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='orderby']"));
		Select dropdownMenu =  new Select(dropdown);
		dropdownMenu.selectByVisibleText("Sort by popularity");
		Thread.sleep(3000);
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/?orderby=popularity");
		
		
	}
	
	
}
