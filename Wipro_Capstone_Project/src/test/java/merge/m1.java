package merge;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class m1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver(); // connect to the browser
        driver.manage().window().maximize();// maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// using IMPLCTY for taking time to loading
        // Open the URL
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(3000);

        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();
        Thread.sleep(2000);

        // Fill in the login username
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        usernameField.sendKeys("wipro");

        // Fill in the login password
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys("wipro123");

        // Click the "Log in" button in the modal
        WebElement loginModalButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginModalButton.click();
        Thread.sleep(2000);

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
        // Adding product to the cart
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
        driver.quit(); // Close all windows
    }
}
