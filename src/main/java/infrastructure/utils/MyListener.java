package infrastructure.utils;

import infrastructure.utils.ui.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;


public class MyListener implements ITestListener
{
    private Logger logger = LogManager.getLogger(MyListener.class);

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test " + result.getThrowable()+ " Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}

