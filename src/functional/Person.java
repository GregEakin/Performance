package functional;

/**
 * Created by Greg on 11/16/2014.
 */
public class Person {
    private final String name;
    private final int age;

    public Person(final String theName, int theAge) {
        name = theName;
        age = theAge;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int ageDifference(final Person other) {
        return age - other.age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
    }
}
