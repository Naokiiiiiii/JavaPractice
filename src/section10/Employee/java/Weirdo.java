package src.section10.Employee.java;

import java.time.LocalDate;

public record Weirdo(String lastName, String firstName, LocalDate dob) {
    public Weirdo(String lastName, String firstName) {
        this(lastName, firstName, LocalDate.of(1, 1, 1));
    }

    public String sayHello() {
        return "Hello World";
    }
}