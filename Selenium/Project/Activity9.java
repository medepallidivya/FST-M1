package Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9 {

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
		
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();
			
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@id, 'emgcontact_list')]/thead/tr/th"));
        System.out.println("Number of columns: " + cols.size());
        // Print the number of rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id, 'emgcontact_list')]/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());
        //print the whole table along with the column names
    
        for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | "); // Print each cell's text
			}
			System.out.println();
		}
				//close the browser
		driver.quit();
			
	}
}