package tests;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class DataProviderLoginTest extends BaseTest{
	
	@DataProvider(name= "loginTestData")
	public Object[][] loginTestData(){
	
		//String[] textArray =  new String[3]
		//textArray[0] = "ceva";
		
		Object[][] data = new Object[4][3];
		
		data[0][0] = "TestUser";
		data[0][1] = "12345@67890";
		data[0][2] = true;
		
		data[1][0] = "UserGresit";
		data[1][1] = "parolaGresit";
		data[1][2] = false;
		
		
		data[2][0] = "test.test";
		data[2][1] = "test.test@123";
		data[2][2] = true;

		
		data[3][0] = "userGresit123";
		data[3][1] = "parolaGresita123";
		data[3][2] = false;
		
		/*           column 0 column 1       col3
		 *  Row0     TestUser  12345@67890
		 * 
		 *  Row1  	UserGresit  parolaGresita
		 * 
		 *  Row2 
		 *  
		 *  Row3 
		 */
		
		return data;
	}
	
	@Test(dataProvider = "loginTestData")
	public void loginWithDifferentUsersTest(String username, String password, boolean sucess) {
		
		page.navMenu.navigateTo(page.navMenu.loginLink);
		page.loginPage.loginInApp(username, password);
		
		if(sucess) {
			
			assertTrue(page.loginPage.sucessloginMessage.isDisplayed());
			page.loginPage.logoutFromApp();
			
		}else if(!sucess) {
			
			
			assertTrue(page.loginPage.errorLoginMessage.isDisplayed());
			page.loginPage.closeLoginPopUp();

			
			
		}
		
	}
	
	
}
