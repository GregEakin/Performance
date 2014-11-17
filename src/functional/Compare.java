package functional;

import org.approvaltests.Approvals;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
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
    public void ascendingAgeAndNameTest() throws Exception {
        final Function<Person, Integer> byAge = person -> person.getAge();
        final Function<Person, String> byName = person -> person.getName();

        List<Person> ascendingAgeAndName = people.stream()
                .sorted(Comparator.comparing(byAge).thenComparing(byName))
                .collect(Collectors.toList());
        Approvals.verifyAll("ascendingAgeAndName", ascendingAgeAndName);
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

    @Test
    public void olderThan20() throws Exception {
        List<Person> olderThanTwenty = people.stream()
                .filter(person -> person.getAge() > 20)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        Approvals.verifyAll("olderThanTwenty", olderThanTwenty);
    }

    @Test
    public void groupByAge() throws Exception {
        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        Approvals.verify(peopleByAge);
    }

    @Test
    public void PersonsNameByAge() throws Exception {
        Map<Integer, List<String>> nameOfPeopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
        Approvals.verify(nameOfPeopleByAge);
    }

    @Test
    public void OldestByFirstChar() throws Exception {
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        Map<Character, Optional<Person>> oldestPersonOfEachLetter = people.stream()
                .collect(Collectors.groupingBy(person -> person.getName().charAt(0),
                        Collectors.reducing(BinaryOperator.maxBy(byAge))));

        Approvals.verify(oldestPersonOfEachLetter);
    }
}
