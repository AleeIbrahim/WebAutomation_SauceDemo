package PageClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver webDriver;

    /* Constructor */
    public LoginPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    /* Locators */
    By usernameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By loginBtnLocator = By.id("login-button");

    /* Actions */
    public void setUsername(String myUsername)
    {
        webDriver.findElement(usernameLocator).sendKeys(myUsername);
    }
    public void setPassword(String myPassword)
    {
        webDriver.findElement(passwordLocator).sendKeys(myPassword);
    }
    public void clickLogin()
    {
        webDriver.findElement(loginBtnLocator).click();
    }
}
