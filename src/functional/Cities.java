package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * From chapter one.
 * Created by Greg on 11/16/2014.
 */
public class Cities {
    private static final List<String> cities = Arrays.asList("Anaheim", "Los Angles", "Chicago");

    public static void main(String[] args) {
        System.out.println("Found Chicago?: " + cities.contains("Chicago"));

        cities.forEach(System.out::println);
    }

    @Test
    public void checkCitiesTest() throws Exception {
        Assert.assertTrue(cities.contains("Chicago"));
        Assert.assertFalse(cities.contains("New York"));
    }
}
