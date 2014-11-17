package functional;

import java.util.Arrays;
import java.util.List;

/**
 * From chapter one.
 * Created by Greg on 11/16/2014.
 */
public class Cities {
    public static void main(String[] args) {
        final List<String> cities = Arrays.asList("Anaheim", "Los Angles", "Chicago");

        System.out.println("Found Chicago?: " + cities.contains("Chicago"));

        cities.forEach(System.out::println);
    }
}
