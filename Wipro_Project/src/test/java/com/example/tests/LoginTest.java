package com.example.tests;

import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickLogin();
        loginPage.login(configReader.getProperty("username"), configReader.getProperty("password"));
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
    }
}
