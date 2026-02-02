package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		// Initialize the Firefox driver
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		// Print the title of the page
		System.out.println("Page title is: " + driver.getTitle());
	}
	@Test
		public void verifyHeaderImage() {
			// Verify the header image
			String headerImageSrc = driver.findElement(By.xpath("//*[@id='divLogo']/img")).getAttribute("src");
			System.out.println("Header image source is: " + headerImageSrc);
			// You can add assertions here to validate the header image if needed
			Assert.assertTrue(headerImageSrc.contains("logo.png"), "Header image source match expected value.");
		
	}
	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
