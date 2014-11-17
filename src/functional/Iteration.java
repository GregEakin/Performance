package functional;

import org.approvaltests.Approvals;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * From chapter two.
 * Created by Greg on 11/16/2014.
 */
public class Iteration {
    private static final List<String> friends = Arrays.asList("Brian", "Nate", "Raju", "Sara", "Scott");

    static Predicate<String> startsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

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
        final List<String> uppercaseNames = friends.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());

        Approvals.verify(uppercaseNames.toString());
    }

    @Test
    public void sample3() throws Exception {
        final Predicate<String> startsWithN = name -> name.startsWith("N");

        Assert.assertEquals(1, friends.stream().filter(startsWithN).count());
    }

    @Test
    public void sample4() throws Exception {

        Assert.assertEquals(1, friends.stream().filter(startsWith("N")).count());
    }

    @Test
    public void sample5() throws Exception {
        final Function<String, Predicate<String>> startsWithLetter =
                (String letter) -> {
                    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                    return checkStarts;
                };

        Assert.assertEquals(1, friends.stream().filter(startsWithLetter.apply("N")).count());
    }

    @Test
    public void sample6() throws Exception {
        final Function<String, Predicate<String>> startsWithLetter =
                (String letter) -> (String name) -> name.startsWith(letter);

        Assert.assertEquals(1, friends.stream().filter(startsWithLetter.apply("N")).count());
    }

    @Test
    public void sample7() throws Exception {
        final Function<String, Predicate<String>> startsWithLetter =
                letter -> name -> name.startsWith(letter);

        Assert.assertEquals(1, friends.stream().filter(startsWithLetter.apply("N")).count());
    }
}
