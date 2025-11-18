package abstractcomponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class Abstractclass
{
    WebDriver driver;
    // webdriver instance

    public Abstractclass(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "nav-cart-count-container")
    WebElement cartBtn;

    // driver.findElement(By.xpath("//span[@id='nav-global-location-data-modal-action']")).click();

    @FindBy(xpath = "//span[@id='nav-global-location-data-modal-action']")
    WebElement addresschangeBtn;

    public void waitUntiltheVisibilityoftheElementBy(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntiltheVisibilityoftheWebElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void changeWindown(int page)
    {
        Set<String> window = driver.getWindowHandles();
        List<String> pages = new ArrayList<>(window);
        driver.switchTo().window(pages.get(page));
    }

    public void doAction(WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }
    public void clickCartButton()
    {
        doAction(cartBtn);
        cartBtn.click();
    }

    public void setAddresschangeBtn()
    {
        waitUntiltheVisibilityoftheWebElement(addresschangeBtn);
        addresschangeBtn.click();
    }

}
