package utils;

import pageObjects.LoginPage;
import pageObjects.NavMenuPage;

public class BasePage extends BaseTest {

	public NavMenuPage navMenu = new NavMenuPage(driver);
	public LoginPage loginPage = new LoginPage(driver);
	
}
