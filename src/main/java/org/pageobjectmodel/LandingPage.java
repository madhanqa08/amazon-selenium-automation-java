package org.pageobjectmodel;
import abstractcomponents.Abstractclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Properties;

public class LandingPage extends Abstractclass
{
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement signButton;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchbar;

    @FindBy(id = "nav-search-submit-button")
    WebElement search;

    @FindBy(xpath = "//div[@class='sg-col-inner']//div[@data-cy='title-recipe']")
    List<WebElement> products;

    By skip = By.cssSelector(".a-button-text");

    By specificProduct = By.xpath("//div[@class='sg-col-inner']//div[@data-cy='title-recipe']");

    public void getUrl(String url)
    {
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void tryCatch()
    {
        try
        {
            WebElement element = driver.findElement(skip);
            element.click();
        }
        catch (Exception e)
        {
            System.out.println("Error------");
        }
    }

    public LoginPage setLoginButton()
    {
        waitUntiltheVisibilityoftheWebElement(signButton);
        LoginPage loginPage = new LoginPage(driver);
        signButton.click();
        return loginPage;
    }

    public List<WebElement> typeProductname(String productName)
    {
        waitUntiltheVisibilityoftheWebElement(searchbar);
        searchbar.sendKeys(productName);
        search.click();
        return products;
    }

    public void needProduct(List<WebElement> p,String p_name)
    {
        for (WebElement element : p)
        {
            if (element.getText().contains(p_name))
            {
                driver.findElement(specificProduct).click();
                break;
            }
        }
    }

    public ProductPage changeDriver(int index)
    {
        changeWindown(index);
        return new ProductPage(driver);
    }

    public void clickAddressBar()
    {
        setAddresschangeBtn();
    }

}
