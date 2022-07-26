package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import utils.BaseTest;

public class IFrameTest extends BaseTest{
	
	
	@Test
	public void iframeExample() throws InterruptedException {
		
		page.navMenu.navigateTo(page.navMenu.contactsLink);
		page.contactPage.zoomMap(page.contactPage.zoomIn);
		Thread.sleep(3000);
		System.out.println("Unu :" + driver.getWindowHandles());
		//page.contactPage.sendMessage("TestCeva");
		Thread.sleep(3000);
		page.contactPage.openMapInNewTab();
		System.out.println("doi" + driver.getWindowHandles());
		Thread.sleep(3000);
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		driver.close();
		Thread.sleep(3000);

		
		
	}

}
