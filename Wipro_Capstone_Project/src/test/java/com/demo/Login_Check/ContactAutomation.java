package com.demo.Login_Check;

//package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactAutomation {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
//        // Set the path to your chromedriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }

    @Test
    public void testContactForm() throws InterruptedException {
        // Click on the "Contact" button
        WebElement contactButton = driver.findElement(By.xpath("//a[contains(text(), 'Contact')]"));
        contactButton.click();

        // Wait for the contact modal to be visible
        Thread.sleep(2000);

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

        // Optionally, you can add assertions to verify the expected behavior
        // For instance, checking the absence of the modal after sending the message
        Assert.assertTrue(driver.findElements(By.id("exampleModal")).isEmpty(), "Contact modal should be closed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

