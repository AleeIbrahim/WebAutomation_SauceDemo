package TestCases;

import PageClasses.*;
import TestUtilities.ConfigUtil;
import TestUtilities.HelperMethods;
import Utilities.ExtentReportManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static Utilities.ExtentReportManager.extent;
import static Utilities.ExtentReportManager.test;

public class TestSuite_eCommerceTest {

    /*  Define Web Driver */
    WebDriver webDriver;

    @BeforeTest
    public void preTestExecution()
    {

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--password-store=basic");  // Disables Chrome password manager
//        options.addArguments("--disable-features=PasswordManager");

        /* Initialize WebDriver */
//        webDriver = new ChromeDriver(options);
        webDriver = new FirefoxDriver();
        /*  Set Implicit Wait for finding elements */
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigUtil.IMPLICIT_WAIT));
        /*  Maximize the browser window */
        webDriver.manage().window().maximize();
        /*  Open the browser with the Base URL */
        webDriver.get(ConfigUtil.BASE_URL);
        /*  Logging */
        System.out.println("Browser is launched with URL: " + ConfigUtil.BASE_URL);
    }

    @Test
    public void TC01_verifyEndToEndProcess()
    {
        /* Create Pages Objects to be used in test */
        LoginPage myLoginPage = new LoginPage(webDriver);
        ProductsPage myProductsPage = new ProductsPage(webDriver);
        ShopCartPage myShopCartPage = new ShopCartPage(webDriver);
        CheckoutPageOne myCheckoutPageOne = new CheckoutPageOne(webDriver);
        CheckoutPageTwo myCheckoutPageTwo = new CheckoutPageTwo(webDriver);
        CompleteCheckoutPage myCompleteCheckoutPage = new CompleteCheckoutPage(webDriver);

        /* Login using valid credentials */
        myLoginPage.setUsername(ConfigUtil.VALID_USR);
        myLoginPage.setPassword(ConfigUtil.VALID_PASS);
        myLoginPage.clickLogin();
        test = extent.createTest("End to End Process Test");
        test.log(Status.INFO, "Navigating to login page");

        /* Generate the random/unique products */
        int maxRandomProducts = HelperMethods.generateRandomInteger(ConfigUtil.MIN_RANDOM, ConfigUtil.MAX_RANDOM);
        Set<Integer> randomProductsIndex = HelperMethods.generateRandomNumbers(maxRandomProducts, ConfigUtil.MIN_RANDOM,ConfigUtil.MAX_RANDOM);

        /* Get their prices and calculate their sum */
        float expectedTotalPrice = 0;
        for(int index : randomProductsIndex)
        {
            expectedTotalPrice += myProductsPage.getProductPrice(index);
        }
        test.log(Status.INFO, "Calculated Total Price: " + expectedTotalPrice);

        /* Add random products to cart */
        for(int index : randomProductsIndex)
        {
            myProductsPage.addProductToCart(index);
        }
        test.log(Status.INFO, "Random products added to cart");

        /* Navigate to Cart Page */
        myProductsPage.goToShoppingCart();
        test.log(Status.INFO, "Navigating to Cart page");

        /* Proceed to checkout */
        myShopCartPage.goToCheckout();
        test.log(Status.INFO, "Navigating to Checkout page");

        /* Fill in required checkout information */
        myCheckoutPageOne.fillCheckoutCredentials(ConfigUtil.CHECKOUT_FIRSTNAME,
                                                ConfigUtil.CHECKOUT_LASTNAME,
                                                ConfigUtil.CHECKOUT_POSTALCODE);
        test.log(Status.INFO, "Credentials are filled successfully");

        /* Verify the total price on checkout page */
        float actualTotalPrice = myCheckoutPageTwo.getSubTotal();
        test.log(Status.INFO, "Checking calculated price ...");
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Total price is incorrect!");

        /* Verify order completion */
        myCheckoutPageTwo.clickFinish();
        test.log(Status.INFO, "Checking order completion ...");
        Assert.assertEquals(myCompleteCheckoutPage.getSuccessMessage(), ConfigUtil.SUCCESS_MESSAGE, "Order is not processed successfully!");

        /* Go back to Home Page */
        myCompleteCheckoutPage.goBackHome();
        test.log(Status.INFO, "Navigating back to Home page");
    }

    @AfterTest
    public void postTestExecution()
    {
        /*  Safely quit the Web Driver */
        if (webDriver != null) {
            webDriver.quit();
        }
        /* Logging */
        System.out.println("Browser is closed ...");
    }

}
