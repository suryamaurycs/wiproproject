package com.demo.Login_Check;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class abc {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver(); // connect to the browser
		driver.manage().window().maximize();// maximize window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// using IMPLCTY for taking time to loading
		// Open the URL
		driver.get("https://www.demoblaze.com/index.html");
		Thread.sleep(3000);
		WebElement signupButton = driver.findElement(By.id("signin2"));
		signupButton.click();

		// Wait for the sign-up modal to appear
		Thread.sleep(2000); // Use an explicit wait in a real scenario

		// Fill in the signUp username
		WebElement usernameField = driver.findElement(By.id("sign-username"));
		usernameField.sendKeys("xyz");

		// Fill in the SignUp password
		WebElement passwordField = driver.findElement(By.id("sign-password"));
		passwordField.sendKeys("xyz123");

		// Click the "Sign up" button in the modal
		WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
		submitButton.click();

		// Wait for some time to see the result
		Thread.sleep(2000); // Adjust as needed

		// Log in with an existing user
		WebElement loginButton = driver.findElement(By.id("login2"));
		loginButton.click();

		// Wait to observe the result
		Thread.sleep(2000);

		// Fill in the login username
		WebElement loginusernameField = driver.findElement(By.id("loginusername"));
		loginusernameField.sendKeys("testuser");

		WebElement loginpasswordField = driver.findElement(By.id("loginpassword"));
		loginpasswordField.sendKeys("testuser123");

		WebElement login = driver.findElement(By.cssSelector("button[type='button'][onclick='logIn()']"));
		login.click();

		// Home Page
		driver.get("https://www.demoblaze.com/index.html");
		Thread.sleep(2000);

		// Categories
		WebElement category = driver.findElement(By.xpath("//a[text()='Phones']"));

		// Click on the category
		category.click();

		// Click on a product
		WebElement product = driver.findElement(By.xpath("//a[contains(text(),'Samsung galaxy s6')]"));
		product.click();
		Thread.sleep(3000);
		// Adding product in cart
		WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]"));
		addToCartButton.click();

		Thread.sleep(3000);

		// Wait for the cart alert
		driver.switchTo().alert().accept();// Accept pop-up button as pressing OK

		// Go to the cart
		WebElement cartLink = driver.findElement(By.xpath("//a[contains(text(),'Cart')]"));
		cartLink.click();
		Thread.sleep(3000);
		// Proceed to checkout
		WebElement checkoutButton = driver.findElement(By.xpath("//button[contains(text(),'Place Order')]"));
		checkoutButton.click();
		Thread.sleep(3000);
		// Fill in the checkout form
		WebElement nameField = driver.findElement(By.id("name"));
		nameField.sendKeys("Suneel Verma");

		WebElement countryField = driver.findElement(By.id("country"));
		countryField.sendKeys("India");

		WebElement cityField = driver.findElement(By.id("city"));
		cityField.sendKeys("Ayodhya");

		WebElement creditCardField = driver.findElement(By.id("card"));
		creditCardField.sendKeys("1111 2222 3333");

		WebElement monthField = driver.findElement(By.id("month"));
		monthField.sendKeys("06");

		WebElement yearField = driver.findElement(By.id("year"));
		yearField.sendKeys("2024");
		Thread.sleep(3000);
		// Complete the checkout
		WebElement purchaseButton = driver.findElement(By.xpath("//button[contains(text(),'Purchase')]"));
		purchaseButton.click();
		driver.quit(); // Close the all window
	}
}