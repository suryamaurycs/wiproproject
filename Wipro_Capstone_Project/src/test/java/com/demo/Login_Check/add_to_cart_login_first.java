package com.demo.Login_Check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class add_to_cart_login_first {

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
            Thread.sleep(2000);

            // Click on the login button to open the login modal
            WebElement loginButton = driver.findElement(By.id("login2"));
            loginButton.click();

            // Wait for the login modal to be displayed
            Thread.sleep(2000);

            // Enter username
            WebElement usernameField = driver.findElement(By.id("loginusername"));
            usernameField.sendKeys("wipro");

            // Enter password
            WebElement passwordField = driver.findElement(By.id("loginpassword"));
            passwordField.sendKeys("wipro123");

            // Click on the login button in the modal
            WebElement loginModalButton = driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
            loginModalButton.click();

            // Wait for the login to be processed
            Thread.sleep(5000); // Increase wait time if necessary

            // Find a product (e.g., "Samsung galaxy s6") and click on it
            WebElement product = driver.findElement(By.linkText("Samsung galaxy s6"));
            product.click();

            // Wait for the product details page to load
            Thread.sleep(2000);

            // Click on the "Add to cart" button
            WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(text(), 'Add to cart')]"));
            addToCartButton.click();

            // Wait for the alert to be displayed and accept it
            Thread.sleep(2000);
            driver.switchTo().alert().accept();

            // Print a confirmation message
            System.out.println("Item successfully added to the cart!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
