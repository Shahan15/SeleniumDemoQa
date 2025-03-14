package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener; // ITestListener is an interface provided by TestNG
import org.testng.ITestResult;

import static utils.PropertiesHandler.logger;
import static utils.PropertiesHandler.timestamp;

public class TestListener implements ITestListener {
    ExtentReports r = PropertiesHandler.reports;
    ExtentTest t;
    String SSPath = PropertiesHandler.takeScreenshot();

    @Override
    public void onTestSuccess(ITestResult result) {
        // This makes a new entry in the report with the name of the test that just ran
        t = r.createTest(result.getName());
        t.log(Status.PASS, "Results are expected");
        try {
            t.addScreenCaptureFromPath(SSPath);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        t = r.createTest(result.getName());
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
}
