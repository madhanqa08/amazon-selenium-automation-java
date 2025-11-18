package org.pageobjectmodel;
import abstractcomponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopupsPage extends Abstractclass
{
    WebDriver driver;
    public PopupsPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //  driver.findElement(By.xpath("//span[@data-action='GLUXManageAddressLinkAction']")).click();
    @FindBy(xpath = "//span[@data-action='GLUXManageAddressLinkAction']")
    WebElement addAddressBtn;

    public void setAddAddressBtn()
    {
        waitUntiltheVisibilityoftheWebElement(addAddressBtn);
        addAddressBtn.click();
    }
}
