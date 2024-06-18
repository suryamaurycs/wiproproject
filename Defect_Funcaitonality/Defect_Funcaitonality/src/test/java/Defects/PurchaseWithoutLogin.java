package Defects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PurchaseWithoutLogin {
    public static void main(String[] args) {
        // Set the path of chromedriver.exe
      //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://www.demoblaze.com/index.html");

        // Add product to cart
        driver.findElement(By.xpath("//a[contains(text(),'Samsung galaxy s6')]")).click();

        // Wait for the modal to appear
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click on "Add to cart" button in the modal
        driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();

        // Wait for the alert to appear
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Accept the alert
        driver.switchTo().alert().accept();

        // Go to cart
        driver.findElement(By.id("cartur")).click();

        // Proceed to checkout
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();

        // Fill in the form details
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("country")).sendKeys("United States");
        driver.findElement(By.id("city")).sendKeys("New York");
        driver.findElement(By.id("card")).sendKeys("1234567890123456");
        driver.findElement(By.id("month")).sendKeys("01");
        driver.findElement(By.id("year")).sendKeys("2025");

        // Purchase the item
        driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();

        // Close the browser
        driver.quit();
    }
}
