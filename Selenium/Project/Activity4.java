package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        // Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void loginTest() {
        // Find the Username and password fields
    	WebElement txtUsername = driver.findElement(By.id("txtUsername"));
        WebElement txtPassword = driver.findElement(By.id("txtPassword"));

        // Enter credentials
        txtUsername.sendKeys("orange");
        txtPassword.sendKeys("orangepassword123");
        // Click login
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Ren");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("kris");
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        
        	}
        
        

	@AfterClass
    public void afterClass() {
        // Close browser
        driver.close();
    }
}