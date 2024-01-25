package src.section11.datastore;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TimeTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now.plus(3, ChronoUnit.YEARS));

        LocalDate newYears = LocalDate.of(2020, 1, 1);
        newYears.datesUntil(LocalDate.now(), Period.ofMonths(1))
            .forEach(System.out::println);

        System.out.println(now.equals(newYears));
    }
}
