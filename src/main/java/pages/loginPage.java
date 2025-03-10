package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private WebDriver driver;

    //locators
    private By usernameBox = By.id("userName");
    private By passwordBox = By.id("password");
    private By loginButton = By.id("login");

    //constructor
    public loginPage(WebDriver driver) {
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

    public homePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        pressLoginButton();
        return new homePage(driver); // Navigating to Home Page
    }
}




