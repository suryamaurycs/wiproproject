package com.demo.Login_Check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoblazeRegistration{
    public static void main(String[] args) {
  

    	WebDriver driver = new ChromeDriver();
    	
    	try {
	       
        // Open the Demoblaze website
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();

        // Click on the "Sign up" button
        WebElement signupButton = driver.findElement(By.id("signin2"));
        signupButton.click();

        // Wait for the sign-up modal to appear
        Thread.sleep(2000); // Use an explicit wait in a real scenario

        // Fill in the username
        WebElement usernameField = driver.findElement(By.id("sign-username"));
        usernameField.sendKeys("testuser");

        // Fill in the password
        WebElement passwordField = driver.findElement(By.id("sign-password"));
        passwordField.sendKeys("testpassword");

        // Click the "Sign up" button in the modal
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
        submitButton.click();

        // Wait for some time to see the result
        Thread.sleep(3000); // Adjust as needed

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
