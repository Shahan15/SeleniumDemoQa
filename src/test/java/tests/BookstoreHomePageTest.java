package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.PropertiesHandler;


@Listeners(utils.TestListener.class)
public class BookstoreHomePageTest {
    HomePage homepage = new HomePage();
    String testTitle = "navigatingToBookstoreHome";

    @Test
    public void navigatingToBookstoreHome() {
        //Clicking the book card on homepage
        PropertiesHandler.test = PropertiesHandler.reports.createTest(testTitle);
        PropertiesHandler.logger.info("starting "+ testTitle+ "test");
        homepage.ClickBookCard();
        PropertiesHandler.test.pass("Bookstore home card has been clicked successfully");

        //is login button present
        Assert.assertEquals(homepage.isLoginButtonPresent(),true);
        PropertiesHandler.test.pass("Login Button is present, visible");

        //flush method
        PropertiesHandler.reportFlush();

    }

    @AfterClass
    public void TearDown() {
        PropertiesHandler.quitDriver();
    }

}

//need to add a screenshot if something is not working
