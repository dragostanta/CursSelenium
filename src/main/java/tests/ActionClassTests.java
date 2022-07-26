package tests;

import org.testng.annotations.Test;

import utils.BaseTest;

public class ActionClassTests extends BaseTest{
	
	
	@Test
	public void hoverExample() throws InterruptedException {
		
		page.navMenu.hoverMenu(page.navMenu.blogLink);
		Thread.sleep(3000);
		page.navMenu.navigateTo(page.navMenu.postFormatsLink);
		Thread.sleep(3000);
		
	}

	@Test
	public void dragAndDropExample() throws InterruptedException {
		
		page.navMenu.navigateTo(page.navMenu.shopLink);
		page.shopPage.dragAndDropSlider(page.shopPage.leftSlider, 100, 0);
		Thread.sleep(3000);

		page.shopPage.dragAndDropSlider(page.shopPage.rightSlider, -100, 0);
		Thread.sleep(3000);

	}
	
}
