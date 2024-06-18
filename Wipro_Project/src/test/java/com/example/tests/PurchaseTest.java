package com.example.tests;

import com.example.pages.HomePage;
import com.example.pages.ProductPage;
import com.example.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void testPurchase() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickLogin();
        // Login process (you can abstract this out as a utility method)

        productPage.addToCart();
        // Handle alert

        cartPage.checkout(configReader.getProperty("name"), configReader.getProperty("country"),
                configReader.getProperty("city"), configReader.getProperty("cardNumber"),
                configReader.getProperty("month"), configReader.getProperty("year"));
        // Validate purchase success message
    }
}
