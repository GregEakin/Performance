package functional;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
}
