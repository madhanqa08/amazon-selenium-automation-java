package org.pageobjectmodel;
import abstractcomponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ConformationPage extends Abstractclass
{
    WebDriver driver;
    public ConformationPage( WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

     @FindBy(id = "placeOrder")
    WebElement confirm;

    public void confirmOrder()
    {
        waitUntiltheVisibilityoftheWebElement(confirm);
        confirm.click();
    }

}
