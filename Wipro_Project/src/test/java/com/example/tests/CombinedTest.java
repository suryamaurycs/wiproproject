package com.example.tests;

import com.example.pages.CartPage;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.example.pages.ProductPage;
import com.example.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CombinedTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private ConfigReader configReader;

    @BeforeMethod
    public void setUp() {
        configReader = new ConfigReader();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(configReader.getProperty("baseURL"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCompleteFlow() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Login
        homePage.clickLogin();
        loginPage.login(configReader.getProperty("username"), configReader.getProperty("password"));
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");

        // Verify categories
        Assert.assertTrue(homePage.areCategoriesDisplayed(), "Categories are not displayed");

        // Navigate to the product page and add product to cart
        homePage.selectProduct(); // Add a method to navigate to the product page
        productPage.addToCart();
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        // Checkout process
        cartPage.checkout(
                configReader.getProperty("name"),
                configReader.getProperty("country"),
                configReader.getProperty("city"),
                configReader.getProperty("cardNumber"),
                configReader.getProperty("month"),
                configReader.getProperty("year")
        );

        // Validate purchase success message
        Assert.assertTrue(cartPage.isPurchaseSuccessful(), "Purchase was not successful");
    }
}
