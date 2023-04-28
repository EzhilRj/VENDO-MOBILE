package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

    public static ExtentReports extent;

    public static ExtentReports Getreporterobject() {

        String path = "E:\\Automation Workspace\\VENDO_MOBILE\\src\\main\\resources\\Reports";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Vendo Automation Results");
        reporter.config().setDocumentTitle("Test results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("QA Tester","EzhilRaj");

        return extent;
    }
}

