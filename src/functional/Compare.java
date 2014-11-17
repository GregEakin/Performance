package functional;

import org.approvaltests.Approvals;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Greg on 11/16/2014.
 */
public class Compare {
    final List<Person> people = Arrays.asList(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35));

    @Test
    public void ascendingAgeTest() throws Exception {
        List<Person> ascendingAge = people.stream()
                .sorted(Person::ageDifference)
                .collect(Collectors.toList());
        Approvals.verifyAll("ascendingAge", ascendingAge);
    }

    @Test
    public void descendingAgeTest() throws Exception {
        List<Person> descendingAge = people.stream()
                .sorted((person1, person2) -> person2.ageDifference(person1))
                .collect(Collectors.toList());
        Approvals.verifyAll("descendingAge", descendingAge);
    }

    @Test
    public void descendingAgeTest2() throws Exception {
        Comparator<Person> compareAscending = Person::ageDifference;
        Comparator<Person> compareDescending = compareAscending.reversed();

        List<Person> descendingAge = people.stream()
                .sorted(compareDescending)
                .collect(Collectors.toList());
        Approvals.verifyAll("descendingAge", descendingAge);
    }

    @Test
    public void descendingAgeTest3() throws Exception {
        List<Person> descendingAge = people.stream()
                .sorted(((Comparator<Person>) Person::ageDifference).reversed())
                .collect(Collectors.toList());
        Approvals.verifyAll("descendingAge", descendingAge);
    }

    @Test
    public void ascendingNameTest() throws Exception {
        Comparator<Person> compareAscending = (person1, person2) -> person1.getName().compareTo(person2.getName());

        List<Person> ascendingName = people.stream()
                .sorted(compareAscending)
                .collect(Collectors.toList());
        Approvals.verifyAll("ascendingName", ascendingName);
    }

    @Test
    public void ascendingNameTest2() throws Exception {
        final Function<Person, String> byName = person -> person.getName();

        List<Person> ascendingName = people.stream()
                .sorted(Comparator.comparing(byName))
                .collect(Collectors.toList());
        Approvals.verifyAll("ascendingName", ascendingName);
    }

    @Test
    public void youngestAgeTest() throws Exception {
        Optional<Person> youngest = people.stream()
                .min(Person::ageDifference);
        Assert.assertTrue(youngest.isPresent());
        Assert.assertEquals(people.get(0), youngest.get());
    }

    @Test
    public void eldestAgeTest() throws Exception {
        Optional<Person> eldest = people.stream()
                .max(Person::ageDifference);
        Assert.assertTrue(eldest.isPresent());
        Assert.assertEquals(people.get(3), eldest.get());
    }
}
