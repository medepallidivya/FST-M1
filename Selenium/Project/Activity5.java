package Project;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity5 {

	public static void main(String[] args)  {
		
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
				
		//click on the Edit personal info
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
		//enter first name, last name and DOB
		WebElement firstName = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='personal_txtEmpFirstName']")));
		firstName.clear();
		firstName.sendKeys("John");
		WebElement lastName = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='personal_txtEmpLastName']")));
		lastName.clear();
		lastName.sendKeys("Doe");
		driver.findElement(By.xpath("//input[@id='personal_optGender_1']")).click();
		WebElement dateDob = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='personal_DOB']")));
		dateDob.clear();
		dateDob.sendKeys("1996-03-07");
		
		
		// Find the dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
        // Pass the WebElement to the Select object
        Select singleSelect = new Select(dropdown);
        //List<WebElement> options = Select.getOptions();
        singleSelect.selectByVisibleText("Indian");
        System.out.println("National choosen: " + singleSelect.getFirstSelectedOption().getText());
		//save the employee details
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
	}
}