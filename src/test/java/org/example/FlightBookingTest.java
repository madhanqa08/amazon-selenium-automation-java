package org.example;
import Testcomponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.pageobjectmodel.LoginPage;
import org.testng.annotations.Test;
import java.util.List;
public class FlightBookingTest extends BaseTest
{


    @Test
    public void bookFlight() throws InterruptedException
    {
        landingPage.tryCatch();
        LoginPage loginPage = landingPage.setLoginButton();

        loginPage.enterUsername("919952405983");
        loginPage.enterPassword("Universe9952@");


        driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();

        Actions actions = new Actions(driver);
        WebElement expand = driver.findElement(By.xpath("(//a[@class='hmenu-item hmenu-compressed-btn'])[2]"));
        actions.moveToElement(expand).perform();
        expand.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@class='hmenu-compress-section']//*[contains(text(),'Flight Tickets')]"))
                .click();

        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@name='searchText']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='searchText']")).sendKeys("Coimbato");

        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_4e0ac60f _360de181 ad23ce76']"));

        for (WebElement e : elements) {
            System.out.println(e.getText());
        }
    }
}
