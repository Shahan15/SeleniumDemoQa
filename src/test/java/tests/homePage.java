package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.webDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//we extend this class to access the methods in webDriverManager
public class homePage extends webDriverManager {
    @FindBy(css = ".home-body > div > div:nth-child(6)") WebElement BookCard;
    @FindBy(id = "login") WebElement LoginButton;

    public homePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        logger.info("Pagefactory has be instantiated");
    }

    public void ClickBookCard () {
        BookCard.click();
        ScrollPage();
        logger.info("Book card on Homepage has been clicked");
    }

    public void ScrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver; //this allows you to execute JS code
        js.executeScript("arguments[0].scrollIntoView();", BookCard);
    }



/*PageFactory class is used to instantiate the
WebElements that are defined using @FindBy annotations.
How it works: Scanning for Annotations: When you call PageFactory.initElements(driver, this);,
Selenium scans the Page Object class (this) for fields annotated with '@FindBy.'
Locating Elements: For each field annotated with @FindBy, Selenium uses the provided 'driver' to
locate the corresponding web element on the web page.*/