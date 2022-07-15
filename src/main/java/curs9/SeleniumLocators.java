package curs9;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 0)
	public void linkTextLocator() throws InterruptedException {
		
		//<a href="https://keybooks.ro/shop/">Books</a>
		//1 identificam elemente
		WebElement booksLink = driver.findElement(By.linkText("BOOKS"));
		//2. actionam asupra elementelor
		booksLink.click();
		//3 verificam daca in urma actiunii rezultatul este cel asteptat
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");	
		Thread.sleep(4000);	
	}
	
	@Test(priority = 1)
	public void partialLinkTextLocator() throws InterruptedException {
		WebElement cookingBookLink =  driver.findElement(By.partialLinkText("Cook"));
		cookingBookLink.click();
		Thread.sleep(4000);	
		WebElement bookTitle = driver.findElement(By.cssSelector("h1[class*='product_title']"));
		
		//<h1 class="product_title entry-title">Cooking with love</h1>
		//cssSelector :
		// h1[class*='product_title']
		
		assertTrue(bookTitle.isDisplayed());
		assertEquals(bookTitle.getText(), "Cooking with love");
	}
	
	@Test(priority = 3)
	public void classNameLocator() {
		WebElement price  =  driver.findElement(By.className("price"));
		assertTrue(price.isDisplayed());
		String productPrice = price.getText();
		assertEquals(productPrice, "$20.55");
	}
	
	@Test(priority = 4)
	public void idLocator() throws InterruptedException {
		
		JavascriptExecutor  jse =  (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 3000) ");
		
		WebElement tabReview = driver.findElement(By.id("tab-title-reviews"));
		tabReview.click();
		Thread.sleep(4000);
		WebElement textAreaComment = driver.findElement(By.id("comment"));
		assertTrue(textAreaComment.isDisplayed());
		textAreaComment.sendKeys("Nice book!");
	}
	
	@Test(priority=5)
	public void nameLocator() throws InterruptedException {
		WebElement nameField =  driver.findElement(By.name("author"));
		nameField.sendKeys("Test");
		Thread.sleep(4000);
		nameField.clear();
		Thread.sleep(4000);
		nameField.sendKeys("ALt text");
		Thread.sleep(4000);		
	}

	@Test(priority=6)
	public void cssLocator() throws InterruptedException {
		WebElement emailField =  driver.findElement(By.cssSelector("input[type='email']"));
		emailField.sendKeys("test@test.com");
		Thread.sleep(4000);		

	}
	@Test(priority=7)
	public void xpathLocator() throws InterruptedException {
		      //<a class="star-3" href="#">3</a>
//cssSelector--> a[class='star-3']
//xpath ------->//a[@class='star-3']
		WebElement rating =  driver.findElement(By.xpath("//a[@class='star-3']"));
		rating.click();
		
		//<input name="submit" type="submit" id="submit" class="submit" value="Submit">
		//input[@name='submit']
		
		WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
		submitButton.click();
		Thread.sleep(4000);		
	}
}
