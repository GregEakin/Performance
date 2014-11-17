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
        List<String> ascendingAge = people.stream()
                .sorted(Person::ageDifference)
                .map(Person::toString)
                .collect(Collectors.toList());
        String sortedPeople = String.join("\n", ascendingAge);
        Approvals.verify(sortedPeople);
    }

    @Test
    public void descendingAgeTest() throws Exception {
        List<String> descendingAge = people.stream()
                .sorted((person1, person2) -> person2.ageDifference(person1))
                .map(Person::toString)
                .collect(Collectors.toList());
        String sortedPeople = String.join("\n", descendingAge);
        Approvals.verify(sortedPeople);
    }

    @Test
    public void descendingAgeTest2() throws Exception {
        Comparator<Person> compareAscending = Person::ageDifference;
        Comparator<Person> compareDescending = compareAscending.reversed();

        List<String> descendingAge = people.stream()
                .sorted(compareDescending)
                .map(Person::toString)
                .collect(Collectors.toList());
        String sortedPeople = String.join("\n", descendingAge);
        Approvals.verify(sortedPeople);
    }
}
