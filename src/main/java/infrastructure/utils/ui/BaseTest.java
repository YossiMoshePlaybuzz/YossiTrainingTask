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
    private static int timeout = 25;
    private static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                                            .format(Calendar.getInstance().getTime());


    public void runProcess(String command,int timeout) throws IOException, InterruptedException {
        Process powerShellProcess = Runtime.getRuntime().exec(command);
        powerShellProcess.waitFor(timeout, TimeUnit.SECONDS);
    }

    public void startDockerCompose()  {
        String command = "powershell.exe  docker-compose up";
        try {
            runProcess(command,timeout);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopDockerCompose(){
        String command = "powershell.exe  docker-compose down";
        try {
            runProcess(command,5);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void doBeforeSuite()  {
        startDockerCompose();
        InstanceReport();
    }

    @AfterSuite(alwaysRun = true)
    public void doAfterSuite()  {
        stopDockerCompose();
        finalizeExtentReport();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters ({ "browserType" })
    public void DoBeforeMethod(@Optional("chrome") String browserType, Method method) {
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
