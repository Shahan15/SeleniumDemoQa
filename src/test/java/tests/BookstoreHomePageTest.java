package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Base;


@Listeners(utils.TestListener.class)
public class BookstoreHomePageTest {
    HomePage homepage = new HomePage();
    String testTitle = "navigating To Bookstore-Home";

    @Test
    public void navigatingToBookstoreHome() {
        //Clicking the book card on homepage
        Base.test = Base.reports.createTest(testTitle);
        Base.logger.info("starting "+ testTitle+ "test");
        homepage.ClickBookCard();
        Base.test.pass("Bookstore home card has been clicked successfully");

        //is login button present
        Assert.assertEquals(homepage.isLoginButtonPresent(),true);
        Base.test.pass("Login Button is present, visible");

        //flush method
        Base.reportFlush();

    }

    @AfterClass
    public void TearDown() {
        Base.quitDriver();
    }

}

//need to add a screenshot if something is not working
