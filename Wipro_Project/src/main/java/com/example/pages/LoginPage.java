package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.sendKeys(username);

        wait.until(ExpectedConditions.visibilityOf(passwordField));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        // Replace with actual logic to verify successful login
        return true;
    }
}
