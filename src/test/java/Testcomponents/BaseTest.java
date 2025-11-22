package Testcomponents;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.pageobjectmodel.LandingPage;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
public class BaseTest
{
    //1. Initilize webDriver
    //2. get data from Json
    //3. launch application
    //4. take screen shoot
   public WebDriver driver;
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public LandingPage landingPage;

    public WebDriver getDriver()
    {
        return tlDriver.get();
    }

    public WebDriver initilizeDriver() throws IOException
    {
        // 1. create properties class object
        // 2. create a fileinputstream class object
        //3. load the file into properties and call the browser using property

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//GlobalData.properties");
        properties.load(fileInputStream);

        String browser= System.getProperty("browser")!=null ? System.getProperty("browser") : properties.getProperty("browser");
        if(browser.contains("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            if(browser.contains("headless"))
            {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException
    {
        driver = initilizeDriver();
        tlDriver.set(driver);
        landingPage = new LandingPage(driver);
        landingPage.getUrl("https://www.amazon.in/");
        return landingPage;
    }

    public List<HashMap<String,String>> getJsonData(String filePath) throws IOException
    {
        // import depencency 1. commons.io 2. jackson binder
        // 1. convert json to String
        // 2. convert string to jackson file
        String file = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(file, new TypeReference<>()
        {
        });
    }



    public String takeScreenShoot(String testcaseName) throws IOException
    {
        WebDriver driver = getDriver();  // USE ThreadLocal driver

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";
        File directory = new File(folderPath);
        if (!directory.exists())
            directory.mkdirs();

        String fileName = testcaseName + "_" + System.currentTimeMillis() + ".png";
        File fullPath = new File(folderPath + fileName);

        FileUtils.copyFile(src, fullPath);

        return "screenshots/" + fileName;
    }



}
