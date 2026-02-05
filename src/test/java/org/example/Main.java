package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.time.Duration;

public class Main
{
    @Test
    public static void positiveLoginTestcase()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        String url = driver.getCurrentUrl();
        System.out.println((url.contains("https://practicetestautomation.com/practice-test-login/") ? "url is verified " : "url is not verified"));
        String confirmationMessage = driver.findElement(By.xpath("//h1[.='Logged In Successfully']")).getText();
        System.out.println((confirmationMessage.contains("Logged In Successfully") ? "Login Text Confirmed " : "Login Text Not Confirmed"));
        boolean logoutButton = driver.findElement(By.xpath("//a[.='Log out']")).isDisplayed();
        System.out.println((logoutButton) ? "Logout button is displayed" : "Logout Button is not Displayed");
    }

    @Test
    public void negativeLoginTestcase()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("incorrectUser");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        boolean errorVisible= driver.findElement(By.id("error")).isDisplayed();
        System.out.println((errorVisible) ? "Error is displayed" : "Error is not Displayed");
        String errorLog = driver.findElement(By.id("error")).getText();
        System.out.println((errorLog.contains("Your username is invalid!") ? "Invalid Username Printed" : "Nothing Printed"));
    }

    @Test
    public void negativePassowrdTestcase()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("incorrectpassword");
        driver.findElement(By.id("submit")).click();
        boolean errorVisible= driver.findElement(By.id("error")).isDisplayed();
        System.out.println((errorVisible) ? "Error is displayed" : "Error is not Displayed");
        String errorLog = driver.findElement(By.id("error")).getText();
        System.out.println((errorLog.contains("Your username is invalid!") ? "Invalid  Printed" : "Nothing Printed"));
    }
}
