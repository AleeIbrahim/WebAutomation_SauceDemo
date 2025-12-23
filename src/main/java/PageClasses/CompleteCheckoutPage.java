package PageClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompleteCheckoutPage {

    WebDriver webDriver;

    /* Constructor */
    public CompleteCheckoutPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    /* Locators */
    By completionMsgLocator = By.xpath("//div//h2[@class = 'complete-header']");
    By backHomeBtnLocator = By.id("back-to-products");

    /* Actions */
    public String getSuccessMessage()
    {
        return webDriver.findElement(completionMsgLocator).getText();
    }
    public void goBackHome()
    {
        webDriver.findElement(backHomeBtnLocator).click();
    }
}
