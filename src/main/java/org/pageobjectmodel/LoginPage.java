package org.pageobjectmodel;
import abstractcomponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends Abstractclass
{
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "ap_email_login")
    WebElement usernameEnter;

    @FindBy(css = ".a-button-input")
     WebElement continueBnt;

    @FindBy(id = "ap_password")
    WebElement enterpassowrd;

    @FindBy(id = "signInSubmit")
    WebElement signIn;

    public void enterUsername(String name)
    {
       waitUntiltheVisibilityoftheWebElement(usernameEnter);
        usernameEnter.sendKeys(name);
        continueBnt.click();
    }

    public void enterPassword(String passowrd)
    {
        waitUntiltheVisibilityoftheWebElement(enterpassowrd);
        enterpassowrd.sendKeys(passowrd);
        signIn.click();
    }

}
