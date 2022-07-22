package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObjects.NavMenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

	
	@Test(priority=0)
	public void validLogin() throws InterruptedException {

		page.navMenu.navigateTo(page.navMenu.loginLink);
		page.loginPage.loginInApp("TestUser", "12345@67890");
		assertTrue(page.loginPage.sucessloginMessage.isDisplayed());
		page.loginPage.logoutFromApp();

	}
	
	@Test(priority =1)
	public void invalidTest() {
		
		page.navMenu.navigateTo(page.navMenu.loginLink);
		page.loginPage.loginInApp("Tes13131tUser", "12345@67890");
		
		//varianta 1
		assertTrue(page.loginPage.errorLoginMessage.isDisplayed());
		
		//varianta 2
		boolean conditie = page.loginPage.errorLoginMessage.isDisplayed();
		assertTrue(conditie);
		assertEquals(conditie, true);
		
		
	//	BaseTest -> creaza obiectul de tip base page --< page
	//	BasePage -> iti creaza obiectele de tip pageObject --> naveMenu, loginPage etc
	//	NavMenuPage, LoginPage--> creaza WebElement si metode specifice acelei pagini
		
	//	@Test --mosteneste BaseTest --> deci are acces la obiectul page --> BasePage
		
		//page.loginPage.loginInApp(null, null);
		

		
		
		
		
		
	}
	
}
