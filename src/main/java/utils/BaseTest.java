package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;

public class BaseTest {
	
	public static WebDriver driver;
	public BasePage page;
	
	
	@BeforeClass
	public void setUp() {	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://keybooks.ro/");
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		page = new BasePage();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@AfterMethod
	public void recordFailure(ITestResult method) throws IOException {
		
		if(ITestResult.FAILURE == method.getStatus()) {
			TakesScreenshot poza =  (TakesScreenshot)driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			Files.copy(picture, new File("screenshots/"+method.getName() + "-"+ timeStamp + ".png"));
			
		}
		
	}
	
}
