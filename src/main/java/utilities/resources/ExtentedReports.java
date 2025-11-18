package utilities.resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentedReports
{
    public static ExtentReports getReport()
    {
        String path = System.getProperty("user.dir")+"//reports/index.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("Testing");
        sparkReporter.config().setDocumentTitle("Amazon Testing Report");
        sparkReporter.config().setTheme(Theme.DARK);

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester","Madhan Kumar");
        return extentReports;
    }
}
