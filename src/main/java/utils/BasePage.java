package utils;

import pageObjects.ContactPage;
import pageObjects.LoginPage;
import pageObjects.NavMenuPage;
import pageObjects.ShopPage;

public class BasePage extends BaseTest {

	public NavMenuPage navMenu = new NavMenuPage(driver);
	public LoginPage loginPage = new LoginPage(driver);
	public ContactPage contactPage = new ContactPage(driver);
	public ShopPage shopPage =  new ShopPage(driver);
	
}
