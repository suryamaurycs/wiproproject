package com.demo.Login_Check;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CategoriesAutomation {
    public static void main(String[] args) throws InterruptedException {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the Demoblaze website
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(5000);

        // Wait for the Phones category link to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement phonesCategory = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Laptops")));

        // Click on the Phones category link
        phonesCategory.click();
        Thread.sleep(3000);

        // Validate that the correct category page is displayed
        String expectedCategoryPageTitle = "STORE";
        String actualCategoryPageTitle = driver.getTitle();

        if (actualCategoryPageTitle.contains(expectedCategoryPageTitle)) {
            System.out.println("Successfully navigated to the Laptops category page.");
        } else {
            System.out.println("Failed to navigate to the Laptops category page.");
        }

        // Close the browser
        driver.quit();
    }
}


