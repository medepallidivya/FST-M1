package Project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	@Test
	public void homepageTest() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
		
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}