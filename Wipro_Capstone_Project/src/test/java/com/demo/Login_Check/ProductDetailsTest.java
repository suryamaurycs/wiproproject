package com.demo.Login_Check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class ProductDetailsTest {
	public static void main(String[] args) {

//		// Set up Chrome options
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--start-maximized");

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();

		try {
			// Open the specified URL
			driver.get("https://www.demoblaze.com/index.html");
			Thread.sleep(5000);

			// Locate and click on the first product (Samsung galaxy s6)
			WebElement firstProduct = driver.findElement(By.xpath("//a[contains(text(),'Samsung galaxy s6')]"));
			firstProduct.click();

			Thread.sleep(4000);

			// Verify that the product details are displayed
			WebElement productTitle = driver.findElement(By.className("name"));
			if (productTitle.isDisplayed()) {
				System.out.println("Product details are displayed: " + productTitle.getText());
			} else {
				System.out.println("Product details are not displayed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
