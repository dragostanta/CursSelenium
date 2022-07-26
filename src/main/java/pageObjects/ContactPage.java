package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	public WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "iframe") public WebElement iframe;
	@FindBy(xpath = "//button[@title='Zoom in']") public WebElement zoomIn;
	@FindBy(xpath = "//button[@title='Zoom out']") public WebElement zoomOut;
	@FindBy(partialLinkText = "map") public WebElement clickOutSideMap;
	
	@FindBy(xpath = "//input[@name='your-name']") public WebElement nameField;
	
	public void zoomMap(WebElement element) {
		driver.switchTo().frame(iframe);
		element.click();
		
	}
	
	public void openMapInNewTab() {
		clickOutSideMap.click();
	}
	
	public void sendMessage(String name) {
		
		nameField.sendKeys(name);
	}


}
