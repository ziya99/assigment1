

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.testng.Assert.*;

public class task1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/admin/Documents/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();//


        driver.get("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php");

        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains("Welcome to Duotify!"));

        driver.findElement(By.id("hideLogin")).click();

        String s = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPGTSTIVWXYZ";
        String username = "";
        for (int i = 0; i < 8; i++) {
            username += s.charAt((int) (Math.random() * s.length()));
        }
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("firstName")).sendKeys("Ziko");
        driver.findElement(By.id("lastName")).sendKeys("Zikoo");
        String email = username + "@gmail.com";
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("email2")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Ziko3y55");
        driver.findElement(By.id("password2")).sendKeys("Ziko3y55" + Keys.ENTER); // 5. Click on Sign up

        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));

        assertTrue(driver.getPageSource().contains("Ziko Zikoo"));

        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("rafael")).click(); // logout

        Thread.sleep(2000);
        String actualUrl2 = driver.getCurrentUrl();
        assertTrue(actualUrl2.contains("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php"));
        Thread.sleep(2000);

        driver.findElement(By.id("loginUsername")).sendKeys(username);
        driver.findElement(By.id("loginPassword")).sendKeys("Ziko3y55" + Keys.ENTER);

        Thread.sleep(2000);
        System.out.println(driver.getPageSource().contains("You Might Also Like"));

        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("rafael")).click();
        driver.quit();




    }
}
