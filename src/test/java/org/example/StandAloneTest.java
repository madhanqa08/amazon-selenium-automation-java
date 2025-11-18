package org.example;
import Testcomponents.BaseTest;
import Testcomponents.Retry;
import org.openqa.selenium.WebElement;
import org.pageobjectmodel.CheckoutPage;
import org.pageobjectmodel.LoginPage;
import org.pageobjectmodel.ProductPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
public class StandAloneTest extends BaseTest
{
    @Test(dataProvider = "LoginCredentials" , retryAnalyzer = Retry.class)
    public void run(HashMap<String,String> map)
    {
        landingPage.tryCatch();
        LoginPage loginPage = landingPage.setLoginButton();
        loginPage.enterUsername(map.get("username"));
        loginPage.enterPassword(map.get("password"));
        String productName = "Headset";
        List<WebElement> productname = landingPage.typeProductname(productName);
        String productNeed = "Boat Bassheads 900 Pro Wired Headphones with 40Mm Drivers, Lightweight Foldable Design, Over Ear, Remote Control, Unidirectional Retractable Mic, Adjustable Headband & USB Type-A Compatibility(Black)";
        landingPage.needProduct(productname, productNeed);
        ProductPage productPage = landingPage.changeDriver(1);
        productPage.setAddToCart();
        CheckoutPage checkoutPage = productPage.clickCart();
        checkoutPage.clickProceed();
        checkoutPage.proceedCod();
        checkoutPage.placeOrder();
    }

    @DataProvider(name = "LoginCredentials")
    public Object[][] getData() throws IOException
    {
        String credentialsfile = System.getProperty("user.dir")+"//src//test//java//data//logincredentials//credentiasl.json";
        List<HashMap<String,String>> data = getJsonData(credentialsfile);

        return new Object[][] {{data.get(0)}};
    }
}
