package Blaze_Login_Check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login_Check {
    public static void main(String[] args) {

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the Demoblaze website
            driver.get("https://www.demoblaze.com/index.html");
            driver.manage().window().maximize();

            // Log in with an existing user
            loginUser(driver, "wipro", "wipro123");

            // Wait to observe the result
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void loginUser(WebDriver driver, String username, String password) throws InterruptedException {
        // Click on the "Log in" button
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();

        // Wait for the login modal to appear
        Thread.sleep(2000);

        // Fill in the username
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        usernameField.sendKeys(username);

        // Fill in the password
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys(password);

        // Click the "Log in" button in the modal
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        submitButton.click();

        // Wait for the login process to complete
        Thread.sleep(5000);
    }
}
