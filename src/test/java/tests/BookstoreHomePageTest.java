package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import utils.WebDriverManager;


public class BookstoreHomePageTest {
    HomePage homepage = new HomePage();

    @Test
    public void navigatingToBookstoreHome() {
        //Clicking the book card on homepage
        homepage.ClickBookCard();

        //is login button present
        homepage.isLoginButtonPresent();


    }
//
//    @AfterClass
//    public void TearDown() {
//        webDriverManager.quitDriver();
//    }

    //implement pagefactory here.
    //provide method here to get driver
}
