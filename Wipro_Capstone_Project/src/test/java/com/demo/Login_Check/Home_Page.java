package com.demo.Login_Check;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.TestNG;

import java.util.Collections;
import java.util.List;

public class Home_Page {

    WebDriver driver =null;

    @BeforeClass
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
    	
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void homePageTest() throws InterruptedException {
        // Open the website
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(4000);

        // Verify the title of the page
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "STORE");

		
		  // Interact with Home, Contact, About Us, Cart, and Login elements WebElement
		  //WebElement homeLink = driver.findElement(By.linkText("Home")); 
		  WebElement contactLink =driver.findElement(By.linkText("Contact"));
		  WebElement aboutUsLink = driver.findElement(By.linkText("About us")); 
		  WebElement cartLink =driver.findElement(By.linkText("Cart"));
		  WebElement loginLink =driver.findElement(By.linkText("Log in"));
		 
		
		  // Verify that the elements are displayed
		  //Assert.assertTrue(homeLink.isDisplayed());
		  Assert.assertTrue(contactLink.isDisplayed());
		  Assert.assertTrue(aboutUsLink.isDisplayed());
		  Assert.assertTrue(cartLink.isDisplayed());
		  Assert.assertTrue(loginLink.isDisplayed());
		 

		
		  // Print out the names of the categories 
		  System.out.println("Home Page Categories List :");
		  List<WebElement> categories =
		  driver.findElements(By.cssSelector("#itemc"));
		  for (WebElement category :categories)
		  { 
			  System.out.println("Category: " + category.getText()); 
		  }
			
			 
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	/*
	 * public static void main(String[] args) { TestNG testng = new TestNG();
	 * testng.setTestSuites(Collections.singletonList("testng.xml")); testng.run();
	 * }
	 */
}