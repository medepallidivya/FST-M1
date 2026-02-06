import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://training-support.net/webelements/tabs");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        // Print the handle of the parent window
        System.out.println("Current tab: " + driver.getWindowHandle());

        // Find button to open new tab
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open A New Tab']"))).click();
        // Wait for the second tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        // Print all window handles
        System.out.println("Currently open windows: " + driver.getWindowHandles());

        // Switch focus to the latest tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Wait for the new page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Another One')]")));
        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());
        // Print the title and heading of the new page
        System.out.println("New Page title: " + driver.getTitle());
        System.out.println("New Page message: " + driver.findElement(By.cssSelector("h2.mt-5")).getText());
        // Find and click the button on page to open another tab
        driver.findElement(By.xpath("//button[contains(text(), 'Another One')]")).click();

        // Wait for new tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        // Switch focus
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Close the browser
        driver.quit();
    }
}

Activity 21
Python Solution:

# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

# Start the Driver
with webdriver.Firefox() as driver:
    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/tabs")
    # Print the title of the page
    print("Page title is: ", driver.title)
    # Print the handle of the parent window
    print("Current tab: ", driver.current_window_handle)

    # Find button to open new tab
    wait.until(EC.element_to_be_clickable((By.XPATH, "//button[text()='Open A New Tab']"))).click()
    # Wait for the second tab to open
    wait.until(EC.number_of_windows_to_be(2))
    # Print all window handles
    print("Currently open windows: ", driver.window_handles)
    driver.switch_to.window(driver.window_handles[1])

    # Wait for the new page to load
    wait.until(EC.element_to_be_clickable((By.XPATH, "//button[contains(text(), 'Another One')]")))
    # Print the handle of the current tab
    print("Current tab: ", driver.current_window_handle)
    # Print the title and heading of the new page
    print("New Page title: ", driver.title)
    print("New Page message: ", driver.find_element(By.CSS_SELECTOR, "h2.mt-5").text)
    # Find and click the button on page to open another tab
    driver.find_element(By.XPATH, "//button[contains(text(), 'Another One')]").click()

    # Wait for new tab to open
    wait.until(EC.number_of_windows_to_be(3))
    # Switch focus
    for handle in driver.window_handles:
        driver.switch_to.window(driver.window_handles[2])

Handling iframes
BONUS

iframes
You can define an inline frame with HTML tag <iframe>.
The <iframe> tag defines a rectangular region within the document in which the browser can display a separate document, including scrollbars and borders.
An inline frame is used to embed another document within the current HTML document.
The src attribute is used to specify the URL of the document that occupies the inline frame.

<iframe src="/sourcefile" width="500" height="500"></iframe>
BONUS

Handling Popups
51 . 2



