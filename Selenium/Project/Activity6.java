package Project;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("http://alchemy.hguy.co/orangehrm");
		System.out.println("Page title is: " + driver.getTitle());
		
		//enter username and password
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		//click on the Directory is vsisble tab
		WebElement dispLay = driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']"));
		System.out.println("menu directory is visible" + dispLay.isDisplayed());
		
		try {
				WebElement menuLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_directory_viewDirectory']")));
				menuLink.click();
			
				System.out.println("Element is clickable.");
	
		}catch (Exception e) {
				System.out.println(" Element is not clickable.");
		}
		
		driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']")).click();
				
		//WebElement searchDir = wait.until(ExpectedConditions.visibilityOfElementLocated
        		//(By.xpath("//h1[contains(text(), 'Search Directory')]")));
		
		String message = driver.findElement(By.xpath("//h1[contains(text(), 'Search Directory')]")).getText();
        
		System.out.println("Header name is " + message);
		driver.quit();
		
		
	}

}