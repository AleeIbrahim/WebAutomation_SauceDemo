package PageClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageTwo {

    WebDriver webDriver;

    /* Constructor */
    public CheckoutPageTwo(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    /* Locators */
    By priceSubTotalLocator = By.xpath("//div[contains(@class,'subtotal')]");
    By finishBtnLocator = By.id("finish");

    /* Actions */
    public float getSubTotal()
    {
        return Float.parseFloat(webDriver.findElement(priceSubTotalLocator).getText().replaceAll("[^\\d.-]", ""));
    }
    public void clickFinish()
    {
        webDriver.findElement(finishBtnLocator).click();
    }
}
