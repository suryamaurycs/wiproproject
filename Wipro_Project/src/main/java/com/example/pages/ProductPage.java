package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(), 'Add to cart')]")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }
}
