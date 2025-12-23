package PageClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

    WebDriver webDriver;

    /* Constructor */
    public ProductsPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    /* Locators */
    By shoppingCartLocator = By.xpath("//div//a[@class = 'shopping_cart_link']");
    By productsAddToCartLocator = By.xpath("//button[contains(@class, 'btn_primary') or contains(@class, 'btn_secondary')]");
    By productsPricesLocator = By.xpath("//div[@class='pricebar']");


    /* Actions */
    public void goToShoppingCart()
    {
        webDriver.findElement(shoppingCartLocator).click();
    }

    public void addProductToCart(int index)
    {
        List<WebElement> allProducts = webDriver.findElements(productsAddToCartLocator);
        allProducts.get(index-1).click();
    }

    public float getProductPrice(int index)
    {
        List<WebElement> allProductsPrices = webDriver.findElements(productsPricesLocator);
        return Float.parseFloat(allProductsPrices.get(index-1).getText().replaceAll("[^\\d.-]", ""));
    }
}
