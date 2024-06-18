package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {

    @FindBy(id = "cartur")
    private WebElement cartLink;

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    private WebElement checkoutButton;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement creditCardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    private WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(), 'Thank you for your purchase!')]")
    private WebElement thankYouMessage;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkout(String name, String country, String city, String cardNumber, String month, String year) {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        creditCardField.sendKeys(cardNumber);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
        purchaseButton.click();
    }

    public boolean isPurchaseSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(thankYouMessage)).isDisplayed();
    }
}
