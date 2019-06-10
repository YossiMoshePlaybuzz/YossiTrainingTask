package infrastructure.utils.ui;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testcontainers.containers.DockerComposeContainer;
import org.testng.annotations.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class BaseTest extends BrowserManager {
    private  ExtentReports extent;
    private  ExtentTest test;
    private String reportFilePath = "C:/Automation/Reports/";
    private String reportFileName = "TestExecution";
    private static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());

    //private static DockerComposeContainer environment =
    //        new DockerComposeContainer
    //            (new File("docker-compose.yml"));

    @BeforeSuite
    public void doBeforeSuite() {
        //environment.start();
        InstanceReport();
    }

    @AfterSuite
    public void doAfterSuite() {
        //environment.stop();
        finalizeExtentReport();
    }

    @BeforeMethod
    @Parameters ({ "browserType" })
    public void DoBeforeMethod(@Optional("chrome") String browserType, Method method) throws ParserConfigurationException, SAXException, IOException {
        driver = getBrowser(browserType);
        System.out.println("start driver");
        setBrowserSettings(driver);

        //InitReportTest(method.getName().split("_")[0], method.getName().split("_")[1]);
        //test.log(LogStatus.PASS, "Test " + method.getName().split("_")[1] + " started");
    }

    @AfterMethod
    public void DoAfterMethod() {
        System.out.println("entered after method");
        driver.quit();
        //finalizeReportTest();
        System.out.println("after driver closed");
    }

    public void InstanceReport()  {
        extent = new ExtentReports(
                reportFilePath + "Execution_" + timeStamp + "/" +reportFileName + ".html");

    }

    public  void InitReportTest(String testName, String testDescription) {
        test = extent.startTest(testName, testDescription);
    }

    public  void finalizeReportTest() {
        test.log(LogStatus.PASS, "Test ended");
        extent.endTest(test);
    }

    public  void finalizeExtentReport() {
        extent.flush();
        extent.close();
    }
}
