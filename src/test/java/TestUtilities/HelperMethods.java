package TestUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class HelperMethods {

    public static int generateRandomInteger(int min, int max)
    {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static Set<Integer> generateRandomNumbers(int maxRandomProducts, int min, int max)
    {
        Set<Integer> randomProductsIndex = new HashSet<>();
        while(randomProductsIndex.size() < maxRandomProducts)
        {
            randomProductsIndex.add(ThreadLocalRandom.current().nextInt(min, max + 1));
        }
        return randomProductsIndex;
    }

    public static WebDriver getChromeDriverWithoutPasswordPopup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:/temp/selenium-profile-" + System.currentTimeMillis());
        options.addArguments("--disable-sync");
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--incognito");

        return new ChromeDriver(options);

    }

}
