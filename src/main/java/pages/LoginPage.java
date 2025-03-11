package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //locators
    private By usernameBox = By.id("userName");
    private By passwordBox = By.id("password");
    private By loginButton = By.id("login");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameBox).sendKeys(username);
    }

    public void enterPassword(String password ) {
        driver.findElement(passwordBox).sendKeys(password);
    }

    public void pressLoginButton() {
        driver.findElement(loginButton).click();
    }

    public BookstoreHomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        pressLoginButton();
        return new BookstoreHomePage(driver); // Navigating to Home Page
    }
}




