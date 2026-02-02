package Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("http://alchemy.hguy.co/orangehrm");
		System.out.println("Page title is: " + driver.getTitle());
		
		//enter username and password
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orange");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		WebElement targetElement = driver.findElement(By.xpath("//img[@src='/orangehrm/symfony/web/webres_5d69118beeec64.10301452/orangehrmLeavePlugin/images/ApplyLeave.png']"));
		targetElement.click();
		
		//find the apply leave request
		//driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/span")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='applyleave_txtLeaveType']")));
		String message = driver.findElement(By.xpath("//h1[contains(text(), 'Apply Leave')]")).getText();
		System.out.println("Header name is " + message);
		
		driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']")).click();
		driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']/option[2]")).click();

		driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']")).sendKeys("2025-15-01");
	
		driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']")).sendKeys("2025-15-05");
	
		driver.findElement(By.xpath("//input[@id='applyBtn']")).click();
		
		//my leave
		driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']")).click();
		//check the status of the leave request
		String status = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr"
				+ "[1]/td[5]")).getText();
		System.out.println("Status of the leave request is: " + status);
		driver.quit();
		

	}

}
