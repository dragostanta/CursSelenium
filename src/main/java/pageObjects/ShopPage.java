package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

public WebDriver driver;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@style='left: 100%;']") public WebElement rightSlider;
	@FindBy(xpath = "//span[@style='left: 0%;']") public WebElement leftSlider;

	
	public void dragAndDropSlider(WebElement element, int x, int y) {
		Actions action =  new Actions(driver);
		action.dragAndDropBy(element, x, y).perform();
		
	}
	
	
}
