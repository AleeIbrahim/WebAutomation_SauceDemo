package TestUtilities;

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

}
