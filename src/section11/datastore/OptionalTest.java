package src.section11.datastore;

import java.time.Year;
import java.util.Optional;

public class OptionalTest {
    record Car(String make, String model, Year year) {}
    record Person(String firstName, String lastName, Car car) {}
    public static void main(String[] args) {
        Optional<String> optMsg = Optional.of("Hello");
        System.out.println(optMsg);

        String msg2 = "catastrophe";
        Optional<String> optMsg2 = Optional.ofNullable(msg2);
        System.out.println(optMsg2.filter(s -> s.length() > 3).orElse("Invalid"));

        Person p1 = new Person("Fred", "Flinstone", new Car("Ford", "Bronco", Year.of(1970)));
        Person p2 = new Person("Mary", "Johnson", new Car("Ford", "Bronco", Year.of(2020)));

        Optional<Person> optPerson = Optional.of(p1);
        System.out.println(optPerson.map(Person::firstName).orElse("Unknown"));
    }
}
