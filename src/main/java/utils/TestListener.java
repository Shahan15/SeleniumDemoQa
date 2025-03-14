package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener; // ITestListener is an interface provided by TestNG
import org.testng.ITestResult;

import static utils.Base.logger;


public class TestListener implements ITestListener {
    ExtentReports r = Base.reports;
    ExtentTest t;
    String SSPath = Base.takeScreenshot();

    @Override
    public void onTestSuccess(ITestResult result) {
        // This makes a new entry in the report with the name of the test that just ran
        String testName = "PASS: " + result.getName();
        t = r.createTest(testName);
        t.log(Status.PASS, "Results are expected");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = "FAIL Screenshot: " + result.getName();
        t = r.createTest(testName);
        t.log(Status.FAIL, "Results are NOT what was expected");
        try {
            t.addScreenCaptureFromPath(SSPath);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        r.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = "SKIPPED: " + result.getName();
        t = r.createTest(testName);
        t.log(Status.SKIP,"This test was not executed, it was skipped");
    }
}
