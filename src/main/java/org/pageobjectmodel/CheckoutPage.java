package org.pageobjectmodel;
import abstractcomponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Abstractclass
{
    public WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "proceedToRetailCheckout")
    WebElement proceed;

    @FindBy(xpath = "(//input[@name='ppw-instrumentRowSelection'])[8]")
    WebElement cod;

    @FindBy(xpath = "//input[@data-csa-c-slot-id='checkout-secondary-continue-payselect']" )
    WebElement pay;

    @FindBy(id = "placeOrder")
    WebElement placeOrder;

    public void clickProceed()
    {
        proceed.click();
    }

    public void proceedCod()
    {
        doAction(cod);
        cod.click();
        pay.click();
    }
    public void placeOrder()
    {
        placeOrder.click();
    }
}
