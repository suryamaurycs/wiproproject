package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(linkText = "Product")
    private WebElement productLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogin() {
        loginLink.click();
    }

    public void selectProduct() {
        productLink.click(); // Update with the actual locator and navigation steps to reach the product page
    }

    public boolean areCategoriesDisplayed() {
        // Add logic to verify categories are displayed
        return true;
    }
}
