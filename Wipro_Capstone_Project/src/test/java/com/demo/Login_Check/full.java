package com.demo.Login_Check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class full {

    public static void main(String[] args) throws InterruptedException {
        // Initialize the ChromeDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Open the Demoblaze website
            driver.get("https://www.demoblaze.com/index.html");
            driver.manage().window().maximize();
            Thread.sleep(5000); // Adding delay for page load

            // Click on the "Log in" button
            WebElement loginButton = driver.findElement(By.id("login2"));
            loginButton.click();
            Thread.sleep(2000); // Adding delay for modal to appear

            // Fill in the login credentials and log in
            WebElement usernameField = driver.findElement(By.id("loginusername"));
            usernameField.sendKeys("wipro");
            WebElement passwordField = driver.findElement(By.id("loginpassword"));
            passwordField.sendKeys("wipro123");
            WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
            submitButton.click();
            Thread.sleep(5000); // Adding delay for login to complete

            // Click on the "About us" link
            WebElement aboutUsLink = driver.findElement(By.linkText("About us"));
            aboutUsLink.click();
            Thread.sleep(5000); // Adding delay for page load

            // Retrieve and print the content of the "About Us" page
            WebElement aboutUsContent = driver.findElement(By.className("col-md-6"));
            System.out.println("About Us Page Content:");
            System.out.println(aboutUsContent.getText());

            // Close the About Us page
            WebElement aboutUsCloseButton = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
            aboutUsCloseButton.click();
            Thread.sleep(2000); // Adding delay for modal to close

            // Click on the "Contact" button
            WebElement contactButton = driver.findElement(By.xpath("//a[contains(text(), 'Contact')]"));
            contactButton.click();
            Thread.sleep(2000); // Adding delay for modal to appear

            // Fill out the contact form
            WebElement contactEmail = driver.findElement(By.id("recipient-email"));
            contactEmail.sendKeys("test@example.com");
            WebElement contactName = driver.findElement(By.id("recipient-name"));
            contactName.sendKeys("Test User");
            WebElement contactMessage = driver.findElement(By.id("message-text"));
            contactMessage.sendKeys("This is a test message.");
            // Click the send message button
            WebElement sendMessageButton = driver.findElement(By.xpath("//button[contains(text(), 'Send message')]"));
            sendMessageButton.click();
            // Wait for the alert and verify it
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Thread.sleep(2000); // Adding delay for modal to close

            // Click on the "Phones" category link
            WebElement phonesCategory = driver.findElement(By.linkText("Phones"));
            phonesCategory.click();
            Thread.sleep(2000); // Adding delay for page load

            // Click on the "Laptops" category link
            WebElement laptopsCategory = driver.findElement(By.linkText("Laptops"));
            laptopsCategory.click();
            Thread.sleep(2000); // Adding delay for page load

            // Click on the "Monitors" category link
            WebElement monitorsCategory = driver.findElement(By.linkText("Monitors"));
            monitorsCategory.click();
            Thread.sleep(2000); // Adding delay for page load

            // Store the initial URL
            String initialUrl = driver.getCurrentUrl();

            // Click on the next page button
            WebElement nextPageButton = driver.findElement(By.id("next2"));
            nextPageButton.click();
            Thread.sleep(2000); // Adding delay for page load

            // Navigate back to the initial URL
            driver.navigate().to(initialUrl);
            Thread.sleep(2000); // Adding delay for page load

            // Click on the "Home" link
            WebElement homeLink = driver.findElement(By.linkText("Home"));
            homeLink.click();
            Thread.sleep(2000); // Adding delay for page load

            // Print out the names of the categories
            System.out.println("Home Page Categories List :");
            List<WebElement> categories = driver.findElements(By.cssSelector("#itemc"));
            for (WebElement category : categories) {
                System.out.println("Category: " + category.getText());
            }
            Thread.sleep(2000); // Adding delay for printing categories

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
