package merge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class m3 {
	public static void main(String[] args) throws InterruptedException {
//      // Set the path to your chromedriver executable
//      System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

      // Initialize WebDriver
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      // Navigate to the Demoblaze website
      driver.get("https://www.demoblaze.com/index.html");

      // Click on the "About us" link
      WebElement aboutUsLink = driver.findElement(By.linkText("About us"));
      aboutUsLink.click();
      Thread.sleep(3000);
     // WebElement closeabout = driver.findElement(By.cssSelector("#videoModal > div > div > div.modal-footer > button"));
      WebElement closeabout = driver.findElement(By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button"));
      closeabout.click();
      driver.navigate().refresh();
}}