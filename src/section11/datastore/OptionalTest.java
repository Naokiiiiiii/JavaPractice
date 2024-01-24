package src.section11.datastore;

import java.time.Year;
import java.util.Optional;

public class OptionalTest {
    record Car(String make, String model, Year year) {}
    record Person(Long id, String firstName, String lastName, Optional<Car> car) implements Repository.IDable<Long>, Repository.Saveable {}
    public static void main(String[] args) {
        Repository<Person, Long> repo = new Repository<>();
        Optional<String> optMsg = Optional.of("Hello");
        System.out.println(optMsg);

        String msg2 = "catastrophe";
        Optional<String> optMsg2 = Optional.ofNullable(msg2);
        System.out.println(optMsg2.filter(s -> s.length() > 3).orElse("Invalid"));

        Person p1 = new Person(100L, "Fred", "Flinstone", Optional.of(new Car("Ford", "Bronco", Year.of(1970))));
        Person p2 = new Person(200L, "Mary", "Johnson", Optional.of(new Car("Ford", "Bronco", Year.of(2020))));

        repo.save(p1);
        repo.save(p2);

        String fName = repo.findById(200L)
            .map(Person::firstName)
            .orElse("Firstname not found");
        System.out.println(fName);

        Optional<Person> optPerson = Optional.of(p1);
        System.out.println(optPerson
            .flatMap(Person::car)
            .map(Car::make)
            .orElse("Unknown"));
    }
}
