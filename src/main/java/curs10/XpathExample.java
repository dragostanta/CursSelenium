package curs10;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample  extends BaseTest{
	
	@Test(priority =0)
	public void xpathExample1() throws InterruptedException {
		
		driver.findElement(By.xpath("//li[@class='menu_user_login']")).click();
		//logical OR
		driver.findElement(By.xpath("//input[@id='log' or @name='log']")).sendKeys("TestUser");
		//logical AND
		driver.findElement(By.xpath("//input[@id='password' and @name ='pwd']")).sendKeys("12345@67890");
		driver.findElement(By.xpath("//input[@id='rememberme']")).click();
		driver.findElement(By.xpath("//input[@class='submit_button']")).click();
		Thread.sleep(5000);
		String text = driver.findElement(By.xpath("//span[@class='user_name']")).getText();
		assertEquals(text, "Test User");
	
	}
	
	@Test(priority=1)
	public void xpathExample2() {
		
		driver.get("https://keybooks.ro/account/");
		driver.findElement(By.xpath("//p/a[contains(text(), 'recent orders')]")).click();
		
		boolean isOrderTabThere = driver.findElement(By.xpath("//th[contains(@class, 'woocommerce-orders-table__header-order-number')]")).isDisplayed();
		assertTrue(isOrderTabThere);
		assertTrue(driver.findElement(By.xpath("//th[contains(@class, 'woocommerce-orders-table__header-order-number')]")).isDisplayed());
		
		driver.findElement(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell-order-number')]/a[contains(text(), '#1653')]")).click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/account/view-order/1653/");
		
	}

}
