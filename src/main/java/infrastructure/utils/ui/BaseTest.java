package infrastructure.utils.ui;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import infrastructure.utils.MyListener;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@Listeners(MyListener.class)
public class BaseTest extends BrowserManager {
    private  static ExtentReports extent;
    private String reportFilePath = "C:/Automation/Reports/";
    private String reportFileName = "TestExecution";
    private static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());

    public void startDockerCompose() throws IOException, InterruptedException {
        String command = "powershell.exe  docker-compose up";
        runProcess(command);
    }

    public void stopDockerCompose() throws IOException, InterruptedException {
        String command = "powershell.exe  docker-compose down";
        runProcess(command);
    }

    public void runProcess(String command) throws IOException, InterruptedException {
        Process powerShellProcess = Runtime.getRuntime().exec(command);
        powerShellProcess.waitFor(30, TimeUnit.SECONDS);
    }

    @BeforeSuite(alwaysRun = true)
    public void doBeforeSuite() throws IOException, InterruptedException {
        startDockerCompose();
        InstanceReport();
    }

    @AfterSuite(alwaysRun = true)
    public void doAfterSuite() throws IOException, InterruptedException {
        stopDockerCompose();
        finalizeExtentReport();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters ({ "browserType" })
    public void DoBeforeMethod(@Optional("chrome") String browserType, Method method) throws IOException {
        driver = getBrowser(browserType);
        setBrowserSettings(driver);
        InitReportTest(method.getName().split("_")[0], method.getName().split("_")[1]);
    }

    @AfterMethod(alwaysRun = true)
    public void DoAfterMethod() {
        driver.quit();
    }

    public void InstanceReport()  {
        extent = new ExtentReports(
                reportFilePath + "Execution_" + timeStamp + "/" +reportFileName + ".html");
    }

    public  void InitReportTest(String testName, String testDescription) {
        ExtentTest test = extent.startTest(testName, testDescription);
        test.log(LogStatus.PASS, "Test " + testDescription + " is running");
        extent.endTest(test);
    }

    public  void finalizeExtentReport() {
        extent.flush();
        extent.close();
    }
}
