package functional;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * From chapter two.
 * Created by Greg on 11/16/2014.
 */
public class Iteration {
    private static final List<String> friends = Arrays.asList("Brian", "Nate", "Raju", "Sara", "Scott");

    @Test
    public void sample1() throws Exception {
        final List<String> uppercaseNames = new ArrayList<>();
        for (String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }

        Approvals.verify(uppercaseNames.toString());
    }

    @Test
    public void sample2() throws Exception {
        final List<String> uppercaseNames = new ArrayList<>();
        for (String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }

        Approvals.verify(uppercaseNames.toString());
    }
}
