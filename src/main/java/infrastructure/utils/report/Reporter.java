package infrastructure.utils.report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reporter {
    public static ExtentReports extent;
    public static ExtentTest test;
    private String reportFilePath = "C:/Automation/Reports/";
    private String reportFileName = "TestExecution";
    private static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());


    public void InstanceReport()  {
        extent = new ExtentReports(
                reportFilePath + "Execution_" + timeStamp + "/" +reportFileName + ".html");

    }

    public static void InitReportTest(String testName, String testDescription) {
        test = extent.startTest(testName, testDescription);
    }

    public static void finalizeReportTest() {
        extent.endTest(test);
    }

    public static void finalizeExtentReport() {
        extent.flush();
        extent.close();
    }
}
