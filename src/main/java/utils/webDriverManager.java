package utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import static org.apache.logging.log4j.LogManager.getLogger;

public class webDriverManager {

    public static final Logger logger = getLogger(webDriverManager.class);
    public static WebDriver driver;
    private static Filehandler filehandler;

    public static WebDriver getDriver() {
        filehandler = new Filehandler();

        try {
            switch (filehandler.getProperty("browser").toLowerCase()) {
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
            String url = filehandler.getProperty("url");
            driver.get(url);
            logger.info("opening {}", url);
        }catch (Exception ex) {
            logger.error("error navigating to requested url {} ", ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    // Additional methods for other functionalities can be added here
}
