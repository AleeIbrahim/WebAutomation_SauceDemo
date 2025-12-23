package PageClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopCartPage {

    WebDriver webDriver;

    /* Constructor */
    public ShopCartPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    /* Locators */
    By checkoutLocator = By.xpath("//div//button[@name = 'checkout']");

    /* Actions */
    public void goToCheckout()
    {
        webDriver.findElement(checkoutLocator).click();
    }
}
