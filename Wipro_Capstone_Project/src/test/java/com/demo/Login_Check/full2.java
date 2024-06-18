package com.demo.Login_Check;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class full2 {
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

	            // Click on the close button
	            WebElement closeButton = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
	            closeButton.click();
	            Thread.sleep(2000);
	            
	            
	            
	            
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }

}
