package org.pageobjectmodel;

import abstractcomponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Abstractclass
{
    WebDriver driver;

    public ProductPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //  WebElement addToCart =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
    //        addToCart.click();

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCart;

    @FindBy(css = ".a-link-normal.attach-close-button")
    WebElement closesideBar;


    public void setAddToCart()
    {
        waitUntiltheVisibilityoftheWebElement(addToCart);
        addToCart.click();
        waitUntiltheVisibilityoftheWebElement(closesideBar);
        closesideBar.click();
    }

    public CheckoutPage clickCart()
    {
        clickCartButton();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage;

    }
}
