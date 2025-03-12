package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.WebDriverManager;


public class BookstoreHomePageTest {
    HomePage homepage = new HomePage();
    String testTitle = "navigatingToBookstoreHome";

    @Test
    public void navigatingToBookstoreHome() {
        //Clicking the book card on homepage
        WebDriverManager.test = WebDriverManager.reports.createTest(testTitle);
        WebDriverManager.logger.info("starting "+ testTitle+ "test");
        homepage.ClickBookCard();
        WebDriverManager.test.pass("Bookstore home card has been clicked successfully");

        //is login button present
        Assert.assertEquals(homepage.isLoginButtonPresent(),true);
        WebDriverManager.test.pass("Login Button is present, visible");

        //flush method
        WebDriverManager.reportFlush();

    }
//
//    @AfterClass
//    public void TearDown() {
//        webDriverManager.quitDriver();
//    }

}
