package com.demo.Login_Check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AboutUsAutomation {
    public static void main(String[] args) {
//        // Set the path to your chromedriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the Demoblaze website
        driver.get("https://www.demoblaze.com/index.html");

        // Click on the "About us" link
        WebElement aboutUsLink = driver.findElement(By.linkText("About us"));
        aboutUsLink.click();

        // Wait for the "About Us" page to load
        try {
            Thread.sleep(5000); // Add some wait time for the page to load (not recommended for real automation)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Retrieve and print the content of the "About Us" page
        WebElement aboutUsContent = driver.findElement(By.className("col-md-6"));
        System.out.println("About Us Page Content:");
        System.out.println(aboutUsContent.getText());

        // Close the browser
        driver.quit();
    }
}
