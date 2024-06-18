package merge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class m2 {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }

    @Test(priority = 2)
    public void login() throws InterruptedException {
        // Click on the login button to open the login modal
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();
        Thread.sleep(2000);

        // Enter username and password
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        usernameField.sendKeys("wipro");
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys("wipro123");

        // Click on the login button in the modal
        WebElement loginModalButton = driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
        loginModalButton.click();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void navigateHomePage() throws InterruptedException {
        // Verify the title of the page
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "STORE");

        // Verify the categories are displayed
        WebElement phonesCategory = driver.findElement(By.linkText("Phones"));
        WebElement laptopsCategory = driver.findElement(By.linkText("Laptops"));
        WebElement monitorsCategory = driver.findElement(By.linkText("Monitors"));

        Assert.assertTrue(phonesCategory.isDisplayed());
        Assert.assertTrue(laptopsCategory.isDisplayed());
        Assert.assertTrue(monitorsCategory.isDisplayed());

        System.out.println("Home Page Categories List:");
        for (WebElement category : driver.findElements(By.cssSelector("#itemc"))) {
            System.out.println("Category: " + category.getText());
        }
    }

    @Test(priority = 4)
    public void navigatePages() throws InterruptedException {
        // Store the initial URL
        String initialUrl = driver.getCurrentUrl();

        // Click on the next page button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("next2")));
        nextPageButton.click();
        Thread.sleep(3000);

        // Verify next page loaded
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card-block")));
        System.out.println("Navigated to the next page!");

        // Navigate back to the initial URL
        driver.navigate().to(initialUrl);
        Thread.sleep(3000);

        // Verify previous page loaded
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("next2")));
        System.out.println("Returned to the previous page!");
    }

    @Test(priority = 5)
    public void contactUs() throws InterruptedException {
        // Click on the "Contact" button
        WebElement contactButton = driver.findElement(By.xpath("//a[contains(text(), 'Contact')]"));
        contactButton.click();
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
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

    @Test(priority = 6)
    public void aboutUs() throws InterruptedException {
        // Click on the "About us" link
        WebElement aboutUsLink = driver.findElement(By.linkText("About us"));
        aboutUsLink.click();
        Thread.sleep(5000);

        // Close the "About Us" modal
        WebElement closeModalButton = driver.findElement(By.cssSelector("button.btn-secondary"));
        closeModalButton.click();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void addToCart() throws InterruptedException {
        // Click on a product and add it to the cart
        WebElement product = driver.findElement(By.linkText("Samsung galaxy s6"));
        product.click();
        Thread.sleep(2000);
        WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(text(), 'Add to cart')]"));
        addToCartButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // Go to the cart
        WebElement cartLink = driver.findElement(By.id("cartur"));
        cartLink.click();
        Thread.sleep(2000);

        // Delete the product from the cart
        WebElement deleteButton = driver.findElement(By.xpath("//a[contains(text(), 'Delete')]"));
        deleteButton.click();
        Thread.sleep(2000);

        // Navigate back to home page
        WebElement homeLink = driver.findElement(By.xpath("//a[contains(text(), 'Home')]"));
        homeLink.click();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void placeOrder() throws InterruptedException {
        // Click on a product, add it to the cart, and place an order
        WebElement product = driver.findElement(By.linkText("Samsung galaxy s6"));
        product.click();
        Thread.sleep(2000);
        WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(text(), 'Add to cart')]"));
        addToCartButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // Go to the cart and place the order
        WebElement cartLink = driver.findElement(By.id("cartur"));
        cartLink.click();
        Thread.sleep(2000);
        WebElement placeOrderButton = driver.findElement(By.xpath("//button[contains(text(), 'Place Order')]"));
        placeOrderButton.click();
        Thread.sleep(2000);

        // Fill in the order details
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("Test User");
        WebElement countryField = driver.findElement(By.id("country"));
        countryField.sendKeys("Test Country");
        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys("Test City");
        WebElement creditCardField = driver.findElement(By.id("card"));
        creditCardField.sendKeys("1234567890123456");
        WebElement monthField = driver.findElement(By.id("month"));
        monthField.sendKeys("12");
        WebElement yearField = driver.findElement(By.id("year"));
        yearField.sendKeys("2024");

        // Click the purchase button
        WebElement purchaseButton = driver.findElement(By.xpath("//button[contains(text(), 'Purchase')]"));
        purchaseButton.click();
        Thread.sleep(2000);

        // Verify the thank you message
        WebElement thankYouMessage = driver.findElement(By.xpath("//h2[contains(text(), 'Thank you for your purchase!')]"));
        Assert.assertTrue(thankYouMessage.isDisplayed());

        // Close the confirmation dialog
        WebElement closeButton = driver.findElement(By.xpath("//button[contains(text(), 'OK')]"));
        closeButton.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
