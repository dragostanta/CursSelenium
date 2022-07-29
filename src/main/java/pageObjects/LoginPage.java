package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v101.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="log") public WebElement usernameField;
	@FindBy(id="password") public WebElement passwordField;
	@FindBy(xpath ="//input[@class='submit_button']") public WebElement submitButton;
	@FindBy(xpath="//li[@class='menu_user_logout']") public WebElement logoutButton;
	@FindBy(xpath = "//a[@class='popup_close']")public WebElement closePopUp;
	
	@FindBy(xpath="//div[contains(@class, 'sc_infobox_style_success')]") public WebElement sucessloginMessage;
	@FindBy(xpath="//div[contains(@class, 'sc_infobox_style_error')]") public WebElement errorLoginMessage;
	
	public void loginInApp(String username, String parola) {
		Log.info("called method loginInAPP");
		Log.info("Send keys with value " + username);
		usernameField.sendKeys(username);
		passwordField.sendKeys(parola);
		Log.info("Send keys for pass with value " + parola);
		submitButton.click();	
		Log.info("Clicked on submit button");

	}
	
	public void logoutFromApp() {
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		Log.info("Wait for logout button to be visible");
		logoutButton.click();
		Log.info("Called logout button .click");

	}
	
	
	public void closeLoginPopUp() {
		Log.info("Called clear method on usernameField");
		usernameField.clear();
		passwordField.clear();
		Log.info("Called clear method on passwordField");
		closePopUp.click();
		Log.info("Called click on closePopUp");

		
	}
	
}
