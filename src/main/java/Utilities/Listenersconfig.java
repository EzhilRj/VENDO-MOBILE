package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenersconfig extends Utils implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReportNG.Getreporterobject();
    AppiumDriver driver;

    @Override
    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }

    @Override
    public void onStart(ITestContext context) {

        ITestListener.super.onStart(context);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        try{

            test.addScreenCaptureFromPath(Screenshot(result.getMethod().getMethodName(),driver),null);
        }catch (Exception e){

            e.printStackTrace();
        }

    }
}
