package PageClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageOne {

    WebDriver webDriver;

    /* Constructor */
    public CheckoutPageOne(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    /* Locators */
    By firstNameLocator = By.id("first-name");
    By lastNameLocator = By.id("last-name");
    By postalCodeLocator = By.id("postal-code");
    By continueBtnLocator = By.id("continue");

    /* Actions */
    public void fillCheckoutCredentials(String myFirstName, String myLastName, String myPostalCode)
    {
        webDriver.findElement(firstNameLocator).sendKeys(myFirstName);
        webDriver.findElement(lastNameLocator).sendKeys(myLastName);
        webDriver.findElement(postalCodeLocator).sendKeys(myPostalCode);
        webDriver.findElement(continueBtnLocator).click();
    }
}
