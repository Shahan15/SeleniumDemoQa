package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.logging.log4j.LogManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PropertiesHandler {

    public static final Logger logger = LogManager.getLogger(PropertiesHandler.class);
    public static WebDriver driver;
    private static Filehandler filehandler;
    public static ExtentReports reports;
    public static ExtentTest test;

     static String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());


    public PropertiesHandler() {
        setUpExtentReport();
    }

    public static WebDriver getDriver() {
        try {
            //readfile is static so don't need to instantiate Filehandler
            String browser = Filehandler.readFile("browser");
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    logger.info("Chrome has been selected");
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    logger.info("Edge has been selected");
                    break;
                default:
                    driver = new ChromeDriver();
                    logger.info("Default browser has been selected - Chrome");
                    break;
            }
        } catch (Exception ex) {
            logger.error("There was an error initializing {}", ex.getMessage());
            System.out.println(ex.getMessage());
        }

        driver.manage().window().maximize();

        //Going to URL that we are testing
        getUrl();

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("Closing browser");
        }
    }
    public static void getUrl() {
        try{
            String url = Filehandler.getProperty("url");
            driver.get(url);
            logger.info("opening {}", url);
        }catch (Exception ex) {
            logger.error("error navigating to requested url {} ", ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }


    public ExtentReports setUpExtentReport () {
        String temp = Filehandler.reports +"TestReport_"+timestamp+".html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(temp);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Selenium Test Results");
        htmlReporter.config().setTheme(Theme.STANDARD);

        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        logger.info("Setting up Extent Reports on:- ");
        return reports;
    }

    public static void reportFlush() {
        reports.flush();
        logger.info("Cleaning extent reports");
    }

    public static String takeScreenshot() {
        // Takes screenshot
        File SS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String SFile = Filehandler.screenshotPath + "img"+ timestamp + ".png";
        try {
            FileUtils.copyFile(SS,new File(SFile));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return SFile;
    }

     //Additional methods for other functionalities can be added here
}
