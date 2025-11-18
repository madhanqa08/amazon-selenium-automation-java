package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pageobjectmodel.AddressChangePage;
import org.pageobjectmodel.LandingPage;
import org.pageobjectmodel.LoginPage;
import org.pageobjectmodel.PopupsPage;
public class MiscellaneousTest
{
    public static void login(WebDriver driver)
    {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.tryCatch();
        landingPage.setLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("919952405983");
        loginPage.enterPassword("Universe9952@");
    }
    public static void addressChange(WebDriver driver)
    {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickAddressBar();
        PopupsPage popupsPage = new PopupsPage(driver);
        popupsPage.setAddAddressBtn();
        AddressChangePage addressChangePage  = new AddressChangePage(driver);
        addressChangePage.clickPlusIcon();
        String name = "Madhan Kumar B";
        String mobile ="9952405983";
        String pin = "600119";
        String add1 = "Sri Selvaganapathy Gents Pg Hostel";
        String add2 = "Kamala street near , Sholinganallur";
        String land = "near by Murugan Stores ,opp to Accenture";
        String city = "Chennai";
        addressChangePage.addAddress(name,mobile,pin,add1,add2,land,city);
    }


    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        login(driver);
        addressChange(driver);
    }
}
