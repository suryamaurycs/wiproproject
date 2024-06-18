package com.demo.Login_Check;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class full_selenium_auto {
    private WebDriver driver;
    private WebDriverWait wait;

    public void setUp() {
        // Initialize WebDriver
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login() {
        // Click on the login button to open the login modal
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        loginButton.click();

        // Enter username and password
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        usernameField.sendKeys("wipro");
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys("wipro123");

        // Click on the login button in the modal
        WebElement loginModalButton = driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
        loginModalButton.click();

        // Wait for login to complete
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
    }

    public void navigateHomePage() {
        // Verify the title of the page
        String pageTitle = driver.getTitle();
        if (!pageTitle.equals("STORE")) {
            throw new AssertionError("Page title does not match");
        }

        // Verify the categories are displayed
        WebElement phonesCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Phones")));
        WebElement laptopsCategory = driver.findElement(By.linkText("Laptops"));
        WebElement monitorsCategory = driver.findElement(By.linkText("Monitors"));

        if (!phonesCategory.isDisplayed() || !laptopsCategory.isDisplayed() || !monitorsCategory.isDisplayed()) {
            throw new AssertionError("Categories are not displayed");
        }

        System.out.println("Home Page Categories List:");
        for (WebElement category : driver.findElements(By.cssSelector("#itemc"))) {
            System.out.println("Category: " + category.getText());
        }
    }

    public void navigatePages() {
        // Store the initial URL
        String initialUrl = driver.getCurrentUrl();

        // Click on the next page button
        WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("next2")));
        nextPageButton.click();

        // Verify next page loaded
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card-block")));
        System.out.println("Navigated to the next page!");

        // Navigate back to the initial URL
        driver.navigate().to(initialUrl);

        // Verify previous page loaded
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("next2")));
        System.out.println("Returned to the previous page!");
    }

    public void contactUs() {
        // Click on the "Contact" button
        WebElement contactButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Contact')]")));
        contactButton.click();

        // Fill out the contact form
        WebElement contactEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipient-email")));
        contactEmail.sendKeys("test@example.com");
        WebElement contactName = driver.findElement(By.id("recipient-name"));
        contactName.sendKeys("Test User");
        WebElement contactMessage = driver.findElement(By.id("message-text"));
        contactMessage.sendKeys("This is a test message.");

        // Click the send message button
        WebElement sendMessageButton = driver.findElement(By.xpath("//button[contains(text(), 'Send message')]"));
        sendMessageButton.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void aboutUs() {
        // Click on the "About us" link 
        WebElement aboutUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("About us")));
        aboutUsLink.click();

        // Click on the close button of the modal
        WebElement closeAbout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button")));
        closeAbout.click();
        driver.navigate().refresh();
    }

    public void addToCart() {
        // Click on a product and add it to the cart
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung galaxy s6")));
        product.click();

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Add to cart')]")));
        addToCartButton.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        // Go to the cart
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
        cartLink.click();

        // Delete the product from the cart
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Delete')]")));
        deleteButton.click();

        // Navigate back to home page using JavaScript
        WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Home')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeLink);
    }

    public void checkOut() {
        // Click on a product
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Samsung galaxy s6')]")));
        product.click();

        // Adding product to cart
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Add to cart')]")));
        addToCartButton.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        // Go to the cart
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Cart')]")));
        cartLink.click();

        // Proceed to checkout
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Place Order')]")));
        checkoutButton.click();

        // Fill in the checkout form
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
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

        // Complete the checkout
        WebElement purchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Purchase')]")));
        purchaseButton.click();

        // Verify the thank you message
        WebElement thankYouMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Thank you for your purchase!')]")));
        if (!thankYouMessage.isDisplayed()) {
            throw new AssertionError("Thank you message not displayed");
        }
        System.out.println("Thank you for your purchase!");

        // Close the confirmation dialog
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'OK')]")));
        closeButton.click();

        // Navigate back to home page using JavaScript
        WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Home')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeLink);
    }

    public void quit() {
        driver.quit();
    }

    public static void main(String[] args) {
        full_selenium_auto test = new full_selenium_auto();
        test.setUp();
        test.login();
        test.navigateHomePage();
        test.navigatePages();
        test.contactUs();
        test.aboutUs();
        test.addToCart();
        test.checkOut();
        test.quit();
    }
}
