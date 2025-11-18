package org.pageobjectmodel;
import abstractcomponents.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AddressChangePage  extends Abstractclass
{
    WebDriver driver;
    public AddressChangePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='ya-myab-plus-address-icon']")
    WebElement plusIcon;

    public void clickPlusIcon()
    {
        waitUntiltheVisibilityoftheWebElement(plusIcon);
        plusIcon.click();
    }
    //
    //        driver.findElement(By.xpath("//div[@class='a-section a-spacing-double-large']//a[@aria-label='Delete this address']")).click();
    //        Thread.sleep(3000L);
    //        driver.findElement(By.xpath("//span[@id='deleteAddressModal-0-submit-btn']")).click();

    @FindBy(xpath = "//div[@class='a-section a-spacing-double-large']//a[@aria-label='Delete this address']")
    WebElement removeBtn;

    @FindBy(xpath = "//span[@id='deleteAddressModal-0-submit-btn']")
    WebElement yesDelete;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
    WebElement name;

    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    WebElement mobile;

    @FindBy(id = "address-ui-widgets-enterAddressPostalCode")
    WebElement pin;

    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    WebElement address1;

    @FindBy(id = "address-ui-widgets-enterAddressLine2")
    WebElement address2;

    @FindBy(id = "address-ui-widgets-landmark")
    WebElement landmark;

    @FindBy(id = "address-ui-widgets-enterAddressCity")
    WebElement city;

    @FindBy(id = "address-ui-widgets-use-as-my-default")
    WebElement setDefaultAddress;

    @FindBy(xpath ="//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']" )
    WebElement submit;

    public void addAddress(String myName,String mymobile,String mypin,String add1,String add2,String land,String mycit)
    {
        name.sendKeys(myName);
        mobile.sendKeys(mymobile);
        pin.clear();
        pin.sendKeys(mypin);
        address1.sendKeys(add1);
        address2.sendKeys(add2);
        landmark.sendKeys(land);
        city.sendKeys(mycit);
        setDefaultAddress.click();
        submit.click();
    }


    public void removeAddress()
    {
        waitUntiltheVisibilityoftheWebElement(removeBtn);
        removeBtn.click();
        waitUntiltheVisibilityoftheWebElement(yesDelete);
        yesDelete.click();
    }


}
