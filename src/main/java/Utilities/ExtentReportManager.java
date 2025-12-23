package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public void onStart(ITestContext context) {
        // Initialize Spark Reporter
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Test Reports/MyTestReport.html");

        // Configure the report
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Regression Test Suite");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        // Initialize ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set system information
        extent.setSystemInfo("OS", System.getProperty("Windows 10"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Selenium Version", "4.36");
        extent.setSystemInfo("Tester Name", "Ali Ibrahim");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        /* create a new entry in the report */
//        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case PASSED is:" + result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
        test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
    }
    @Override
    public void onTestSkipped(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
