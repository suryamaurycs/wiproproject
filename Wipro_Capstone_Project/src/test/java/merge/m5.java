package merge;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class m5 {

    public static void main(String[] args) {
        // Initialize WebDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Login
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
            loginButton.click();
            Thread.sleep(2000); // Wait for the login modal to appear

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
            usernameField.sendKeys("wipro");
            WebElement passwordField = driver.findElement(By.id("loginpassword"));
            passwordField.sendKeys("wipro123");

            WebElement loginModalButton = driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
            loginModalButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

            // Navigate Home Page
            String pageTitle = driver.getTitle();
            if (!pageTitle.equals("STORE")) {
                throw new AssertionError("Page title does not match");
            }

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

            // Navigate Pages
            String initialUrl = driver.getCurrentUrl();
            WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("next2")));
            nextPageButton.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card-block")));

            System.out.println("Navigated to the next page!");
            driver.navigate().to(initialUrl);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("next2")));

            System.out.println("Returned to the previous page!");

            // Contact Us
            WebElement contactButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Contact')]")));
            contactButton.click();
            Thread.sleep(2000); // Wait for the contact modal to appear

            WebElement contactEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipient-email")));
            contactEmail.sendKeys("test@example.com");
            WebElement contactName = driver.findElement(By.id("recipient-name"));
            contactName.sendKeys("Test User");
            WebElement contactMessage = driver.findElement(By.id("message-text"));
            contactMessage.sendKeys("This is a test message.");

            WebElement sendMessageButton = driver.findElement(By.xpath("//button[contains(text(), 'Send message')]"));
            sendMessageButton.click();
            wait.until(ExpectedConditions.alertIsPresent()).accept();

            // About Us
            WebElement aboutUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("About us")));
            aboutUsLink.click();
            Thread.sleep(2000); // Wait for the about us modal to appear

            WebElement closeAbout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button")));
            closeAbout.click();
            driver.navigate().refresh();

            // Add to Cart
            WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung galaxy s6")));
            product.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Samsung galaxy s6')]")));

            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Add to cart')]")));
            addToCartButton.click();
            wait.until(ExpectedConditions.alertIsPresent()).accept();

            WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
            cartLink.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='success']"))); // Ensure cart has items

            WebElement deleteButton = driver.findElement(By.xpath("//a[contains(text(), 'Delete')]"));
            deleteButton.click();

            WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Home')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeLink);

            // Checkout
            product = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung galaxy s6")));
            product.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Samsung galaxy s6')]")));

            addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Add to cart')]")));
            addToCartButton.click();
            wait.until(ExpectedConditions.alertIsPresent()).accept();

            cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Cart')]")));
            cartLink.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='success']"))); // Ensure cart has items

            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Place Order')]")));
            checkoutButton.click();

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

            WebElement purchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Purchase')]")));
            purchaseButton.click();

            WebElement thankYouMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Thank you for your purchase!')]")));
            if (!thankYouMessage.isDisplayed()) {
                throw new AssertionError("Thank you message not displayed");
            }
            System.out.println("Thank you for your purchase!");

            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'OK')]")));
            closeButton.click();

            homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Home')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeLink);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the driver
            driver.quit();
        }
    }
}
