package com.demo.Login_Check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigatePagesDemoBlaze {

    public static void main(String[] args) {
      
        // Initialize the ChromeDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open the Demoblaze website
            driver.get("https://www.demoblaze.com");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Wait for the page to load completely
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Store the initial URL
            String initialUrl = driver.getCurrentUrl();

            // Add delay to let the page fully load
            Thread.sleep(3000);

            // Click on the next page button (assuming there's a next page button with the id 'next2')
            WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("next2")));
            nextPageButton.click();

            // Add delay to let the next page fully load
            Thread.sleep(3000);

            // Wait for the next page to load (e.g., by waiting for an element that appears on the next page)
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card-block")));

            // Print a confirmation message
            System.out.println("Navigated to the next page!");

            // Add delay before navigating back to the initial URL
            Thread.sleep(3000);

            // Navigate back to the initial URL
            driver.navigate().to(initialUrl);

            // Add delay to let the previous page fully load
            Thread.sleep(3000);

            // Wait for the previous page to load
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("next2")));

            // Print a confirmation message
            System.out.println("Returned to the previous page!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
