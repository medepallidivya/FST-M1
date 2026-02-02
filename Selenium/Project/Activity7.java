package Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("http://alchemy.hguy.co/orangehrm");
		System.out.println("Page title is: " + driver.getTitle());
		
		//enter username and password
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		WebElement menuLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_pim_viewMyDetails']")));
		menuLink.click();
		
		//click on the My info tab
		driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
		
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div[1]/ul/li[9]/a")).click();
		
		driver.findElement(By.xpath("//input[@id='addWorkExperience']")).click();
		
		driver.findElement(By.xpath("//input[@id='experience_employer']")).sendKeys("IBM");
		
		driver.findElement(By.xpath("//input[@id='experience_jobtitle']")).sendKeys("Senior Test Specialist");
		
		WebElement fromDate = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='experience_from_date']")));
		fromDate.clear();
		fromDate.sendKeys("2017-08-01");
		
		WebElement toDate = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='experience_to_date']")));
		toDate.clear();
		toDate.sendKeys("2025-08-17");
		
		driver.findElement(By.xpath("//input[@id='btnWorkExpSave']")).click();
		
		driver.quit();
		
	}

}