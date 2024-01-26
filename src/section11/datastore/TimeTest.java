package src.section11.datastore;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TimeTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now.plus(3, ChronoUnit.YEARS));

        LocalDate newYears = LocalDate.of(2020, 1, 1);
        // newYears.datesUntil(LocalDate.now(), Period.ofMonths(1))
        //     .forEach(System.out::println);

        System.out.println(now.equals(newYears));

        LocalDate d1 = LocalDate.of(2000, 1, 1);
        LocalDate d2 = LocalDate.of(2002, 6, 1);
        System.out.println(d1.compareTo(d2));

        LocalTime lt1 = LocalTime.of(10, 30);
        LocalTime lt2 = LocalTime.of(10, 30, 1);
        System.out.println(lt1.equals(lt2));

        Period diff = Period.between(d1, d2);
        System.out.printf("%d years, %d months, %d days%n", diff.getYears(), diff.getMonths(), diff.getDays());

        System.out.println(Duration.between(lt1, lt2));

        LocalDateTime ldt1 = LocalDateTime.of(d1, lt1);

        System.out.println(ZonedDateTime.of(ldt1, ZoneId.of("-5")));
    }
}
